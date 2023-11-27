package com.raja.aliments.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.raja.aliments.entities.Famille;

@RepositoryRestResource(path = "fam")
@CrossOrigin(origins="http://localhost:4200/")
public interface FamilleRepository extends JpaRepository<Famille, Long> {

}
