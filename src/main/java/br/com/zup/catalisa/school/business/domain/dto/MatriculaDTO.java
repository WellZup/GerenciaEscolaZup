package br.com.zup.catalisa.school.business.domain.dto;

import br.com.zup.catalisa.school.business.domain.entity.Aluno;
import br.com.zup.catalisa.school.business.domain.entity.Curso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDTO {
    private Long alunoId;
    private Long cursoId;

}
