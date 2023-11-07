package domain.models;

import domain.models.utils.CustomColor;


public interface Shape {
    double calculateArea();
    double calculatePerimeter();
    CustomColor getColor();
}

