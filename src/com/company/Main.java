package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        String opcion;
        String linea = "----------------------------------------------------------------";

        Biblioteca b = new Biblioteca();

        try
        {
            b.leeFicheroLibros("biblio.bin");
        }
        catch(Exception e)
        {
            System.out.println("No se ha podido encontrar o leer el fichero biblio.bin");
            salir = true;
        }

        while(!salir)
        {
            System.out.println("=========================================");
            System.out.println("BIBLIOTECA - Examen 3er Trimestre 2019-20");
            System.out.println("=========================================");
            System.out.println();
            System.out.println("1- Insertar nuevo libro");
            System.out.println("2- Listado de libros");
            System.out.println("3- Ordenar y mostrar listado ordenado");
            System.out.println("0- Salir");

            opcion = sc.nextLine();
            System.out.println();

            switch (opcion)
            {
                case "1":
                    String isbn, titulo, autor;
                    int nPaginas;
                    boolean leido;
                    System.out.println(linea);
                    System.out.println("Introduzca los datos del libro");
                    try
                    {
                        System.out.print("ISBN: ");
                        isbn = sc.nextLine();
                        System.out.print("Título: ");
                        titulo = sc.nextLine();
                        System.out.print("Autor: ");
                        autor = sc.nextLine();
                        System.out.print("Número de páginas: ");
                        nPaginas = Integer.parseInt(sc.nextLine());
                        System.out.print("Leído (true/false): ");
                        leido = Boolean.parseBoolean(sc.nextLine());

                        Libro l = new Libro(isbn, titulo, autor, nPaginas, leido);
                        b.insertaLibro(l);
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error en los datos, no se ha podido añadir el libro:" + e.getMessage());
                    }
                    System.out.println(linea);
                    break;

                case "2":
                    System.out.println(linea);
                    System.out.print(b);
                    System.out.println(linea);
                    break;

                case "3":
                    b.ordenaPorPaginasDesc();
                    System.out.println(linea);
                    System.out.print(b);
                    System.out.println(linea);
                    break;

                case "0":
                    salir = true;
                    System.out.println("Hasta la vista, baby");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
