package com.streams.app.ejemplos;

import java.util.List;
import java.util.function.Predicate;

public class OperacionesFilter {
    public static void main(String[] args) {
        List<Empleado> empleados = Empleado.empleados();

        System.out.println("Empleados hombres: ");
        empleados.stream()
                .filter(new Predicate<Empleado>() {
                    @Override
                    public boolean test(Empleado empleado) {
                        return empleado.esHombre();
                    }
                }).forEach(emp -> System.out.println(emp.getNombre()));

        System.out.println("\nEmpleados de genero Mujer");
        empleados.stream()
                .filter(Empleado::esMujer)
                .forEach(emp -> System.out.println(emp.getNombre()));

        System.out.println("\nEmpleados mayores de 25 años");
        empleados.stream().filter(emp -> emp.getEdad() > 25)
                .forEach(emp -> System.out.println(emp.getNombre() + " " + emp.getEdad()));

        System.out.println("\nPersonal masculino cuya letra comience con A");
        empleados.stream().filter(Empleado::esHombre)
                .filter(empleado -> empleado.getNombre().startsWith("A"))
                .forEach(empleado -> System.out.println(empleado.getNombre()));

        System.out.println("\nPersonal masculino que gana arriba de 500");
        empleados.stream().filter(emp -> emp.esHombre() && emp.getIngresos() > 500)
                .forEach(emp -> System.out.println(emp.getNombre() + " " + emp.getIngresos()));

        System.out.println("\nPersonal femenino mayor de 25 años con ingresos por encima de los 300");
        Predicate<Empleado> empFemenino = emp -> emp.esMujer();
        Predicate<Empleado> empMayor25 = emp -> emp.getEdad() > 25;
        Predicate<Empleado> empMayo300 = emp -> emp.getIngresos() > 300;
        Predicate<Empleado> fem25300 = empFemenino.and(empMayor25).and(empMayo300);

        empleados.stream().filter(fem25300).forEach(empleado -> System.out.println(empleado.getNombre() + " "
        + " " + empleado.getGenero() + " " + empleado.getEdad() + " " + empleado.getIngresos()));

        System.out.println("Cantidad total: " + empleados.stream().filter(fem25300).count());

    }
}
