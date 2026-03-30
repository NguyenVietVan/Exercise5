package entity;
import java.time.LocalDate;
public class Magazine extends Document {
    private int idRelease;
    private LocalDate monthRelease;
    public Magazine(int id, String publisher, int numRelease, int idRelease, LocalDate monthRelease) {
        super(id,publisher,numRelease);
        this.idRelease = idRelease;
        this.monthRelease = monthRelease;
    }
    @Override
    public String toString() {
        return super.toString() + " Category: Magazine [idRelease=" +
                idRelease + ", monthRelease=" + monthRelease + "]";
    }
}
