package book;

import java.util.Comparator;
import java.util.Objects;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int price;
    private int isbn;
    private static int edition;

    private static int count = 0;

    public Book(String title,String author,int price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = ++count;
    }

    public int compareTo(Book p){
        if(isbn == p.getIsbn())
            return 0;
        else if(isbn > p.getIsbn())
            return 1;
        else
            return -1;
    }

    public int getIsbn(){
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public String toString(){
        return "Book:" +
                "title=" + title + '\n' +
                "author=" + author + '\n' +
                "price=" + price;
    }

    public int hashCode(){
        return price % 5 + edition % 2 + title.hashCode() + author.hashCode();
    }

    public boolean equals(Object object){
        if (this == object) return  true;
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return Objects.equals(title, book.title) && price == book.price && Objects.equals(author, book.author);
    }

    protected Object clone() {
        return new Book(this.title,this.author,this.price);
    }
}

class BookTitleComparator implements Comparator<Book>{

    public int compare(Book a, Book b){
        return a.getTitle().compareTo(b.getTitle());
    }
}

class BookAuthorComparator implements Comparator<Book>{

    public int compare(Book a, Book b){
        return a.getAuthor().compareTo(b.getAuthor());
    }

}


class BookPriceComparator implements Comparator<Book>{

    public int compare(Book a, Book b){
        if(a.getPrice() > b.getPrice())
            return 1;
        else if(a.getPrice() < b.getPrice())
            return -1;
        else
            return 0;
    }
}
