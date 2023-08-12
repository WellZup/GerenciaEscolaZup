package br.com.zup.catalisa.school.repository;

import br.com.zup.catalisa.school.business.domain.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
