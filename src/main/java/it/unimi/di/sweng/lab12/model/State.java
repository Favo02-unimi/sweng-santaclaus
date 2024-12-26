package it.unimi.di.sweng.lab12.model;

import it.unimi.di.sweng.lab12.model.objects.City;
import it.unimi.di.sweng.lab12.model.objects.Quantity;
import it.unimi.di.sweng.lab12.model.objects.Toy;
import it.unimi.di.sweng.lab12.model.objects.ToyInfo;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class State implements IState {
    @Override
    public void addToy(@NotNull Toy toy, @NotNull Quantity qty, @NotNull City city) {

    }

    @Override
    public @NotNull List<ToyInfo> getToys() {
        return null;
    }
}
