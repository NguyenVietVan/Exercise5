package entity;

public class Book extends Document {
    private String authorName;
    private int numPage;
    public Book(int id, String publisher, int numRelease, String authorName,
                int numPage) {

        super(id, publisher, numRelease);
        this.authorName = authorName;
        this.numPage = numPage;
    }
    @Override
    public String toString() {
        return super.toString() + " Category: Book [authorName=" +

                authorName + ", numPage=" + numPage + "]";
    }
}