package com.meirusfandi.myunittesting;

class MainViewModel {

    private CuboidModel cuboidModel;

    MainViewModel(CuboidModel cuboidModel) {
        this.cuboidModel = cuboidModel;
    }

    void save(double l, double w, double h) {
        cuboidModel.save(w, h, l);
    }

    double getCircumference() {
        return cuboidModel.getCircumference();
    }

    double getSurfaceArea() {
        return cuboidModel.getSurfaceArea();
    }

    double getVolume() {
        return cuboidModel.getVolume();
    }
}
