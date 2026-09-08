package ru.altayauto.modules.reservation.domain.model.entity;

import ru.altayauto.modules.reservation.domain.model.exception.RentsException;
import ru.altayauto.modules.reservation.domain.model.valueobject.AutoRent;

import java.util.*;

public class AutoRents {
    private final UUID autoId;
    private final Set<AutoRent> autoRents;

    public AutoRents(UUID autoId, Set<AutoRent> rents){
        this.autoId = autoId;
        this.autoRents = rents;
    }

    public AutoRents(UUID autoId){
        this(autoId, new HashSet<>());
    }

    public void addRent(AutoRent newRent){
        if(autoRents.stream().anyMatch(rent -> rent.collide(newRent)))
            throw new RentsException.RentsCollision();
        autoRents.add(newRent);
    }

    public void removeRent(AutoRent newRent){
        if(!autoRents.contains(newRent))
            throw new RentsException.NotFoundForAuto();
        autoRents.remove(newRent);
    }

    public UUID getAutoId() {
        return autoId;
    }
}
