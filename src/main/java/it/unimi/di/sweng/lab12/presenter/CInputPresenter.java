package it.unimi.di.sweng.lab12.presenter;

import it.unimi.di.sweng.lab12.model.Model;
import it.unimi.di.sweng.lab12.model.objects.City;
import it.unimi.di.sweng.lab12.model.objects.Quantity;
import it.unimi.di.sweng.lab12.model.objects.Toy;
import it.unimi.di.sweng.lab12.view.InputSanta;
import org.jetbrains.annotations.NotNull;

public class CInputPresenter implements InputPresenter {

    private final @NotNull Model model;
    private final @NotNull InputSanta input;

    public CInputPresenter(@NotNull Model model, @NotNull InputSanta input) {
        this.model = model;
        this.input = input;

        input.addHandlers(this);
    }

    @Override
    public void action(@NotNull String toyQty, @NotNull String cityStr) {
        String[] token = toyQty.split(":");

        Toy toy = new Toy(token[0]);
        Quantity qty = Quantity.fromString(token[1]);
        City city = new City(cityStr);

        model.addToy(toy, qty, city);
    }
}
