package com.meirusfandi.myunittesting;

class CuboidModel {

    private double width;
    private double height;
    private double length;

    public CuboidModel() {

    }

    public void save(double width, double height, double length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    double getVolume() {
        return width * height * length;
    }

    public double getSurfaceArea() {
        double wl = width * length;
        double wh = width * height;
        double lh = length * height;

        return 2 * (wl + wh + lh);
    }

    public double getCircumference() {
        return 4 * (width * height * length);
    }
}
