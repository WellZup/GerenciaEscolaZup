package br.com.zup.catalisa.school.business.mapper;

import br.com.zup.catalisa.school.business.domain.dto.CursoDTO;
import br.com.zup.catalisa.school.business.domain.entity.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {
    public static Curso toEntity(CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setId(cursoDTO.getId());
        curso.setNome(cursoDTO.getNome());

        return curso;
    }

    public CursoDTO toDTO(Curso curso) {
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setId(curso.getId());
        cursoDTO.setNome(curso.getNome());

        return cursoDTO;
    }
}
