package domain.factory;

import domain.models.shapes.AbstractShape;

public interface ShapePrototype {
    AbstractShape clone();
}