package it.unimi.di.sweng.lab12.model;

import it.unimi.di.sweng.lab12.model.objects.City;
import it.unimi.di.sweng.lab12.model.objects.Quantity;
import it.unimi.di.sweng.lab12.model.objects.Toy;
import it.unimi.di.sweng.lab12.model.objects.ToyInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StateTest {

    private static IState SUT;

    @BeforeAll
    public static void setup() {
        SUT = new State();
    }

    @Test
    public void testAddToy1() {
        SUT.addToy(new Toy("toy1"), new Quantity(1), new City("city1"));
        assertThat(SUT.getToys()).containsExactly(new ToyInfo(new Toy("toy1"), new Quantity(1), new City("city1")));
    }

}
