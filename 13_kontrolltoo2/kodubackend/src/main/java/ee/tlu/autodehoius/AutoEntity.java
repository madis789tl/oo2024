package ee.tlu.autodehoius;

// jpa moodulist pärinev. Hibernate.
// Kui räägite ChatGPT-ga
// import javax.persistence.Table
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@Table(name = "auto") // vabatahtlik - nime vahetuseks
@Entity // andmebaasipanekuks
@NoArgsConstructor // andmebaasipanekuks

public class AutoEntity {
    @Id // alati unikaalne - kustutamiseks, võtmiseks, muutmiseks
    String mark;
    int pikkus;
    int mass;
    int aasta;


    // parem klõps -> Generate -> Constructor -> valida kõik
//    public ToiduaineEntity(String nimetus, int valk, int rasv, int sysivesik) {
//        this.nimetus = nimetus;
//        this.valk = valk;
//        this.rasv = rasv;
//        this.sysivesik = sysivesik;
//    }
}