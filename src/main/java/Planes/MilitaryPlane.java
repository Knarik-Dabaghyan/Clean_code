package Planes;

import models.MilitaryType;
import models.Planes;

public class MilitaryPlane extends Plane {

    private final MilitaryType type;

    public MilitaryPlane(Planes planes,MilitaryType type) {
        super(planes.getModel(), planes.getMaxSpeed(), planes.getMaxFlightDistance(), planes.getMaxLoadCapacity());
        this.type = type;
    }

    public MilitaryType getType() {
        return type;
    }
}