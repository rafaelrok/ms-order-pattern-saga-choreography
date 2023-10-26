package br.com.rafaelvieira.ms.orchestrated.orderservice.core.controller;

import br.com.rafaelvieira.ms.orchestrated.orderservice.core.document.Event;
import br.com.rafaelvieira.ms.orchestrated.orderservice.core.dto.EventFilters;
import br.com.rafaelvieira.ms.orchestrated.orderservice.core.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/event")
public class EventController {

    private final EventService service;

    @GetMapping
    public Event findByFilters(EventFilters filters) {
        return service.findByFilters(filters);
    }

    @GetMapping("all")
    public List<Event> findAll() {
        return service.findAll();
    }
}
