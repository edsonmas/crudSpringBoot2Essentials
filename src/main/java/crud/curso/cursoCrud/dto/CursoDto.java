package crud.curso.cursoCrud.dto;

import lombok.Data;


@Data
public class CursoDto {
    private Long id;
    private String publicId;
    private String nomeCurso;
    private String descricaoCurso;
    private double valorCurso;
    private String dataInicioInscricao;
    private String dataFimInscricao;
    private int maxInscritos;

}
