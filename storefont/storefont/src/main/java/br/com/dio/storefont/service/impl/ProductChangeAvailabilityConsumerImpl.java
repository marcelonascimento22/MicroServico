package br.com.dio.storefont.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import br.com.dio.storefont.dto.StockStatusMessage;
import br.com.dio.storefont.service.IProductChangeAvailabilityConsumer;
import br.com.dio.storefont.service.IProductService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductChangeAvailabilityConsumerImpl implements IProductChangeAvailabilityConsumer {

    private final IProductService service;

    @RabbitListener(queues = "${spring.rabbitmq.queue.product-change-availability}")
    @Override
    public void receive(final StockStatusMessage message) {
        service.changeActivated(message.id(), message.active());
    }

}
