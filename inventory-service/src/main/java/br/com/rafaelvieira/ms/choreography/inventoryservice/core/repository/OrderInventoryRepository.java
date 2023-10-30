package br.com.rafaelvieira.ms.choreography.inventoryservice.core.repository;

import br.com.rafaelvieira.ms.choreography.inventoryservice.core.domain.OrderInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderInventoryRepository extends JpaRepository<OrderInventory, Integer> {

    List<OrderInventory> findByOrderIdAndTransactionId(String orderId, String transactionId);

    Boolean existsByOrderIdAndTransactionId(String orderId, String transactionId);
}
