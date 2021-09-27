package book;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int price;
    private static int edition;

    public Book(String title,String author,int price) {
        this.title = title;
        this.author = author;
        this.price = price;
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
