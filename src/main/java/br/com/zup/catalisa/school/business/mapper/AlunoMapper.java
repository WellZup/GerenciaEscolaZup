package br.com.zup.catalisa.school.business.mapper;

import br.com.zup.catalisa.school.business.domain.dto.AlunoDTO;
import br.com.zup.catalisa.school.business.domain.entity.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {
    public static Aluno toEntity(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setId(alunoDTO.getId());
        aluno.setNome(alunoDTO.getNome());
        aluno.setIdade(alunoDTO.getIdade());
        aluno.setEmail(alunoDTO.getEmail());
        return aluno;
    }

    public AlunoDTO toDTO(Aluno aluno) {
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setId(aluno.getId());
        alunoDTO.setNome(aluno.getNome());
        alunoDTO.setIdade(aluno.getIdade());
        alunoDTO.setEmail(aluno.getEmail());
        return alunoDTO;
    }
}
