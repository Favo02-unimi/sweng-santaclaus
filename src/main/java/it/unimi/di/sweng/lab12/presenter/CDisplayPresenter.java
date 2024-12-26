package it.unimi.di.sweng.lab12.presenter;

import it.unimi.di.sweng.lab12.Observer;
import it.unimi.di.sweng.lab12.model.Model;
import it.unimi.di.sweng.lab12.model.objects.ToyInfo;
import it.unimi.di.sweng.lab12.presenter.filterstrategy.FilterStrategy;
import it.unimi.di.sweng.lab12.presenter.sortstrategy.SortStrategy;
import it.unimi.di.sweng.lab12.view.OutputView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CDisplayPresenter implements DisplayPresenter, Observer<List<ToyInfo>> {

    private final @NotNull OutputView view;
    private final @NotNull FilterStrategy filterStrategy;
    private final @NotNull SortStrategy sortStrategy;

    public CDisplayPresenter(@NotNull Model model, @NotNull OutputView view, @NotNull FilterStrategy filterStrategy, @NotNull SortStrategy sortStrategy) {
        this.view = view;
        this.filterStrategy = filterStrategy;
        this.sortStrategy = sortStrategy;

        model.addObserver(this);
    }

    @Override
    public void update(@NotNull List<ToyInfo> state) {
        var res = state
                .stream()
                .filter(filterStrategy::valid)
                .sorted(sortStrategy::compare)
                .toList();

        view.reset();
        for (int i = 0; i < res.size(); i++) {
            view.set(i, res.get(i).toString());
        }
    }
}
