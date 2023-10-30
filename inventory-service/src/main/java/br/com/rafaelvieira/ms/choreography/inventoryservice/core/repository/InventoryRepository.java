package br.com.rafaelvieira.ms.choreography.inventoryservice.core.repository;

import br.com.rafaelvieira.ms.choreography.inventoryservice.core.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    Optional<Inventory> findByProductCode(String productCode);
}
