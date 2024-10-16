package com.streams.app.ejemplos;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1 {
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("Curso de programacion");
        stream1.forEach(System.out::println);

        Stream<String> stream2 = Stream.of("curso1", "curso2","curso3","curso4");
        stream2.forEach(System.out::println);

        String[] arreglo = {"java", "C++", "C#", "ruby"};
        Stream<String> stream3 = Stream.of(arreglo);
        stream3.forEach(System.out::println);

        Stream<Estudiante> streamEstudiantes = Stream.<Estudiante>builder()
                .add(new Estudiante("n01", 17, 1.70, 9.5))
                .add(new Estudiante("n02", 21, 1.70,9.5))
                .build();
        streamEstudiantes.forEach(estudiante -> System.out.println(estudiante.getIdentificacion()));

        IntStream unoAVeinte = IntStream.rangeClosed(1,20);
        unoAVeinte.forEach(System.out::println);
    }
}
