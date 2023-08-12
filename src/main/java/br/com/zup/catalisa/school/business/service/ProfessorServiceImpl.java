package br.com.zup.catalisa.school.business.service;

import br.com.zup.catalisa.school.business.domain.dto.ProfessorDTO;
import br.com.zup.catalisa.school.business.domain.entity.Professor;
import br.com.zup.catalisa.school.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService{
    @Autowired
    private ProfessorRepository professorRepository;
    @Override
    public ProfessorDTO criar(ProfessorDTO professorDTO) {

        Professor novoProfessor = new Professor();
        novoProfessor.setNome(professorDTO.getNome());
        novoProfessor.setIdade(professorDTO.getIdade());
        novoProfessor.setCurso(professorDTO.getCurso());
        novoProfessor.setSalario(professorDTO.getSalario());

        professorRepository.save(novoProfessor);

        ProfessorDTO professorCriadoDTO = new ProfessorDTO();
        professorCriadoDTO.setId(novoProfessor.getId());
        professorCriadoDTO.setNome(novoProfessor.getNome());
        professorCriadoDTO.setIdade(novoProfessor.getIdade());
        professorCriadoDTO.setCurso(novoProfessor.getCurso());
        professorCriadoDTO.setSalario(novoProfessor.getSalario());

        return professorCriadoDTO;
    }

    @Override
    public ProfessorDTO buscarPorId(Long id) {
        Optional<Professor> optionalProfessor = professorRepository.findById(id);
        if (optionalProfessor.isPresent()) {
            Professor professor = optionalProfessor.get();
            ProfessorDTO professorDTO = new ProfessorDTO();
            professorDTO.setId(professor.getId());
            professorDTO.setNome(professor.getNome());
            professorDTO.setIdade((long) professor.getIdade());
            professorDTO.setCurso(professor.getCurso());
            professorDTO.setSalario(professor.getSalario());
            return professorDTO;

        }
        return null;
    }

    @Override
    public ProfessorDTO atualizar(Long id, ProfessorDTO professorDTO) {
        Optional<Professor> optionalProfessor = professorRepository.findById(id);
        if (optionalProfessor.isPresent()) {
            Professor professor = optionalProfessor.get();
            professor.setNome(professor.getNome());
            professor.setIdade(professor.getIdade());
            professor.setCurso(professorDTO.getCurso());
            professor.setSalario(professor.getSalario());
            return professorDTO;
        }
        return null;
    }

    @Override
    public boolean deletar(Long id) {
        Optional<Professor> optionalProfessor = professorRepository.findById(id);
        if (optionalProfessor.isPresent()) {
            professorRepository.delete(optionalProfessor.get());
        }
        return false;
    }
}
