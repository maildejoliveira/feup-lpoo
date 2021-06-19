package com.g56.utils;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Positive;
import org.junit.jupiter.api.Assertions;

public class RandomGeneratorTest {
    @Property
    public void randomLimits(@ForAll @Positive int min, @ForAll @Positive int max){
        if(min < max){
            int number = RandomGenerator.getRandomNumber(min, max);
            Assertions.assertTrue(number>=min);
            Assertions.assertTrue(number<max);
        }
    }
}
