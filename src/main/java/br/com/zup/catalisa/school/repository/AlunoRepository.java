package br.com.zup.catalisa.school.repository;

import br.com.zup.catalisa.school.business.domain.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
