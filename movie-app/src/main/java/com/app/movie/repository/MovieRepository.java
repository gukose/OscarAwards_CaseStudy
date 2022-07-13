package com.app.movie.repository;

import com.app.movie.model.movie.OscarWonList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MovieRepository extends JpaRepository<OscarWonList, Long> {
        Optional<OscarWonList> findByNominee(String nominee);
}
