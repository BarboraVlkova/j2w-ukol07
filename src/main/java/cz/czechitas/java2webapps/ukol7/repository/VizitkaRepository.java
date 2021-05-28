package cz.czechitas.java2webapps.ukol7.repository;

import cz.czechitas.java2webapps.ukol7.entity.Vizitka;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


// bod cislo 7

@Repository
public interface VizitkaRepository extends CrudRepository<Vizitka, Integer> {

}
