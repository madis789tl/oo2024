package ee.tlu.autodehoius;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class AutokomponentController {

    @Autowired
    AutokomponentRepository autokomponentRepository;


    @GetMapping("autokomponendid")
    public List<Autokomponent> getAutokomponents() { return autokomponentRepository.findAll();}

    @DeleteMapping("autokomponendid/{id}")
    public List<Autokomponent> deleteAutokomponent(@PathVariable Long id) {
        autokomponentRepository.deleteById(id);
        return autokomponentRepository.findAll();
    }
    @PostMapping("autokomponendid")
    public List<Autokomponent> addAutokomponent(@RequestBody Autokomponent autokomponent) {
        autokomponentRepository.save(autokomponent);
        return autokomponentRepository.findAll();
    }
}
