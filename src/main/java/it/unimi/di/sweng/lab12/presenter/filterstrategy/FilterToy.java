package it.unimi.di.sweng.lab12.presenter.filterstrategy;

import it.unimi.di.sweng.lab12.model.objects.ToyInfo;
import org.jetbrains.annotations.NotNull;

public class FilterToy implements FilterStrategy {

    private final @NotNull String toy;

    public FilterToy(@NotNull String toy) {
        this.toy = toy.toLowerCase();
    }

    @Override
    public boolean valid(@NotNull ToyInfo toy) {
        return toy.toy().name().toLowerCase().equals(this.toy);
    }
}
