package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Transactional
public interface IMovieRepository extends JpaRepository<Movie,Long> {


    List<Movie> findAllByPremiredBefore(LocalDate date);
}
