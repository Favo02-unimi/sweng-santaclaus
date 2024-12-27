package it.unimi.di.sweng.lab12.presenter.filterstrategy;

import it.unimi.di.sweng.lab12.model.objects.ToyInfo;
import org.jetbrains.annotations.NotNull;

public class FilterCity implements FilterStrategy {

    private final @NotNull String city;

    public FilterCity(@NotNull String city) {
        this.city = city.toLowerCase();
    }

    @Override
    public boolean valid(@NotNull ToyInfo toy) {
        return toy.city().name().toLowerCase().equals(city);
    }
}
