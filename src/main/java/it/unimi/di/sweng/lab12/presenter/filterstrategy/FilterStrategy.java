package it.unimi.di.sweng.lab12.presenter.filterstrategy;

import it.unimi.di.sweng.lab12.model.objects.ToyInfo;
import org.jetbrains.annotations.NotNull;

public interface FilterStrategy {
    boolean valid(@NotNull ToyInfo toy);
}
