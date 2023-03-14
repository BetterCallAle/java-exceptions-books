package org.lessons.java;

public class Book {
    private String title;
    private int pagesNumber;
    private String author;
    private String publisher;

    //CONSTRUCTOR
    public Book (String title, int pagesNumber, String author, String publisher) throws IllegalArgumentException {

        checkPagesNumber(pagesNumber);

        String[] args = {title, author, publisher};

        for (String arg : args) {
            checkString(arg);
        }

        this.title = title;
        this.pagesNumber = pagesNumber;
        this.author = author;
        this.publisher = publisher;
    }

    //METHODS


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pagesNumber=" + pagesNumber +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }

    private void checkPagesNumber(int num){
        if (num <= 0){
            throw new IllegalArgumentException("Il numero di pagine deve essere maggiore di 0");
        }
    }

    private void checkString(String s){
        if(s.equals(" ") || s.isEmpty()){
            throw new IllegalArgumentException("Uno dei campi è mancante");
        }
    }
}
