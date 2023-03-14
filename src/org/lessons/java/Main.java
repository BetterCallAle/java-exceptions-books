package org.lessons.java;

public class Main {
    public static void main(String[] args) {
        try {
            Book b = new Book("ciao", 2, "dd", "cc");
            System.out.println(b.toString());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            System.out.println("uno dei campi è null");
        }
    }
}
