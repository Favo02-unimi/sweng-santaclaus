package it.unimi.di.sweng.lab12.view;
import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DisplayViewTest {

    private static DisplayView SUT;

    @BeforeAll
    public static void setup() {
        Platform.startup(() -> {}); // Start the JavaFX Platform
        SUT = new DisplayView(4, "TEST");
    }

    @Test
    public void resetViewTest() {
        for (int i = 0; i < SUT.size(); i++) {
            assertThat(SUT.get(i)).isEqualTo("");
        }
    }
}
