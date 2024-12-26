package it.unimi.di.sweng.lab12.presenter.formatstrategy;

import it.unimi.di.sweng.lab12.model.objects.ToyInfo;
import org.jetbrains.annotations.NotNull;

public interface FormatStrategy {
    public @NotNull String format(@NotNull ToyInfo toy);
}
