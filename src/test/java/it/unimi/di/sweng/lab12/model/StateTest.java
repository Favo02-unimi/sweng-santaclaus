package it.unimi.di.sweng.lab12.model;

import it.unimi.di.sweng.lab12.model.objects.City;
import it.unimi.di.sweng.lab12.model.objects.Quantity;
import it.unimi.di.sweng.lab12.model.objects.Toy;
import it.unimi.di.sweng.lab12.model.objects.ToyInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;

public class StateTest {

    private static IState SUT;

    @BeforeEach
    public void setup() {
        SUT = new State();
    }

    @Test
    public void testAddToy1() {
        SUT.addToy(new Toy("toy1"), new Quantity(1), new City("city1"));
        assertThat(SUT.getToys()).containsExactly(new ToyInfo(new Toy("toy1"), new Quantity(1), new City("city1")));
    }

    @Test
    public void testAddToyMultipleTimes() {
        SUT.addToy(new Toy("toy1"), new Quantity(1), new City("city1"));

        assertThatException().isThrownBy(() -> SUT.addToy(new Toy("toy1"), new Quantity(10), new City("city1")))
                .isInstanceOf(IllegalArgumentException.class)
                .withMessage("The toy has already been added to the city");

        assertThat(SUT.getToys()).containsExactly(new ToyInfo(new Toy("toy1"), new Quantity(1), new City("city1")));
    }

    @Test
    public void testAddTooMuch() {
        SUT.addToy(new Toy("toy1"), new Quantity(1), new City("city1"));
        SUT.addToy(new Toy("toy2"), new Quantity(10), new City("city1"));
        SUT.addToy(new Toy("toy3"), new Quantity(80), new City("city1"));



        assertThatException().isThrownBy(() -> SUT.addToy(new Toy("toy4"), new Quantity(10), new City("city1")))
                .isInstanceOf(IllegalArgumentException.class)
                .withMessage("The quantity of toys in this city is over 100");

        assertThat(SUT.getToys()).containsExactly(
                new ToyInfo(new Toy("toy1"), new Quantity(1), new City("city1")),
                new ToyInfo(new Toy("toy2"), new Quantity(10), new City("city1")),
                new ToyInfo(new Toy("toy3"), new Quantity(80), new City("city1"))
        );
    }

}
