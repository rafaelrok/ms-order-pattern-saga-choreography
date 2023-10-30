package br.com.rafaelvieira.ms.choreography.orderservice.core.repository;

import br.com.rafaelvieira.ms.choreography.orderservice.core.document.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
