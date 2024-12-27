package it.unimi.di.sweng.lab12.presenter.sortchain;

import it.unimi.di.sweng.lab12.model.objects.ToyInfo;
import org.jetbrains.annotations.NotNull;

public interface SortChain {
    int compare(@NotNull ToyInfo toy1, @NotNull ToyInfo toy2);

    // end of the chain, with Null Object
    SortChain STABLE = (@NotNull ToyInfo toy1, @NotNull ToyInfo toy2) -> 0;
}
