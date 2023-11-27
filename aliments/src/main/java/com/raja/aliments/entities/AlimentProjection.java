package com.raja.aliments.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomAliment", types = { Aliment.class })
public interface AlimentProjection {
	public String getNomAliment();
}
