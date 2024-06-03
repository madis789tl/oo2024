package ee.tlu.kodutoo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class Arvutamine {

    AutoRepository autoRepository;

    public Arvutamine(AutoRepository autoRepository){
        this.autoRepository = autoRepository;
    }


    @GetMapping("autod")
    public List<Auto> saaAutod(){
        return autoRepository.findAll();
    }

    @PostMapping("autod")
    public List<Auto> lisaAuto(@RequestBody Auto auto){
        autoRepository.save(auto);
        return autoRepository.findAll();
    }


    @DeleteMapping("autod/{id}")
    public List<Auto> kustutaAuto(@PathVariable Long id){
        autoRepository.deleteById(id);
        return autoRepository.findAll();
    }


}
