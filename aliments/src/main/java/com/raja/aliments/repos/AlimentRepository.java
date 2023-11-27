package com.raja.aliments.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.raja.aliments.entities.Famille;
import com.raja.aliments.entities.Aliment;
@RepositoryRestResource(path = "rest")

public interface AlimentRepository extends JpaRepository<Aliment, Long> {
	List<Aliment> findByNomAliment(String nom);

	List<Aliment> findByNomAlimentContains(String nom);

	@Query("select a from Aliment a where a.nomAliment like %:nom and a.calorieAliment > :calorie")
	List<Aliment> findByNomCalorie(@Param("nom") String nom, @Param("calorie") Double calorie);

	@Query("select a from Aliment a where a.famille = ?1")
	List<Aliment> findByFamille(Famille famille);

	List<Aliment> findByFamilleIdFam(Long id);

	List<Aliment> findByOrderByNomAlimentAsc();

	@Query("select a from Aliment a order by a.nomAliment ASC, a.calorieAliment DESC")
	List<Aliment> trierAlimentNomsCalorie();
}
