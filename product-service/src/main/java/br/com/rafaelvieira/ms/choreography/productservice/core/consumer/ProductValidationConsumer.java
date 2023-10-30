package br.com.rafaelvieira.ms.choreography.productservice.core.consumer;

import br.com.rafaelvieira.ms.choreography.productservice.core.service.ProductValidationService;
import br.com.rafaelvieira.ms.choreography.productservice.core.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductValidationConsumer {

    private final ProductValidationService productValidationService;
    private final JsonUtil jsonUtil;

    @KafkaListener(
        groupId = "${spring.kafka.consumer.group-id}",
        topics = "${spring.kafka.topic.product-validation-start}"
    )
    public void consumeSuccessEvent(String payload) {
        log.info("Receiving success event {} from product-validation-start topic", payload);
        var event = jsonUtil.toEvent(payload);
        productValidationService.validateExistingProducts(event);
    }

    @KafkaListener(
        groupId = "${spring.kafka.consumer.group-id}",
        topics = "${spring.kafka.topic.product-validation-fail}"
    )
    public void consumeFailEvent(String payload) {
        log.info("Receiving rollback event {} from product-validation-fail topic", payload);
        var event = jsonUtil.toEvent(payload);
        productValidationService.rollbackEvent(event);
    }
}
