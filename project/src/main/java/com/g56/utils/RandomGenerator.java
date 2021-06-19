package com.g56.utils;

import java.awt.*;
import java.util.Random;

public class RandomGenerator {
    public static int getRandomNumber(int min, int max){
        Random r = new Random();
        if(min == max){
            return min;
        }
        return r.nextInt(max-min)+min;
    }
}
