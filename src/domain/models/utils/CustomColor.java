package domain.models.utils;

public class CustomColor {
    private int red;
    private int green;
    private int blue;

    public CustomColor(int red, int green, int blue) {
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

    public static CustomColor fromPredefinedColor(ShapeColor predefinedColor) {
        return new CustomColor(predefinedColor.getRed(), predefinedColor.getGreen(), predefinedColor.getBlue());
    }
}
