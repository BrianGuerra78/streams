package com.streams.app.ejemplos;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream3 {
    public static void main(String[] args) {
        IntStream nustream = Arrays.stream(new int[]{1,2,3,4,5,6});
        nustream.forEach(System.out::println);

        Stream<String> nombres = Arrays.stream(new String[]{"Juan","Pedro","Alex","Marcos"});
        nombres.forEach(System.out::println);

        Set<String> lenguajesSet = new HashSet<>();
        lenguajesSet.add("JAVA");
        lenguajesSet.add("C++");
        lenguajesSet.add("C#");

        Stream<String> lenguajesStream = lenguajesSet.stream();
        lenguajesStream.forEach(System.out::println);

        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Juan", 20, 1.78, 85));
        estudiantes.add(new Estudiante("Juan", 20, 1.78, 85));
        estudiantes.add(new Estudiante("Juan", 20, 1.78, 85));
        estudiantes.add(new Estudiante("Juan", 20, 1.78, 85));
        estudiantes.add(new Estudiante("Juan", 20, 1.78, 85));

        Stream<Estudiante> estudiantesStream = estudiantes.parallelStream();
        estudiantesStream.forEach(estudiante -> System.out.println(estudiante.getIdentificacion()));


    }
}
