package crud.curso.cursoCrud.dto;

import lombok.Data;

@Data
public class CursoCreateDto {

    private String publicId;
    private String nomeCurso;
    private String descricaoCurso;
    private double valorCurso;
    private String dataInicioInscricao;
    private String dataFimInscricao;
    private int maxInscritos;

}
