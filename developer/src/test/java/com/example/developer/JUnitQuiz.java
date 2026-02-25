package com.example.developer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JUnitQuiz {

    @Test
    public void junitTest(){
        int num1 = 15;
        int num2 = 0;
        int num3 = -5;

        assertThat(num1).isPositive();
        assertThat(num2).isZero();
        assertThat(num3).isNegative();
    }
}
