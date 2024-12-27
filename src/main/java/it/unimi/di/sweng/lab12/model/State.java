package it.unimi.di.sweng.lab12.model;

import it.unimi.di.sweng.lab12.model.objects.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State implements IState {

    private final @NotNull Map<ToyCity, Quantity> toys;
    private final @NotNull Map<City, Quantity> cityQuantity;

    public State() {
        toys = new HashMap<>();
        cityQuantity = new HashMap<>();
    }

    @Override
    public void addToy(@NotNull Toy toy, @NotNull Quantity qty, @NotNull City city) {
        var ToyCity = new ToyCity(toy, city);
        if (toys.containsKey(ToyCity)) {
            throw new IllegalArgumentException("The toy has already been added to the city");
        }
        if (cityQuantity.containsKey(city) && cityQuantity.get(city).qty() + qty.qty() > 100) {
            throw new IllegalArgumentException("The quantity of toys in this city is over 100");
        }

        toys.put(new ToyCity(toy, city), qty);
        if (!cityQuantity.containsKey(city)) cityQuantity.put(city, qty);
        else cityQuantity.put(city, new Quantity(cityQuantity.get(city).qty() + qty.qty()));
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
