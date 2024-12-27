package it.unimi.di.sweng.lab12.model.objects;

import org.jetbrains.annotations.NotNull;

public record Quantity(int qty) {
    public Quantity {
        if (qty <= 0) {
            throw new IllegalArgumentException("The number of toys must be a positive integer");
        }
        if (qty > 100) {
            throw new IllegalArgumentException("Quantity must be less or equal than 100");
        }
    }

    public static @NotNull Quantity fromString(@NotNull String qty) {
        try {
            return new Quantity(Integer.parseInt(qty));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The number of toys must be a positive integer");
        }
    }
}
