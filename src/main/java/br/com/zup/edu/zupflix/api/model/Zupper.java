package br.com.zup.edu.zupflix.api.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Zupper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String idUnico;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataAdmissao;

    @Column(nullable = false, unique = true)
    private String email;

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public Zupper() {
    }

    public Zupper(String idUnico, String nome, LocalDate dataAdmissao, String email) {
        this.idUnico = idUnico;
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

}
