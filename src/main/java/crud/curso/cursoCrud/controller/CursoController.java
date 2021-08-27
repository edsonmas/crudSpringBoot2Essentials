package crud.curso.cursoCrud.controller;

import crud.curso.cursoCrud.domain.Curso;
import crud.curso.cursoCrud.dto.CursoCreateDto;
import crud.curso.cursoCrud.dto.CursoDto;
import crud.curso.cursoCrud.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
@RequiredArgsConstructor
public class CursoController {


    private final CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> listAll(){
        return new ResponseEntity<>(cursoService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Curso> findById(@PathVariable long id){
        return ResponseEntity.ok(cursoService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Curso>> findByNomeCurso(@RequestParam(required = true) String nomeCurso){

        return ResponseEntity.ok(cursoService.findByNomeCursoOrThrowBadRequestException(nomeCurso.toUpperCase()));
    }

    @PostMapping
    public ResponseEntity<Curso> save(@RequestBody CursoCreateDto cursoDto){
        return new ResponseEntity<>(cursoService.save(cursoDto), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        cursoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody CursoDto cursoDto){
        cursoService.update(cursoDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
