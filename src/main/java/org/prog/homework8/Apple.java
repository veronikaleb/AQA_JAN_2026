package org.prog.homework8;

import java.util.Objects;

public class Apple implements IPhone {
    public String model;
    public String color;

    public Apple(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public void call(String someone) {
        System.out.println("Apple " + model + " calling " + someone);
    }

    @Override
    public void unlockScreen() {
        System.out.println("Apple " + model + " unlocked with FaceID");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Apple) {
            Apple other = (Apple) obj;
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