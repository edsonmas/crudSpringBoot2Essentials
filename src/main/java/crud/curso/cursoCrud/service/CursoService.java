package crud.curso.cursoCrud.service;

import crud.curso.cursoCrud.domain.Curso;
import crud.curso.cursoCrud.exception.BadRequestException;
import crud.curso.cursoCrud.mapper.CursoMapper;
import crud.curso.cursoCrud.repository.CursoRepository;
import crud.curso.cursoCrud.dto.CursoCreateDto;
import crud.curso.cursoCrud.dto.CursoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;


    public List<Curso> listAll() {

        List<Curso> listaRetornada = cursoRepository.findAll();
        return listaRetornada;
    }

    public List<Curso> findByNomeCursoOrThrowBadRequestException(String nomeCurso) {
        if (nomeCurso.isBlank()){
            throw new BadRequestException("Nenhum parametro de busca foi passado");
        }
        return cursoRepository.findByNomeCurso(nomeCurso);
    }

    public Curso findByIdOrThrowBadRequestException(long id) {
        return cursoRepository.findById(id)
                .orElseThrow(()->new BadRequestException("Curso id not found"));
    }

    @Transactional
    public Curso save(CursoCreateDto cursoCreateDto) {
        Curso cursoMapperToCreate = CursoMapper.INSTANCE.toCurso(cursoCreateDto);
        cursoMapperToCreate.setNomeCurso(cursoCreateDto.getNomeCurso().toUpperCase());
        return cursoRepository.save(cursoMapperToCreate);
    }

    public void delete(long id) {
        cursoRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void update(CursoDto cursoDto) {
        Curso cursoToReplace = findByIdOrThrowBadRequestException(cursoDto.getId());
        Curso cursoMapperToUpdate = CursoMapper.INSTANCE.toCurso(cursoDto);
        cursoToReplace.setId(cursoToReplace.getId());

        cursoRepository.save(cursoMapperToUpdate);
    }
}
