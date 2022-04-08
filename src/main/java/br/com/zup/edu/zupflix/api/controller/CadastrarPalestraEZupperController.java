package br.com.zup.edu.zupflix.api.controller;

import br.com.zup.edu.zupflix.api.model.Palestra;
import br.com.zup.edu.zupflix.api.repository.PalestraRepository;
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
@RequestMapping("/palestras")
public class CadastrarPalestraEZupperController {

    private final PalestraRepository palestraRepository;
    private final ZupperRepository zupperRepository;

    public CadastrarPalestraEZupperController(PalestraRepository palestraRepository, ZupperRepository zupperRepository) {
        this.palestraRepository = palestraRepository;
        this.zupperRepository = zupperRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid PalestraRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Palestra novaPalestra = request.paraPalestra(zupperRepository);

        palestraRepository.save(novaPalestra);

        URI location = uriComponentsBuilder.path("/palestras/{id}")
                .buildAndExpand(novaPalestra.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
