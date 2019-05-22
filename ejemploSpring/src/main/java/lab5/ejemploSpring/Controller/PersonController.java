package lab5.ejemploSpring.Controller;

import lab5.ejemploSpring.Domain.Person;
import lab5.ejemploSpring.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/Person") // hace localhost/persona ??
@RestController
public class PersonController {
    @Autowired
    private PersonRepository pRepository;

    @PostMapping("") // metodo post
    public void add(Person p){
        pRepository.save(p);
    }

    @GetMapping("")
    public List<Person> get(){
        List<Person> persons = new ArrayList<Person>();
        pRepository.findAll();

        return persons;
    }

    @DeleteMapping("")
    public boolean delete(Integer id){

        return false; // por ahora
    }
}
