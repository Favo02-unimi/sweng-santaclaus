package it.unimi.di.sweng.lab12.presenter.sortstrategy;

import it.unimi.di.sweng.lab12.model.objects.ToyInfo;
import org.jetbrains.annotations.NotNull;

public enum ToyAlphabetical implements SortStrategy {
    S; // SINGLETON

    @Override
    public int compare(@NotNull ToyInfo toy1, @NotNull ToyInfo toy2) {
        return toy1.toy().name().toLowerCase().compareTo(toy2.toy().name().toLowerCase());
    }
}
