package it.unimi.di.sweng.lab12.model;

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
            .withMessage("Name cannot be blank");
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
            "0,Quantity must be positive",
            "101,Quantity must be less or equal than 100",
            "-199,Quantity must be positive",
            "-1,Quantity must be positive",
    })
    public void invalidIntQuantityTest(int qty, String msg) {
        assertThatException().isThrownBy(() -> new Quantity(qty))
                .isInstanceOf(IllegalArgumentException.class)
                .withMessage(msg);
    }
}
