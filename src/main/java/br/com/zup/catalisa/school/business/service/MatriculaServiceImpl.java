package br.com.zup.catalisa.school.business.service;

import br.com.zup.catalisa.school.business.domain.dto.AlunoDTO;
import br.com.zup.catalisa.school.business.domain.dto.CursoDTO;
import br.com.zup.catalisa.school.business.domain.dto.MatriculaDTO;
import br.com.zup.catalisa.school.business.domain.entity.Matricula;
import br.com.zup.catalisa.school.business.mapper.AlunoMapper;
import br.com.zup.catalisa.school.business.mapper.CursoMapper;
import br.com.zup.catalisa.school.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaServiceImpl implements MatriculaService{
    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private AlunoService alunoService;

    @Autowired
    private CursoService cursoService;

    public Matricula realizarMatricula(MatriculaDTO matriculaDTO) {
        AlunoDTO alunoDTO = alunoService.buscarPorId(matriculaDTO.getAlunoId());
        CursoDTO cursoDTO = cursoService.buscarPorId(matriculaDTO.getCursoId());

        // Criar, uma nova matrícula
        Matricula matricula = new Matricula();

        matricula.setAluno(AlunoMapper.toEntity(alunoDTO));
        matricula.setCurso(CursoMapper.toEntity(cursoDTO));


        return matriculaRepository.save(matricula);

    }



}
