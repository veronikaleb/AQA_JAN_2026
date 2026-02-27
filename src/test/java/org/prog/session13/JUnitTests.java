package org.prog.session13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Random;

public class JUnitTests {

    private Random random = new Random();

    class Android {
        int modelNumber;

        public Android() {
            this.modelNumber = random.nextInt(5) + 1;
        }
    }

    @Test
    public void testAndroidModel() {
        Android myPhone = new Android();

        System.out.println("==== Generated Android Model: " + myPhone.modelNumber + " ====");

        Assertions.assertTrue(myPhone.modelNumber >= 3,
                "Model number must be 3 or above! Current: " + myPhone.modelNumber);
    }

}