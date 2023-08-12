package br.com.zup.catalisa.school.repository;

import br.com.zup.catalisa.school.business.domain.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
