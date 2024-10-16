package com.streams.app.ejemplos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Stream5 {
    public static void main(String[] args) {
        Path path = Paths.get("src/com/streams/app/resourses/archivo.txt");
        try (Stream<String> lineas = Files.lines(path)){
            lineas.forEach(linea -> {
                System.out.println("Linea--------");
                System.out.println(linea);
            });
        }catch (IOException e){
            e.printStackTrace();
        }
        
        Path dir = Paths.get(".");
        System.out.printf("%nEl arbol de archivos del proyecto para: %s es $n " , dir.toAbsolutePath());

        try (Stream<Path> paths = Files.walk(dir)){
            paths.forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
