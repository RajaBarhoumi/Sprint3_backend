package com.raja.aliments;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.raja.aliments.entities.Famille;
import com.raja.aliments.repos.AlimentRepository;
import com.raja.aliments.entities.Aliment;

@SpringBootTest
class AlimentsApplicationTests {

	@Autowired
	private AlimentRepository alimentRepository;

	@Test
	public void testCreateAliment() {
		Aliment alim = new Aliment("Chocolat", 50.800, 12.5,5.2,8.9,12.3, null, null);
		alimentRepository.save(alim);
	}

	@Test
	public void testFindProduit() {
		Aliment a = alimentRepository.findById(2L).get();
		System.out.println(a);
	}

	@Test
	public void testUpdateProduit() {
		Aliment a = alimentRepository.findById(1L).get();
		a.setCalorieAliment(20.0);
		alimentRepository.save(a);
	}

	@Test
	public void testDeleteProduit() {
		alimentRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousProduits() {
		List<Aliment> aliments = alimentRepository.findAll();
		for (Aliment p : aliments) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomProduit() {
		List<Aliment> aliments = alimentRepository.findByNomAliment("Chocolat");
		for (Aliment p : aliments) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomProduitContains() {
		List<Aliment> aliments = alimentRepository.findByNomAlimentContains("PC");
		for (Aliment p : aliments) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByNomPrix() {
		List<Aliment> aliments = alimentRepository.findByNomCalorie("Chocolat", 20.0);
		for (Aliment p : aliments) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByCategorie() {
		Famille fam = new Famille();
		fam.setIdFam(1L);
		List<Aliment> aliments = alimentRepository.findByFamille(fam);
		for (Aliment p : aliments) {
			System.out.println(p);
		}
	}

	@Test
	public void findByCategorieIdCat() {
		List<Aliment> aliments = alimentRepository.findByFamilleIdFam(1L);
		for (Aliment p : aliments) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByOrderByNomProduitAsc() {
		List<Aliment> aliments = alimentRepository.findByOrderByNomAlimentAsc();
		for (Aliment p : aliments) {
			System.out.println(p);
		}
	}

	@Test
	public void testTrierProduitsNomsPrix() {
		List<Aliment> aliments = alimentRepository.trierAlimentNomsCalorie();
		for (Aliment p : aliments) {
			System.out.println(p);
		}
	}

}
