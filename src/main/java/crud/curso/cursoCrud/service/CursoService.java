package crud.curso.cursoCrud.service;

import crud.curso.cursoCrud.domain.Curso;
import crud.curso.cursoCrud.mapper.CursoMapper;
import crud.curso.cursoCrud.repository.CursoRepository;
import crud.curso.cursoCrud.dto.CursoCreateDto;
import crud.curso.cursoCrud.dto.CursoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;


    public List<Curso> listAll() {
        return cursoRepository.findAll();
    }

    public Curso findByIdOrThrowBadRequestException(long id) {
        return cursoRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"Curso id not found"));
    }


    public Curso save(CursoCreateDto cursoCreateDto) {
        Curso cursoMapperToCreate = CursoMapper.INSTANCE.toCurso(cursoCreateDto);

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
