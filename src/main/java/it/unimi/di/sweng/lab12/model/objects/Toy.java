package it.unimi.di.sweng.lab12.model.objects;

import org.jetbrains.annotations.NotNull;

public record Toy(@NotNull String name) {
    public Toy {
        if (name.isBlank()) {
            throw new IllegalArgumentException("City and toy must not be blank");
        }
    }
}
