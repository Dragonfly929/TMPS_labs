package domain.models.utils;

public enum ShapeColor {
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    YELLOW(255, 255, 0),

    // Add more predefined colors
    CYAN(0, 255, 255),
    MAGENTA(255, 0, 255),
    ORANGE(255, 165, 0);
    private final int red;
    private final int green;
    private final int blue;

    ShapeColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public CustomColor toCustomColor() {
        return new CustomColor(red, green, blue);
    }
}
