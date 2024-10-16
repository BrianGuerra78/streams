package com.streams.app.reducccion;

import com.streams.app.ejemplos.Empleado;

import java.util.List;
import java.util.stream.IntStream;

public class OperacionesReduccion2 {
    public static void main(String[] args) {

        int [] numeros = {4,6,10,12,15,55,7,8,9,10,2,5,8,9,10,45,6,9,33,66,85,97,81,24,99};

        List<Empleado> empleados = Empleado.empleados();

        //Operaciones de reduccion con numeros

        //suma de los elementos
        System.out.println("\nLa suma es: " + IntStream.of(numeros).sum());

        //Obtener promedio de los elementos
        System.out.println("\nEl promedio es: " + IntStream.of(numeros).average().getAsDouble());

        //Obtener minimo y maximo
        System.out.println("\nEl valor maximo es: " + IntStream.of(numeros).max().getAsInt());
        System.out.println("\nEl valor minimo es: " + IntStream.of(numeros).min().getAsInt());

        //Contar cantidad de elementos
        System.out.println("\nCantidad de elementos: " + IntStream.of(numeros).count());

        //Operaciones con empleados
        System.out.println("\nOperaciones con empleados y streams");
        System.out.println("\nSuma de salarios: " + empleados.stream()
                .mapToDouble(Empleado::getIngresos)
                .sum());

        //Obtener el empleado con el salario maximo
        Empleado empMax = empleados.stream().max(
                (emp1, emp2) -> (int)(emp1.getIngresos() - emp2.getIngresos())
        ).get();
        System.out.println("\nEmpleado con el maximo salario: " + empMax.getNombre() + " " + empMax.getIngresos());
    }
}
