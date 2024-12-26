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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;
import static org.mockito.Mockito.*;

public class InputPresenterTest {

    private static InputPresenter SUT;
    private static Model model;

    @BeforeAll
    public static void setup() {
        model = mock(Model.class);
        SUT = new CInputPresenter(model, mock(InputSanta.class));
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

}
