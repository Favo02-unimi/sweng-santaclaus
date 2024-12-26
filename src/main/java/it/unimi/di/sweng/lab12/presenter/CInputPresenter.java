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

        if (token.length != 2) {
            input.showError("The input must be in the form toy:num");
            return;
        }

        Toy toy;
        Quantity qty;
        City city;

        try {
            toy = new Toy(token[0]);
        } catch (IllegalArgumentException e) {
            input.showError("City and toy must not be blank");
            return;
        }

        try {
            city = new City(cityStr);
        } catch (IllegalArgumentException e) {
            input.showError("City and toy must not be blank");
            return;
        }

        try {
            qty = Quantity.fromString(token[1]);
        } catch (IllegalArgumentException e) {
            input.showError("The number of toys must be a positive integer");
            return;
        }

        if (!model.addToy(toy, qty, city)) {
            input.showError("Invalid insertion (toy already present or city full)");
        }
    }
}
