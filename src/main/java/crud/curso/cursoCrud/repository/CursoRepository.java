package crud.curso.cursoCrud.repository;

import crud.curso.cursoCrud.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findByNomeCurso(String nomeCurso);

}
