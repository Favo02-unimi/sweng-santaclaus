package it.unimi.di.sweng.lab12.presenter.sortstrategy;

import it.unimi.di.sweng.lab12.model.objects.ToyInfo;
import org.jetbrains.annotations.NotNull;

public interface SortStrategy {
    int compare(@NotNull ToyInfo toy1, @NotNull ToyInfo toy2);
}
