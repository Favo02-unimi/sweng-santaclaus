package it.unimi.di.sweng.lab12.presenter;

import it.unimi.di.sweng.lab12.model.objects.ToyInfo;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface DisplayPresenter {
    public void update(@NotNull List<ToyInfo> state);
}
