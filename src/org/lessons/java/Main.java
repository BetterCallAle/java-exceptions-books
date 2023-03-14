package org.lessons.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
            } catch (NullPointerException e){
                System.out.println("uno dei campi è null");
            } finally {
                System.out.println("------");
            }
        }

        scan.close();

        //Create and write the books.txt file

        FileWriter newFile = null;
        try {
            newFile = new FileWriter("./books.txt", true);
            for (Book book : books){
                newFile.write(book.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Il file non può essere aperto");
        } finally {
            if(newFile != null){
                try {
                    newFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //Read the books.txt file
        File booksFile = null;
        try {
            booksFile = new File("./books.txt");
        } catch (NullPointerException e){
            System.out.println("Impossibile trovare il file");
        }

        System.out.println("Ecco i tuoi libri");

        Scanner reader = null;

        try {
            reader = new Scanner(booksFile);

            while(reader.hasNext()){
                String bookData = reader.nextLine();

                System.out.println(bookData);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Impossibile leggere il file");;
        } finally {
            if(reader != null){
                reader.close();
            }
        }

    }


}
