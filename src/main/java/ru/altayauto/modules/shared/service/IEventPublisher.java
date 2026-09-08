package ru.altayauto.modules.shared.service;

public interface IEventPublisher {
    void publishEvent(IEvent event);
}
