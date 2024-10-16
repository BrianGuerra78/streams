package com.streams.app.reducccion;

import java.util.stream.IntStream;

public class OperacionesReduccion4 {
    public static void main(String[] args) {
        System.out.println(IntStream.range(1,20).summaryStatistics());

        System.out.println("Suma: " + IntStream.range(1, 20).summaryStatistics().getSum());

        System.out.println("Promedio: " + IntStream.range(1,20).summaryStatistics().getAverage());
    }
}
