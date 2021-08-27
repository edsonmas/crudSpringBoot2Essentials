package crud.curso.cursoCrud.mapper;

import crud.curso.cursoCrud.domain.Curso;
import crud.curso.cursoCrud.dto.CursoCreateDto;
import crud.curso.cursoCrud.dto.CursoDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CursoMapper {

    public static CursoMapper INSTANCE = Mappers.getMapper(CursoMapper.class);

    public abstract Curso toCurso(CursoCreateDto cursoCreateDto);
    public abstract Curso toCurso(CursoDto cursoDto);
}
