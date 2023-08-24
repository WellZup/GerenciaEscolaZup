package br.com.zup.catalisa.school.repository;

import br.com.zup.catalisa.school.business.domain.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
