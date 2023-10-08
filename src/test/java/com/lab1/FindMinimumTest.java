package com.lab1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.Arrays;
import java.util.Collection;

import static com.lab1.Main.findMinimum;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FindMinimumTest {
    private static final double EPSILON = 1e-6;

    @ParameterizedTest
    @MethodSource("provideDataForFindMinimum")
    public void testFindMinimum(double a, double b, Function<Double, Double> function, double expected) {
        double result = findMinimum(a, b, function);
        assertEquals(expected, result, EPSILON);
    }

    private static Collection<Object[]> provideDataForFindMinimum() {
        return Arrays.asList(new Object[][] {
                {0, 10, (Function<Double, Double>) x -> x * x, 0},
                {-2, -0.5, (Function<Double, Double>) x -> 2 * x + x * x / 5, -1.999999642},
                {-1, -0.5, (Function<Double, Double>) x -> 2 * x + Math.pow(x, 2) - Math.pow(x, 3) / 5, -0.805399417}
        });
    }
}