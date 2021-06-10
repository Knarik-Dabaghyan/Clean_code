package Planes;

import models.ClassificationLevel;
import models.ExperimentalTypes;
import models.Planes;

public class ExperimentalPlane extends Plane {

    private final ExperimentalTypes type;
    private final ClassificationLevel classificationLevel;

    public ExperimentalPlane(Planes plane, ExperimentalTypes type, ClassificationLevel classificationLevel) {
        super(plane.getModel(), plane.getMaxSpeed(),plane.getMaxFlightDistance(), plane.getMaxLoadCapacity());
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }
}