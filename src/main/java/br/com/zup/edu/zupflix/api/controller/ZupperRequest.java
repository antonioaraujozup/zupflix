package br.com.zup.edu.zupflix.api.controller;

import br.com.zup.edu.zupflix.api.model.Zupper;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class ZupperRequest {

    @NotBlank
    private String idUnico;

    @NotBlank
    private String nome;

    @NotNull
    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAdmissao;

    @NotBlank
    @Email
    private String email;

    public ZupperRequest() {
    }

    public Zupper paraZupper() {
        return new Zupper(idUnico,nome,dataAdmissao,email);
    }

    public void setIdUnico(String idUnico) {
        this.idUnico = idUnico;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
