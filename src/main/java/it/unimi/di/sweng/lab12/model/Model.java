package it.unimi.di.sweng.lab12.model;

import it.unimi.di.sweng.lab12.Observable;
import it.unimi.di.sweng.lab12.Observer;
import it.unimi.di.sweng.lab12.model.objects.City;
import it.unimi.di.sweng.lab12.model.objects.Quantity;
import it.unimi.di.sweng.lab12.model.objects.Toy;
import it.unimi.di.sweng.lab12.model.objects.ToyInfo;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Model extends State implements Observable<List<ToyInfo>> {

    private final @NotNull List<Observer<List<ToyInfo>>> observers;

    public Model() {
        observers = new ArrayList<>();
    }

    @Override
    public void notifyObservers() {
        for (Observer<List<ToyInfo>> obs : observers) {
            obs.update(getState());
        }
    }

    @Override
    public void addObserver(@NotNull Observer<List<ToyInfo>> observer) {
        observers.add(observer);
    }

    @Override
    public @NotNull List<ToyInfo> getState() {
        return super.getToys();
    }

    @Override
    public boolean addToy(@NotNull Toy toy, @NotNull Quantity qty, @NotNull City city) {
        boolean result = super.addToy(toy, qty, city);
        notifyObservers();
        return result;
    }
}
