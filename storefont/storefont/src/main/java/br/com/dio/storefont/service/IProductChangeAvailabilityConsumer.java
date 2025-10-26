package br.com.dio.storefont.service;

import br.com.dio.storefont.dto.StockStatusMessage;

public interface IProductChangeAvailabilityConsumer {
    void receive(final StockStatusMessage message);
}
