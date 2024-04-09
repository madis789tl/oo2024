package ee.tlu.salat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class ToidukomponentController {

    @Autowired
    ToidukomponentRepository toidukomponentRepository;

    // Bean ---> automaatselt loodav klass kui rakendus käivitub (new Class();)
    // @Autowired ---> samaväärne kui allolev constructor, tõmbab Repository siia sisse

    //public ToidukomponentController(ToidukomponentRepository toidukomponentRepository) {
    //    this.toidukomponentRepository = toidukomponentRepository;
    //}

    // Saaks andmebaasist päringuid teha.
    // INSERT INTO Toidukomponent VALUES("") --->  repository.save("");
    // DELETE FROM Toidukomponent WHERE id = 5  ---> repository.deleteById(5);
    // SELECT * FROM Toidukomponent  ---> repository.findAll();

    // http://localhost:8080/toidukomponendid
    @GetMapping("toidukomponendid")
    public List<Toidukomponent> getToidukomponents() {
        return toidukomponentRepository.findAll();
    }

}
