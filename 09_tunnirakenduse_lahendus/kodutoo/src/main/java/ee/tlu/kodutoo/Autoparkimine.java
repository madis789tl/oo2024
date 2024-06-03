package ee.tlu.kodutoo;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@Table(name = "parkimisekoht") //tabeli nime panemiseks
@Entity //andmebaasipanemiseks
@NoArgsConstructor //andmebaasipanemiseks

public class Autoparkimine {
    @Id
    String parkimisekoht;
    int baasmaksmus;

}
