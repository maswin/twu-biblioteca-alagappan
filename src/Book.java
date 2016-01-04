public class Book {
    private final String name;
    private final String authorName;
    private final int yearPublished;

    public Book(String name, String authorName, int yearPublished) {
        this.name = name;
        this.authorName = authorName;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return String.format("%-25s %-20s %d", name, authorName, yearPublished);
    }
}
