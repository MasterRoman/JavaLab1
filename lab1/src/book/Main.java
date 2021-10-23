package book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var book1 = new Book("1","1",1);
        var book2 = new Book("5","5",5);
        var book3 = new Book("2","5",1);
        var book4 = new Book("1","3",1);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        Comparator<Book> compTitleAuthor = new BookTitleComparator().thenComparing(new BookAuthorComparator());
        Comparator<Book> compAuthorTitle = new BookAuthorComparator().thenComparing(new BookTitleComparator());
        Comparator<Book> compTitleAuthorPrice = new BookTitleComparator().thenComparing(new BookAuthorComparator())
                                                                         .thenComparing(new BookPriceComparator());
        books.sort(compTitleAuthor);

        System.out.println("compTitleAuthor");
        for (Book book:books) {
            System.out.println(book.toString());
        }

        books.sort(compAuthorTitle);
        System.out.println("compAuthorTitle");
        for (Book book:books) {
            System.out.println(book.toString());
        }

        books.sort(compTitleAuthorPrice);
        System.out.println("compTitleAuthorPrice");
        for (Book book:books) {
            System.out.println(book.toString());
        }

    }
}
