package com.streams.app.reducccion;

import com.streams.app.ejemplos.Empleado;

import java.util.List;

public class OperacionesReduccion1 {
    public static void main(String[] args) {

        //arreglo de numeros
        int [] numeros = {4,6,10,12,15,55,7,8,9,10,2,5,8,9,10,45,6,9,33,66,85,97,81,24,99};

        //Suma de elementos
        int suma = 0;
        for (int i = 0; i < numeros.length; i ++){
            suma += numeros[i];
        }
        System.out.println("La suma es: " + suma);

        //Promedio
        double promedio = suma / numeros.length;
        System.out.println("\nEl promedio es: " + promedio);

        //cuenta de elementos
        System.out.println("\nCantidad de elementos: " + numeros.length);

        //Obtener el maximo
        int maximo = numeros[0];
        for (int numero : numeros){
            if (numero > maximo){
                maximo = numero;
            }
        }
        System.out.println("\nEl maximo es: " + maximo);

        //Obtener el minimo
        int minimo = numeros[0];
        for (int numero : numeros){
            if (numero < minimo){
                minimo = numero;
            }
        }
        System.out.println("\nEl numero minimo es: " + minimo);

        //Empleados
        System.out.println("\nOperaciones de reduccion con empleados");
        List<Empleado> empleados = Empleado.empleados();

        //suma de salarios
        double sumaSalarios = 0.0;
        for (Empleado empleado : empleados){
            sumaSalarios += empleado.getIngresos();
        }
        System.out.println("\nLa suma de los salarios es: " + sumaSalarios);

        //Cantidad de empleados
        System.out.println("\nLa cantidad de empleados es: " + empleados.size());

        //Obtener empleados con salario maximo
        Empleado empMaximo = empleados.get(0);
        for (Empleado empleado : empleados){
            if (empleado.getIngresos() > empMaximo.getIngresos()){
                empMaximo = empleado;
            }
        }
        System.out.println("\nEmpleado maximo salario: " + empMaximo.getNombre() + " " + empMaximo.getIngresos());
    }
}
