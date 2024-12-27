package it.unimi.di.sweng.lab12;

import it.unimi.di.sweng.lab12.model.Model;
import it.unimi.di.sweng.lab12.presenter.CDisplayPresenter;
import it.unimi.di.sweng.lab12.presenter.CInputPresenter;
import it.unimi.di.sweng.lab12.presenter.DisplayPresenter;
import it.unimi.di.sweng.lab12.presenter.InputPresenter;
import it.unimi.di.sweng.lab12.presenter.filterstrategy.FilterCity;
import it.unimi.di.sweng.lab12.presenter.filterstrategy.FilterToy;
import it.unimi.di.sweng.lab12.presenter.formatstrategy.CityQuantity;
import it.unimi.di.sweng.lab12.presenter.formatstrategy.ToyQuantity;
import it.unimi.di.sweng.lab12.presenter.sortchain.AlphabeticCityChain;
import it.unimi.di.sweng.lab12.presenter.sortchain.AlphabeticToyChain;
import it.unimi.di.sweng.lab12.presenter.sortchain.QuantityDecChain;
import it.unimi.di.sweng.lab12.presenter.sortchain.SortChain;
import it.unimi.di.sweng.lab12.view.DisplayView;
import it.unimi.di.sweng.lab12.view.InputSanta;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
  //TODO da completare

  public static final int MAXTOYS = 3;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    primaryStage.setTitle("Santa is coming to...");

    InputSanta input = new InputSanta();
    DisplayView displayCity1 = new DisplayView(MAXTOYS, "Milano");
    DisplayView displayCity2 = new DisplayView(MAXTOYS, "Roma");
    DisplayView displayToy1 = new DisplayView(MAXTOYS, "Peluche");
    DisplayView displayToy2 = new DisplayView(MAXTOYS, "PS5");

    GridPane gridPane = new GridPane();
    gridPane.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    gridPane.setPadding(new Insets(10, 10, 10, 10));

    gridPane.add(input, 0, 0);
    GridPane.setColumnSpan(input, GridPane.REMAINING);

    gridPane.add(displayCity1, 1, 1);
    gridPane.add(displayCity2, 2, 1);
    gridPane.add(displayToy1, 3, 1);
    gridPane.add(displayToy2, 4, 1);

    Model model = new Model();

    InputPresenter inputPresenter = new CInputPresenter(model, input);

    SortChain citySort = new AlphabeticToyChain(SortChain.STABLE);
    SortChain toySort = new QuantityDecChain(new AlphabeticCityChain(SortChain.STABLE));

    DisplayPresenter milano = new CDisplayPresenter(model, displayCity1, new FilterCity("Milano"), citySort, ToyQuantity.S);
    DisplayPresenter roma = new CDisplayPresenter(model, displayCity2, new FilterCity("Roma"), citySort, ToyQuantity.S);

    DisplayPresenter peluche = new CDisplayPresenter(model, displayToy1, new FilterToy("Peluche"), toySort, CityQuantity.S);
    DisplayPresenter ps5 = new CDisplayPresenter(model, displayToy2, new FilterToy("PS5"), toySort, CityQuantity.S);

    Scene scene = new Scene(gridPane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
