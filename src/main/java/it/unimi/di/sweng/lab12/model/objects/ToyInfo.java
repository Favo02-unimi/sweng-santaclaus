package it.unimi.di.sweng.lab12.model.objects;

import org.jetbrains.annotations.NotNull;

public record ToyInfo(@NotNull Toy toy, @NotNull Quantity qty, @NotNull City city) {
}
