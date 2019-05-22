package lab5.ejemploSpring.Repository;

import lab5.ejemploSpring.Domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

}
