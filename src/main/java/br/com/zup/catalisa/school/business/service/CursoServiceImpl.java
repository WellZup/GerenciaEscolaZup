package br.com.zup.catalisa.school.business.service;

import br.com.zup.catalisa.school.business.domain.dto.CursoDTO;
import br.com.zup.catalisa.school.business.domain.entity.Curso;
import br.com.zup.catalisa.school.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Override
    public CursoDTO criar(CursoDTO cursoDTO) {
        Curso novoCurso = new Curso();
        novoCurso.setNome(cursoDTO.getNome());
        novoCurso.setCargaHora(cursoDTO.getCargaHora());

        cursoRepository.save(novoCurso);

        CursoDTO cursoCriadoDTO = new CursoDTO();
        cursoCriadoDTO.setNome(cursoCriadoDTO.getNome());
        cursoCriadoDTO.setCargaHora(cursoCriadoDTO.getCargaHora());
        return cursoCriadoDTO;
    }

    @Override
    public CursoDTO buscarPorId(Long id) {
        Optional<Curso> optionalCurso = cursoRepository.findById(id);
        if (optionalCurso.isPresent()) {
            Curso curso = optionalCurso.get();
            CursoDTO cursoDTO = new CursoDTO();
            cursoDTO.setId(curso.getId());
            cursoDTO.setNome(curso.getNome());
            cursoDTO.setCargaHora(curso.getCargaHora());
            return cursoDTO;
        }
        return null;
    }
    @Override
    public CursoDTO atualizar(Long id, CursoDTO cursoDTO) {
        Optional<Curso> optionalCurso = cursoRepository.findById(id);
        if (optionalCurso.isPresent()) {
            Curso curso = optionalCurso.get();
            curso.setNome(curso.getNome());
            curso.setCargaHora(curso.getCargaHora());
            cursoDTO.setId(curso.getId());
            return cursoDTO;
        }
        return null;
    }

    @Override
    public boolean deletar(Long id) {
        Optional<Curso> optionalCurso = cursoRepository.findById(id);
        if (optionalCurso.isPresent()) {
            cursoRepository.delete(optionalCurso.get());
        }
        return false;
    }
}
