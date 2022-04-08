package br.com.zup.edu.zupflix.api.controller;

import br.com.zup.edu.zupflix.api.model.Zupper;
import br.com.zup.edu.zupflix.api.repository.ZupperRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/zuppers")
public class CadastrarNovoZupperController {

    private final ZupperRepository zupperRepository;

    public CadastrarNovoZupperController(ZupperRepository zupperRepository) {
        this.zupperRepository = zupperRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid ZupperRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Zupper novoZupper = request.paraZupper();

        zupperRepository.save(novoZupper);

        URI location = uriComponentsBuilder.path("/zuppers/{id}")
                .buildAndExpand(novoZupper.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
