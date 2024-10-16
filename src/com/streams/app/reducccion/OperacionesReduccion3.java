package com.streams.app.reducccion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class OperacionesReduccion3 {
    public static void main(String[] args) {
        int [] numeros = {4,6,10,12,15,55,7,8,9,10,2,5,8,9,10,45,6,9,33,66,85,97,81,24,99};
        int suma = IntStream.of(numeros).reduce(0, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });
        System.out.println("La suma es: " + suma);

        int suma2 = IntStream.of(numeros).reduce(0, (num1,num2) -> num1 + num2);
        System.out.println("La suma2 es: " + suma2);

        int suma3 = IntStream.of(numeros).reduce(0, (num1,num2) -> Integer.sum(num1 , num2));
        System.out.println("La suma3 es: " + suma3);

        int suma4 = IntStream.of(numeros).reduce(0, Integer::sum);
        System.out.println("La suma4 es: " + suma4);


        //quitar comas al archivo de texto
        Path path1 = Paths.get("src/com/streams/app/resourses/archivo.txt");
        String texto = "";
        try (Stream<String> lineas  = Files.lines(path1)){
            lineas.map(linea -> linea.replace(", " , ""))
                    .reduce("",(linea1,linea2)-> linea1.concat("\n").concat(linea2));
        }catch (IOException ex){
            ex.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/com/streams/app/resourses/archivo2.txt"))) {
            bw.write(texto);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
