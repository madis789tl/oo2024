package ee.tlu.kodutoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")

public class AutoparkimineController {


    @Autowired
    AutoparkimineRepository autoparkimineRepository;


    @GetMapping("parkimisekohad")
    public List<Autoparkimine> getParkimiskohad() {
        return autoparkimineRepository.findAll();
    }

    // --> PathVariable: http://localhost:8080/toidukomponendid/4
    // RequestParam: http://localhost:8080/toidukomponendid?id=4
    @DeleteMapping("parkimisekohad/{id}")
    public List<Autoparkimine> deleteParkimisekoht(@PathVariable String id) {
        autoparkimineRepository.deleteById(id);
        return autoparkimineRepository.findAll();
    }

    @PostMapping("parkimisekohad")
    public List<Autoparkimine> lisaParkimisekoht(@RequestBody Autoparkimine autoparkimine) {
        autoparkimineRepository.save(autoparkimine);
        return autoparkimineRepository.findAll();
    }


}
