package br.com.rafaelvieira.ms.choreography.productservice.core.repository;

import br.com.rafaelvieira.ms.choreography.productservice.core.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Boolean existsByCode(String code);
}
