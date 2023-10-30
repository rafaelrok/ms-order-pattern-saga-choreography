package br.com.rafaelvieira.ms.choreography.orderservice.core.service;

import br.com.rafaelvieira.ms.choreography.orderservice.core.dto.OrderRequest;
import br.com.rafaelvieira.ms.choreography.orderservice.core.document.Order;
import br.com.rafaelvieira.ms.choreography.orderservice.core.repository.OrderRepository;
import br.com.rafaelvieira.ms.choreography.orderservice.core.producer.SagaProducer;
import br.com.rafaelvieira.ms.choreography.orderservice.core.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class OrderService {
    private static final String TRANSACTION_ID_PATTERN = "%s_%s";

    private final EventService eventService;
    private final SagaProducer producer;
    private final JsonUtil jsonUtil;
    private final OrderRepository repository;

    public Order createOrder(OrderRequest orderRequest) {
        var order = Order
            .builder()
            .products(orderRequest.getProducts())
            .createdAt(LocalDateTime.now())
            .transactionId(
                String.format(TRANSACTION_ID_PATTERN, Instant.now().toEpochMilli(), UUID.randomUUID()))
            .build();
        repository.save(order);
        producer.sendEvent(jsonUtil.toJson(eventService.createEvent(order)));
        return order;
    }
}
