package book;

import java.util.Objects;

public class ProgrammerBook extends Book
{
    private String language;
    private int level;

    public ProgrammerBook(String title,String author,int price,String language,int level) {
        super(title, author, price);
        this.language = language;
        this.level = level;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ProgrammerBook programmerBook = (ProgrammerBook) object;
        return Objects.equals(language, programmerBook.language) && level == programmerBook.level;
    }

    public int hashCode() {
        return super.hashCode() + language.hashCode() + level % 3;
    }

    public String toString() {
        return "ProgrammerBook:" +
                "language=" + language + '\n' +
                "level=" + level;
    }
}
