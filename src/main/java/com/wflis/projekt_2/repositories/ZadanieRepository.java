package com.wflis.projekt_2.repositories;

import com.wflis.projekt_2.entities.Zadanie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ZadanieRepository extends CrudRepository<Zadanie, Long> {
    // save Zadanie to database
    Zadanie save(Zadanie zadanie);

    // find one Zadanie by id
    Optional<Zadanie> findById(Long id);

    // find all Zadanie
    Iterable<Zadanie> findAll();

    // count records in table Zadanie
    long count();

    // delete record by id in table Zadanie (delete by id)
    void deleteById(Long id);

    // delete all records in table Zadanie (delete all)
    void deleteAll();

    // delete Zadanie object from table Zadanie (delete by object)
    void delete(Zadanie zadanie);

    // find by wykonane field value
    Iterable<Zadanie> findByWykonane(boolean wykonane);

    // find by less than koszt field value
    Iterable<Zadanie> findByKosztLessThan(double koszt);

    // find by greater than koszt field value
    Iterable<Zadanie> findByKosztGreaterThan(double koszt);

    // find by between koszt field value
    Iterable<Zadanie> findByKosztBetween(double koszt1, double koszt2);
}
