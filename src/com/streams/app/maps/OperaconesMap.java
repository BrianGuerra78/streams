package com.streams.app.maps;

import com.streams.app.ejemplos.Empleado;

import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class OperaconesMap {
    public static void main(String[] args) {
        IntStream.rangeClosed(1,5)
                .map(new IntUnaryOperator() {
                    @Override
                    public int applyAsInt(int numero) {
                        return numero * numero;
                    }
                }).forEach(System.out::println);

        System.out.println("---------------------");
        IntStream.rangeClosed(1,10).map(n -> n* 2).forEach(System.out::println);

        List<Empleado> empleados = Empleado.empleados();
        System.out.println("\nPromedio de ingresos de personal femenino mayor de 25 años");

        double suma = empleados.stream().filter(emp -> emp.esMujer())
                .filter(emp -> emp.getEdad() > 25)
                .mapToDouble(emp -> emp.getIngresos())
                .sum();

        double promedio = suma / empleados.stream().filter(emp -> emp.esMujer())
                .filter(emp -> emp.getEdad() >25).count();

        System.out.println("El promedio es: " + promedio);
    }
}
