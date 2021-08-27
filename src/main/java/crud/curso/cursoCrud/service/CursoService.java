package crud.curso.cursoCrud.service;

import crud.curso.cursoCrud.domain.Curso;
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


    public Curso save(CursoCreateDto cursoDto) {

        Curso curso =Curso.builder()
                .nomeCurso(cursoDto.getNomeCurso())
                .descricaoCurso(cursoDto.getDescricaoCurso())
                .valorCurso(cursoDto.getValorCurso())
                .dataFimInscricao(cursoDto.getDataFimInscricao())
                .dataInicioInscricao(cursoDto.getDataInicioInscricao())
                .maxInscritos(cursoDto.getMaxInscritos())
                .build();
        return cursoRepository.save(curso);
    }

    public void delete(long id) {
        cursoRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(CursoDto cursoDto) {
        findByIdOrThrowBadRequestException(cursoDto.getId());
        Curso curso =Curso.builder()
                .id(cursoDto.getId())
                .nomeCurso(cursoDto.getNomeCurso())
                .descricaoCurso(cursoDto.getDescricaoCurso())
                .valorCurso(cursoDto.getValorCurso())
                .dataFimInscricao(cursoDto.getDataFimInscricao())
                .dataInicioInscricao(cursoDto.getDataInicioInscricao())
                .maxInscritos(cursoDto.getMaxInscritos())
                .build();

        cursoRepository.save(curso);
    }
}
