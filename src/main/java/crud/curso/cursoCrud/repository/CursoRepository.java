package crud.curso.cursoCrud.repository;

import crud.curso.cursoCrud.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
