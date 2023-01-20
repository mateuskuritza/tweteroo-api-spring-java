package com.api.tweteroo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.tweteroo.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByUsername(String username);
}
