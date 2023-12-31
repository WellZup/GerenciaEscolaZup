package br.com.zup.catalisa.school.business.service;
import br.com.zup.catalisa.school.business.domain.dto.AlunoDTO;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AlunoService {

    AlunoDTO criar(AlunoDTO alunoDTO);
    List<AlunoDTO> buscarTodosAlunos();
    AlunoDTO buscarPorId(Long id);
    AlunoDTO atualizar(Long id, AlunoDTO alunoDTO);
    boolean deletar(Long id);
}
