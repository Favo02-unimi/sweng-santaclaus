package it.unimi.di.sweng.lab12.presenter.sortstrategy;

import it.unimi.di.sweng.lab12.model.objects.ToyInfo;
import org.jetbrains.annotations.NotNull;

public enum QuantityDec implements SortStrategy {
    S; // SINGLETON

    @Override
    public int compare(@NotNull ToyInfo toy1, @NotNull ToyInfo toy2) {
        int qt_compare = Integer.compare(toy2.qty().qty(), toy1.qty().qty());
        if (qt_compare != 0) {
            return qt_compare;
        }
        return toy1.toy().name().compareTo(toy2.toy().name());
    }
}
