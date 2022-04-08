package br.com.zup.edu.zupflix.api.controller;

import br.com.zup.edu.zupflix.api.model.Palestra;
import br.com.zup.edu.zupflix.api.model.TipoExibicao;
import br.com.zup.edu.zupflix.api.model.Zupper;
import br.com.zup.edu.zupflix.api.repository.ZupperRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class PalestraRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String tema;

    @NotNull
    @Min(30)
    private Integer tempo;

    @NotNull
    private TipoExibicao tipoExibicao;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataHoraExibicao;

    @NotNull
    @Size(min = 1)
    private Set<Long> zuppers;

    public PalestraRequest() {
    }

    public Palestra paraPalestra(ZupperRepository zupperRepository) {
        Palestra palestra = new Palestra(titulo, tema, tempo, tipoExibicao, dataHoraExibicao);

        Set<Zupper> zuppers = this.zuppers.stream()
                .map(idZupper -> zupperRepository.findById(idZupper).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Zupper não cadastrado!")))
                .collect(Collectors.toSet());

        palestra.adicionaZuppers(zuppers);

        return palestra;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    public void setTipoExibicao(TipoExibicao tipoExibicao) {
        this.tipoExibicao = tipoExibicao;
    }

    public void setDataHoraExibicao(LocalDateTime dataHoraExibicao) {
        this.dataHoraExibicao = dataHoraExibicao;
    }

    public void setZuppers(Set<Long> zuppers) {
        this.zuppers = zuppers;
    }
}
