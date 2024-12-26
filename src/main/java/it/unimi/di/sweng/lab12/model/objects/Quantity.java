package it.unimi.di.sweng.lab12.model.objects;

public record Quantity(int qty) {
    public Quantity {
        if (qty <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (qty > 100) {
            throw new IllegalArgumentException("Quantity must be less or equal than 100");
        }
    }
}
