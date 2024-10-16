package com.streams.app.maps;

import com.streams.app.ejemplos.Empleado;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OperacionesSorted {
    public static void main(String[] args) {
        System.out.println("Nombres ordenados: ");
        Arrays.asList("Alfredo", "Maria", "Daniel", "Brenda")
                .stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\nNumeros ordenados: ");
        Arrays.asList(1,2,7,8,9,1,5,2,1,5,3,5)
                .stream().sorted()
                .forEach(System.out::println);

        System.out.println("---------------------------");
        List<Empleado> empleados = Empleado.empleados();
        empleados.stream().sorted()
                .forEach(emp -> System.out.println(emp.getNombre()));

        System.out.println("\nEmpleados ordenados por edad");
        empleados.stream().sorted(new Comparator<Empleado>() {
            @Override
            public int compare(Empleado o1, Empleado o2) {
                return o1.getEdad() - o2.getEdad();
            }
        }).forEach(emp -> System.out.println(emp.getNombre() + " " + emp.getEdad()));

        System.out.println("\nEmpleados ordenados por salarios mayores de 25 años:");
        empleados.stream().filter(emp -> emp.getEdad() > 25)
                .sorted((emp1, emp2) -> (int) (emp1.getIngresos() - emp2.getIngresos()))
                .forEach(emp -> System.out.println(emp.getNombre() + " " + emp.getIngresos()));
    }
}
