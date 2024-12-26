package it.unimi.di.sweng.lab12.presenter.formatstrategy;

import it.unimi.di.sweng.lab12.model.objects.ToyInfo;
import org.jetbrains.annotations.NotNull;

public enum CityQuantity implements FormatStrategy {
    S; // SINGLETON

    @Override
    public @NotNull String format(@NotNull ToyInfo toy) {
        return toy.city().name() + "\t" + toy.qty().qty();
    }
}
