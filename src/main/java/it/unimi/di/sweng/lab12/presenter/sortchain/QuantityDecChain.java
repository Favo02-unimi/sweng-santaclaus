package it.unimi.di.sweng.lab12.presenter.sortchain;

import it.unimi.di.sweng.lab12.model.objects.ToyInfo;
import org.jetbrains.annotations.NotNull;

public class QuantityDecChain implements SortChain {

    private final @NotNull SortChain next;

    public QuantityDecChain(@NotNull SortChain next) {
        this.next = next;
    }

    @Override
    public int compare(@NotNull ToyInfo toy1, @NotNull ToyInfo toy2) {
        int res = Integer.compare(toy2.qty().qty(), toy1.qty().qty());
        if (res == 0) {
            return next.compare(toy1, toy2);
        }
        return res;
    }
}
