package ee.tlu.autodehoius;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")

public class AutoEntityController {

    // ["Kartul", "Vorst"];
    // [{nimi: "Kartul, valk: 0}, {nimi: "Vorst"}]

    AutoRepository autoRepository;

    public AutoEntityController(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

//    @Autowired
//    MangijaRepository mangijaRepository;

    //List<MangijaEntity> mangijad = new ArrayList<>();

    // localhost:8080/api/mangijad
    @GetMapping("autod")
    public List<AutoEntity> saaAutod() {
        return autoRepository.findAll();
    }

    //localhost:8080/api/mangijad/Toomas/15/5/1
    // ON järjekord tähtis
    // Ma võin kogemata sassi ajada, muutes järjekorda ja paneb valesti
    // Ma ei saa ühtegi vahele jätta

    //localhost:8080/api/mangijad/Toomas/15/5/1
    @PostMapping("autod/{mark}/{pikkus}/{mass}/{aasta}")
    public List<AutoEntity> lisaAuto(
            @PathVariable String mark,
            @PathVariable int pikkus,
            @PathVariable int mass,
            @PathVariable int aasta
    ) {
        if (aasta + aasta + aasta > 100) {
            return autoRepository.findAll();
        }
        AutoEntity auto = new AutoEntity(mark, pikkus, mass, aasta);
        autoRepository.save(auto);
        return autoRepository.findAll();
    }

    @PostMapping("autod")
    public List<AutoEntity> lisaAuto(@RequestBody AutoEntity autoEntity) {
        if (autoEntity.pikkus + autoEntity.pikkus + autoEntity.pikkus > 1000) {
            return autoRepository.findAll();
        }
        //mangijaEntity mangija = new MangijaEntity(nimi, kuld, xp, level);
        autoRepository.save(autoEntity);
        return autoRepository.findAll();
    }

    @DeleteMapping("autod/{mark}")
    public List<AutoEntity> kustutaAuto(@PathVariable String mark) {
        autoRepository.deleteById(mark);
        return autoRepository.findAll();
    }

    // localhost:8080/api/toiduained/Vorst/15/5/1 <-- PathVariable näide
    // localhost:8080/api/toiduained?index=0&nimi=Vorst&valk=15&rasv=5&sysivesik=1
    @PutMapping("autod")
    public List<AutoEntity> muudaAuto(
            @RequestParam int index,
            @RequestParam String mark,
            @RequestParam int pikkus,
            @RequestParam int mass,
            @RequestParam int aasta
    ) {
        AutoEntity auto = new AutoEntity(mark, pikkus, mass, aasta);
        //toiduained.set(index, mangija);
        autoRepository.save(auto); // täpselt sama mis POST
        // Hibernate kontrollib, kas on juba sellise primaarvõtmega element andmebaasis
        return autoRepository.findAll();
    }

    @GetMapping("autod/{mark}")
    public AutoEntity saaYksAuto(@PathVariable String mark) {
        return autoRepository.findById(mark).get();
    }

    @GetMapping("autode-koguarv")
    public int autodeKoguarv() {
        return autoRepository.findAll().size();
    }



}
