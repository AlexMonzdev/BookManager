package com.alexmonzon;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class View {

    Scanner sc = new Scanner(System.in);
    BookManager bookManager = new BookManager();

    public void menu() {

        int option;
        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("1. Añadir Libro");
            System.out.println("2. Ver todos los libros");
            System.out.println("3. Eliminar libro");
            System.out.println("4. Cambiar Repositorio");
            System.out.println("5. Salir");

            System.out.println("Select the option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Option 1: Añadir Libro");
                    printAddBook();
                    break;
                case 2:
                    System.out.println("Option 2: Ver todos los libros");
                    imprimirlibros();
                    break;
                case 3:
                    System.out.println("Option 3: Eliminar libro");
                    printDeleteBook();
                    break;
                case 4:
                    System.out.println("Option 4: Cambiar Repositorio");
                    break;
                case 5:
                    System.out.println("Option 5: Salir");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (option != 5);
    }

    private void printAddBook() {
        System.out.println(" Introdusca el isbn. (El campo no puede estar vacio)");
        String isbn = sc.nextLine();
        System.out.println("introduce titulo. (El campo no puede estar vacío)");
        String title = sc.nextLine();
        System.out.println("Introduce autor. (El campo no puede estar vacío.)");
        String autor = sc.nextLine();

        try {
            bookManager.addBook(isbn, title, autor);
            System.out.println("El libro añadido con éxito.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void printDeleteBook(){
        System.out.println("Introduce un ISBN (ejemplo A123");
        String isbnToDelete = sc.nextLine();
        try{
            bookManager.deleteBook(isbnToDelete);
            System.out.println("El libro con ISBN " + isbnToDelete + " ha sido eliminado.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void imprimirlibros() {
        System.out.println(bookManager.listaLibros);
    }


}


