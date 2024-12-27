package it.unimi.di.sweng.lab12.presenter;

import it.unimi.di.sweng.lab12.model.IState;
import it.unimi.di.sweng.lab12.model.Model;
import it.unimi.di.sweng.lab12.model.State;
import it.unimi.di.sweng.lab12.model.objects.City;
import it.unimi.di.sweng.lab12.model.objects.Quantity;
import it.unimi.di.sweng.lab12.model.objects.Toy;
import it.unimi.di.sweng.lab12.model.objects.ToyInfo;
import it.unimi.di.sweng.lab12.view.InputSanta;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;
import static org.mockito.Mockito.*;

public class InputPresenterTest {

    private InputPresenter SUT;
    private Model model;
    private InputSanta view;

    @BeforeEach
    public void setup() {
        model = spy(new Model());
        view = mock(InputSanta.class);
        SUT = new CInputPresenter(model, view);
    }

    @ParameterizedTest
    @CsvSource({
            "Puffo:4,Milano,Puffo,4,Milano",
            "Peluche:1,Roma,Peluche,1,Roma",
    })
    public void testAddToy1(String toyQty, String city, String toyName, int qty, String cityName) {
        SUT.action(toyQty, city);
        verify(model, times(1)).addToy(new Toy(toyName), new Quantity(qty), new City(cityName));
    }

    @ParameterizedTest
    @CsvSource({
            "Puffo 4,Milano,The input must be in the form toy:num",
            "Puffo:4:5,Milano,The input must be in the form toy:num",
            "Puffo:,Milano,The input must be in the form toy:num",
            ":4,Milano,City and toy must not be blank",
            "Puffo:4,'  ',City and toy must not be blank",
            "Puffo:-2,Milano,The number of toys must be a positive integer",
            "Puffo:0,Milano,The number of toys must be a positive integer",
            "Puffo:101,Milano,The number of toys must be a positive integer",
            "Puffo:ciao,Milano,The number of toys must be a positive integer",
    })
    public void testNotifyErrors(String toyQty, String city, String error) {
        SUT.action(toyQty, city);
        verify(view, times(1)).showError(error);
    }

    @Test
    public void testNotifyCityFull() {
        SUT.action("Puffo:100", "Milano");
        SUT.action("Maiale:1", "Milano");
        verify(view, times(1)).showError("Invalid insertion (toy already present or city full)");
    }

}
