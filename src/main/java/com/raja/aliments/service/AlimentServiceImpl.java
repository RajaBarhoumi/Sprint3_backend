package com.raja.aliments.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raja.aliments.dto.AlimentDTO;
import com.raja.aliments.entities.Famille;
import com.raja.aliments.repos.AlimentRepository;
import com.raja.aliments.repos.ImageRepository;
import com.raja.aliments.entities.Aliment;

@Service
public class AlimentServiceImpl implements AlimentService {

	@Autowired
	AlimentRepository alimentRepository;
	
	@Autowired
	ImageRepository imageRepository;

	/*
	 @Autowired
	 	ModelMapper modelMapper;

	 */

	@Override
	public Aliment saveAliment(Aliment a) {
		return alimentRepository.save(a);
		
	}

	@Override
	public Aliment updateAliment(Aliment a) {
				//Long oldAlimImageId = this.getAliment(a.getIdAliment()).getImage().getIdImage();
				//Long newAlimImageId = a.getImage().getIdImage();
				Aliment alimUpdated = alimentRepository.save(a);
				//if (oldAlimImageId != newAlimImageId) //si l'image a été modifiée
				//imageRepository.deleteById(oldAlimImageId);
				return alimUpdated;
		}

	@Override
	public Aliment getAliment(Long id) {
		return alimentRepository.findById(id).get();
	}

	@Override
	public List<Aliment> getAllAliments() {
		List<Aliment> aliments = alimentRepository.findAll();
		List<Aliment> listaliments = new ArrayList<>(aliments.size());
		for (Aliment p : aliments)
			listaliments.add(p);
		return listaliments;
		// return
		// produitRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	@Override
	public void deleteAliment(Aliment p) {
		alimentRepository.delete(p);
	}

	@Override
	public void deleteAlimentById(Long id) {
		Aliment a = getAliment(id);
		 //suuprimer l'image avant de supprimer le produit
		try {
		Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+a.getImagePath()));
		} catch (IOException e) {
		e.printStackTrace();
		} 
		alimentRepository.deleteById(id);

	}

	@Override
	public List<Aliment> findByNomAliment(String nom) {
		return alimentRepository.findByNomAliment(nom);
	}

	@Override
	public List<Aliment> findByNomAlimentContains(String nom) {
		return alimentRepository.findByNomAlimentContains(nom);
	}

	@Override
	public List<Aliment> findByNomPrix(String nom, Double calorie) {
		return alimentRepository.findByNomCalorie(nom, calorie);
	}

	@Override
	public List<Aliment> findByFamilleIdFam(Long id) {
		return alimentRepository.findByFamilleIdFam(id);
	}

	@Override
	public List<Aliment> findByOrderByNomAlimentAsc() {
		return alimentRepository.findByOrderByNomAlimentAsc();
	}

	@Override
	public List<Aliment> trierAlimentNomsCalorie() {
		return alimentRepository.trierAlimentNomsCalorie();
	}

	@Override
	public List<Aliment> findByFamille(Famille categorie) {
		return alimentRepository.findByFamille(categorie);
	}

	/*
	@Override
	public AlimentDTO convertEntityToDto(Aliment aliment) {
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		AlimentDTO alimentDTO = modelMapper.map(aliment, AlimentDTO.class);

		return alimentDTO;
	}

	@Override
	public Aliment convertDtoToEntity(AlimentDTO alimentDto) {
	

		Aliment aliment = new Aliment();
		aliment = modelMapper.map(alimentDto, Aliment.class);
		return aliment;
	}
*/
}
