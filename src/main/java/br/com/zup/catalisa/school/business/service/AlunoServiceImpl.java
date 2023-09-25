package br.com.zup.catalisa.school.business.service;

import br.com.zup.catalisa.school.business.domain.dto.AlunoDTO;
import br.com.zup.catalisa.school.business.domain.entity.Aluno;
import br.com.zup.catalisa.school.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AlunoServiceImpl implements AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;
    @Override
    public AlunoDTO criar(AlunoDTO alunoDTO) {

        Aluno novoAluno = new Aluno();
        novoAluno.setNome(alunoDTO.getNome());
        novoAluno.setIdade(alunoDTO.getIdade());
        novoAluno.setEmail(alunoDTO.getEmail());

        alunoRepository.save(novoAluno);

        AlunoDTO alunoCriadoDTO = new AlunoDTO();
        alunoCriadoDTO.setId(novoAluno.getId());
        alunoCriadoDTO.setNome(novoAluno.getNome());
        alunoCriadoDTO.setIdade(novoAluno.getIdade());
        alunoCriadoDTO.setEmail(novoAluno.getEmail());

        return alunoCriadoDTO;
    }

    @Override
    public List<Aluno> buscarTodosAlunos() {
//        List<Aluno> alunos = alunoRepository.findAll();
//        List<AlunoDTO> alunosDTO = new ArrayList<>();
//
//        for (Aluno aluno : alunos) {
//            AlunoDTO alunoDTO = new AlunoDTO();
//            alunoDTO.setId(aluno.getId());
//            alunoDTO.setNome(aluno.getNome());
//            alunoDTO.setEmail(aluno.getEmail());
//            alunosDTO.add(alunoDTO);
//        }
//        return alunosDTO;
        return alunoRepository.findAll();
    }

    @Override
    public AlunoDTO buscarPorId(Long id) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            AlunoDTO alunoDTO = new AlunoDTO();
            alunoDTO.setId(aluno.getId());
            alunoDTO.setNome(aluno.getNome());
            alunoDTO.setIdade(aluno.getIdade());
            alunoDTO.setEmail(aluno.getEmail());
            return alunoDTO;
        }
        return null;
    }
    @Override
    public AlunoDTO atualizar(Long id, AlunoDTO alunoDTO) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if (optionalAluno.isPresent()) {
            Aluno aluno = optionalAluno.get();
            aluno.setNome(aluno.getNome());
            aluno.setIdade(aluno.getIdade());
            aluno.setEmail(aluno.getEmail());

            alunoDTO.setId(aluno.getId());
            return alunoDTO;
        }
        return null;
    }
    @Override
    public boolean deletar(Long id) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if (optionalAluno.isPresent()) {
            alunoRepository.delete(optionalAluno.get());
        }
        return false;
    }
}
