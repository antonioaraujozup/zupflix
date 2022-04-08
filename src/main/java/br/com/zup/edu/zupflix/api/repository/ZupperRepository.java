package br.com.zup.edu.zupflix.api.repository;

import br.com.zup.edu.zupflix.api.model.Zupper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZupperRepository extends JpaRepository<Zupper, Long> {
}
