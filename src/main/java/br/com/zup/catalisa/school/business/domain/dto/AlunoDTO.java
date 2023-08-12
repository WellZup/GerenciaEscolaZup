package br.com.zup.catalisa.school.business.domain.dto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

    private Long id;
    private String nome;
    private int idade;
    private String email;

}
