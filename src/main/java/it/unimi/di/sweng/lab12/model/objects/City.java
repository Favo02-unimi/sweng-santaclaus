package it.unimi.di.sweng.lab12.model.objects;

import org.jetbrains.annotations.NotNull;

public record City(@NotNull String name) {
    public City {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }
}
