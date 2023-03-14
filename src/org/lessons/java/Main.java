package org.lessons.java;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean isAValidNumber = false;
        int userNumber = 0;
        System.out.print("Quanti libri vuoi aggiungere? ");

        while (!isAValidNumber){
            try {
                userNumber = Integer.parseInt(scan.nextLine());
                isAValidNumber = true;
            } catch (IllegalArgumentException e){
                System.out.println("Inserisci un numero valido");
            }
        }

        Book[] books = new Book[userNumber];
        int i = 0;

        while (i < books.length) {
            System.out.print("Nome del libro: ");
            String title = scan.nextLine();

            System.out.println("------");
            System.out.print("Numero di pagine: ");
            int bookPages = 0;
            try{
                bookPages = Integer.parseInt(scan.nextLine());
            } catch (IllegalArgumentException e){
                System.out.println("Il numero di pagine deve essere un numero");
                if(i > 0){
                    --i;
                } else {
                    i = 0;
                }
            }

            System.out.println("------");
            System.out.print("Autore del libro: ");
            String author = scan.nextLine();

            System.out.println("------");
            System.out.print("Editore del libro: ");
            String publisher = scan.nextLine();

            try {
                Book b = new Book(title, bookPages, author, publisher);
                System.out.println("Ecco il tuo libro: " + b.toString());
                books[i] = b;
                i++;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage() + " reinserisci i dati");
                if(i > 0){
                    --i;
                } else {
                    i = 0;
                }
            } catch (NullPointerException e){
                System.out.println("uno dei campi è null");
                if(i > 0){
                    --i;
                } else {
                    i = 0;
                }
            } finally {
                System.out.println("------");
            }

        }

        System.out.println("Ecco i tuoi libri: " + Arrays.toString(books));
    }
}
