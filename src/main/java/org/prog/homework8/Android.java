package org.prog.homework8;

import java.util.Objects;

public class Android implements IPhone {
    public String model;
    public String color;

    public Android(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public void call(String someone) {
        System.out.println("Android " + model + " calling " + someone);
    }

    @Override
    public void unlockScreen() {
        System.out.println("Android " + model + " unlocked with Fingerprint");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Android other) {
            return Objects.equals(this.model, other.model) &&
                    Objects.equals(this.color, other.color);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int h1 = (model != null) ? model.hashCode() : 0;
        int h2 = (color != null) ? color.hashCode() : 0;
        int sumHash = (model + color).hashCode();

        System.out.println("Model hash: " + h1);
        System.out.println("Color hash: " + h2);
        System.out.println("Sum (model+color) hash: " + sumHash);

        return sumHash;
    }
}