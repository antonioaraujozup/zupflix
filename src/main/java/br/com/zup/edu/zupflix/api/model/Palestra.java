package br.com.zup.edu.zupflix.api.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Palestra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String tema;

    @Column(nullable = false)
    private Integer tempo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoExibicao tipoExibicao;

    @Column(nullable = false)
    private LocalDateTime dataHoraExibicao;

    @ManyToMany
    private Set<Zupper> zuppers = new HashSet<>();

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public Palestra() {
    }

    public Palestra(String titulo, String tema, Integer tempo, TipoExibicao tipoExibicao, LocalDateTime dataHoraExibicao) {
        this.titulo = titulo;
        this.tema = tema;
        this.tempo = tempo;
        this.tipoExibicao = tipoExibicao;
        this.dataHoraExibicao = dataHoraExibicao;
    }

    public void adicionaZuppers(Set<Zupper> zuppers) {
        zuppers.forEach(zupper -> {
            this.zuppers.add(zupper);
        });
    }

    public Long getId() {
        return id;
    }
}
