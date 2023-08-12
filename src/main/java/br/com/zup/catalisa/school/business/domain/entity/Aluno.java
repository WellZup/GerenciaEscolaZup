package br.com.zup.catalisa.school.business.domain.entity;
import lombok.*;
import javax.persistence.*;
@Entity
@Table(name = "TB_Aluno")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private  String nome;
    @Column(nullable = false)
    private int idade;
    @Column(nullable = false)
    private String email;
}
