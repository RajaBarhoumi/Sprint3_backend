package com.raja.aliments.dto;

import java.util.Date;

import com.raja.aliments.entities.Famille;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//faciliter la constuction de l'objet
public class AlimentDTO {
	private Long idAliment;
	private String nomAliment;
	private Double calorieAliment;
	private Double lipideAliment;
	private Double glucideAliment;
	private Double proteineAliment;
	private Double fibreAliment;
	private Date dateCreation;

	
	private Famille famille;

}
