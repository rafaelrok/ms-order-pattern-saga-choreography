package br.com.rafaelvieira.ms.orchestrated.productservice.core.repository;

import br.com.rafaelvieira.ms.orchestrated.productservice.core.domain.Validation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ValidationRepository extends JpaRepository<Validation, Integer> {

    Boolean existsByOrderIdAndTransactionId(String orderId, String transactionId);
    Optional<Validation> findByOrderIdAndTransactionId(String orderId, String transactionId);
}
