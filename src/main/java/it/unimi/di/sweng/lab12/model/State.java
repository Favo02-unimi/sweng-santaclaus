package it.unimi.di.sweng.lab12.model;

import it.unimi.di.sweng.lab12.model.objects.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State implements IState {

    private final @NotNull Map<ToyCity, Quantity> toys;

    public State() {
        toys = new HashMap<>();
    }

    @Override
    public void addToy(@NotNull Toy toy, @NotNull Quantity qty, @NotNull City city) {
        toys.put(new ToyCity(toy, city), qty);
    }

    @Override
    public @NotNull List<ToyInfo> getToys() {
        List<ToyInfo> res = new ArrayList<>();
        for (Map.Entry<ToyCity, Quantity> entry : toys.entrySet()) {
            res.add(new ToyInfo(entry.getKey().toy(), entry.getValue(), entry.getKey().city()));
        }
        return res;
    }
}
