package br.com.rafaelvieira.ms.orchestrated.orderservice.core.controller;

import br.com.rafaelvieira.ms.orchestrated.orderservice.core.document.Order;
import br.com.rafaelvieira.ms.orchestrated.orderservice.core.dto.OrderRequest;
import br.com.rafaelvieira.ms.orchestrated.orderservice.core.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private OrderService orderService;

    @PostMapping
    public Order create(@RequestBody OrderRequest order) {
        return orderService.createOrder(order);
    }
}
