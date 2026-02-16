package org.prog.homework10;

import java.util.Objects;

public class Android {
    public String model;
    public String color;

    @Override
    public boolean equals(Object o) {
        if (model == null || color == null) {
            throw new MyPhoneException("Android model or color is null");
        }
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Android android = (Android) o;
        return Objects.equals(model, android.model) && Objects.equals(color, android.color);
    }

    @Override
    public int hashCode() {
        if (model == null || color == null) {
            throw new MyPhoneException("Android model or color is null");
        }
        return Objects.hash(model, color);
    }
}