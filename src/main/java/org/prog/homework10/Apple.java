package org.prog.homework10;

import java.util.Objects;

public class Apple {
    public String model;
    public String color;

    @Override
    public boolean equals(Object o) {
        if (model == null || color == null) {
            throw new MyPhoneException("Apple model or color is null");
        }
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return Objects.equals(model, apple.model) && Objects.equals(color, apple.color);
    }

    @Override
    public int hashCode() {
        if (model == null || color == null) {
            throw new MyPhoneException("Apple model or color is null");
        }
        return Objects.hash(model, color);
    }
}