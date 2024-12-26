package it.unimi.di.sweng.lab12.presenter;

import it.unimi.di.sweng.lab12.Observer;
import it.unimi.di.sweng.lab12.model.Model;
import it.unimi.di.sweng.lab12.model.objects.ToyInfo;
import it.unimi.di.sweng.lab12.presenter.filterstrategy.FilterStrategy;
import it.unimi.di.sweng.lab12.presenter.formatstrategy.FormatStrategy;
import it.unimi.di.sweng.lab12.presenter.sortstrategy.SortStrategy;
import it.unimi.di.sweng.lab12.view.OutputView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static java.lang.Math.min;

public class CDisplayPresenter implements DisplayPresenter, Observer<List<ToyInfo>> {

    private final @NotNull OutputView view;
    private final @NotNull FilterStrategy filterStrategy;
    private final @NotNull SortStrategy sortStrategy;
    private final @NotNull FormatStrategy formatStrategy;

    public CDisplayPresenter(@NotNull Model model, @NotNull OutputView view,
                             @NotNull FilterStrategy filterStrategy, @NotNull SortStrategy sortStrategy, @NotNull FormatStrategy formatStrategy) {
        this.view = view;
        this.filterStrategy = filterStrategy;
        this.sortStrategy = sortStrategy;
        this.formatStrategy = formatStrategy;

        model.addObserver(this);
    }

    @Override
    public void update(@NotNull List<ToyInfo> state) {
        var res = state
                .stream()
                .filter(filterStrategy::valid)
                .sorted(sortStrategy::compare)
                .map(formatStrategy::format)
                .toList();

        view.reset();
        for (int i = 0; i < min(view.size(), res.size()); i++) {
            view.set(i, res.get(i));
        }
    }
}
