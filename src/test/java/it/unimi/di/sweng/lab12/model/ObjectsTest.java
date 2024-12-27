package it.unimi.di.sweng.lab12.model;

import it.unimi.di.sweng.lab12.model.objects.City;
import it.unimi.di.sweng.lab12.model.objects.Quantity;
import it.unimi.di.sweng.lab12.model.objects.Toy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;

public class ObjectsTest {

    @ParameterizedTest
    @CsvSource({
            "Puffo",
            "Peluche",
            "PS5",
            "Super mario"
    })
    public void validToyTest(String name) {
        Toy SUT = new Toy(name);
        assertThat(SUT.name()).isEqualTo(name);
    }

    @ParameterizedTest
    @CsvSource({
            "''",
            "' '",
            "' \n '",
            "' \t '",
    })
    public void invalidToyTest(String name) {
        assertThatException().isThrownBy(() -> new Toy(name))
            .isInstanceOf(IllegalArgumentException.class)
            .withMessage("City and toy must not be blank");
    }

    @ParameterizedTest
    @CsvSource({
            "5",
            "2",
            "100",
    })
    public void validIntQuantityTest(int qty) {
        Quantity SUT = new Quantity(qty);
        assertThat(SUT.qty()).isEqualTo(qty);
    }

    @ParameterizedTest
    @CsvSource({
            "0,The number of toys must be a positive integer",
            "101,Quantity must be less or equal than 100",
            "-199,The number of toys must be a positive integer",
            "-1,The number of toys must be a positive integer",
    })
    public void invalidIntQuantityTest(int qty, String msg) {
        assertThatException().isThrownBy(() -> new Quantity(qty))
                .isInstanceOf(IllegalArgumentException.class)
                .withMessage(msg);
    }

    @ParameterizedTest
    @CsvSource({
            "5",
            "2",
            "100",
    })
    public void validStringQuantityTest(String qty) {
        Quantity SUT = Quantity.fromString(qty);
        assertThat(SUT.qty()).isEqualTo(Integer.parseInt(qty));
    }

    @ParameterizedTest
    @CsvSource({
            "0,The number of toys must be a positive integer",
            "ciao,The number of toys must be a positive integer",
            "'',The number of toys must be a positive integer",
            "9dasds,The number of toys must be a positive integer",
            "101,Quantity must be less or equal than 100",
            "-199,The number of toys must be a positive integer",
            "-1,The number of toys must be a positive integer",
    })
    public void invalidStringQuantityTest(String qty, String msg) {
        assertThatException().isThrownBy(() -> Quantity.fromString(qty))
                .isInstanceOf(IllegalArgumentException.class)
                .withMessage(msg);
    }

    @ParameterizedTest
    @CsvSource({
            "Milano",
            "Roma",
    })
    public void validCityTest(String name) {
        City SUT = new City(name);
        assertThat(SUT.name()).isEqualTo(name);
    }

    @ParameterizedTest
    @CsvSource({
            "''",
            "' '",
            "' \n '",
            "' \t '",
    })
    public void invalidCityTest(String name) {
        assertThatException().isThrownBy(() -> new City(name))
                .isInstanceOf(IllegalArgumentException.class)
                .withMessage("City and toy must not be blank");
    }
}
