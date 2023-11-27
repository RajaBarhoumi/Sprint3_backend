package com.raja.aliments.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Aliment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long idAliment;
	private String nomAliment;
	private Double calorieAliment;
	private Double lipideAliment;
	private Double glucideAliment;
	private Double fibreAliment;
	@ManyToOne
	private Famille famille;
	
	/*@OneToOne
    private Image image;*/
    
	
	 @OneToMany (mappedBy = "aliment")
	 private List<Image> images;
	 
	 private String imagePath;

	
	

	public Aliment(String nomAliment, Double calorieAliment, Double lipideAliment, Double glucideAliment,
			Double fibreAliment, Double proteineAliment, Date dateCreation, Famille famille, Image img) {
		super();
		this.nomAliment = nomAliment;
		this.calorieAliment = calorieAliment;
		this.lipideAliment = lipideAliment;
		this.glucideAliment = glucideAliment;
		this.fibreAliment = fibreAliment;
		this.proteineAliment = proteineAliment;
		this.dateCreation = dateCreation;
		//this.famille = famille;
	}

	public Double getFibreAliment() {
		return fibreAliment;
	}

	public void setFibreAliment(Double fibreAliment) {
		this.fibreAliment = fibreAliment;
	}

	private Double proteineAliment;
	private Date dateCreation;

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	
	
	public Long getIdAliment() {
		return idAliment;
	}

	public void setIdAliment(Long idAliment) {
		this.idAliment = idAliment;
	}

	public String getNomAliment() {
		return nomAliment;
	}

	public void setNomAliment(String nomAliment) {
		this.nomAliment = nomAliment;
	}

	public Double getCalorieAliment() {
		return calorieAliment;
	}

	public void setCalorieAliment(Double calorieAliment) {
		this.calorieAliment = calorieAliment;
	}

	public Double getLipideAliment() {
		return lipideAliment;
	}

	public void setLipideAliment(Double lipideAliment) {
		this.lipideAliment = lipideAliment;
	}

	public Double getGlucideAliment() {
		return glucideAliment;
	}

	public void setGlucideAliment(Double glucideAliment) {
		this.glucideAliment = glucideAliment;
	}

	public Double getProteineAliment() {
		return proteineAliment;
	}

	public void setProteineAliment(Double proteineAliment) {
		this.proteineAliment = proteineAliment;
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	public Aliment() {
		super();
	}

	
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	

	


	

}
