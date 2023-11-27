package com.raja.aliments.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.raja.aliments.dto.AlimentDTO;
import com.raja.aliments.entities.Aliment;
import com.raja.aliments.service.AlimentService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AlimentRESTController {
	@Autowired
	AlimentService alimentService;

	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<Aliment> getAllAliments() {
		return alimentService.getAllAliments();
	}

	@RequestMapping(value="/getbyid/{id}", method = RequestMethod.GET)
	public Aliment getAlimentById(@PathVariable("id") Long id) {
		return alimentService.getAliment(id);
	}

	@RequestMapping(path="/addalim",method = RequestMethod.POST)
	public Aliment createAliment(@RequestBody Aliment alimentDTO) {
		return alimentService.saveAliment(alimentDTO);
	}

	@RequestMapping(path="/updatealim",method = RequestMethod.PUT)
	public Aliment updateAliment(@RequestBody Aliment alimentDTO) {
		return alimentService.updateAliment(alimentDTO);
	}

	@RequestMapping(value="/delalim/{id}", method = RequestMethod.DELETE)
	public void deleteAliment(@PathVariable("id") Long id) {
		alimentService.deleteAlimentById(id);
	}

	@RequestMapping(value = "/alimentsFam/{idFam}", method = RequestMethod.GET)
	public List<Aliment> getAlimentsByFamId(@PathVariable("idFam") Long idFam) {
		return alimentService.findByFamilleIdFam(idFam);
	}
	
	@RequestMapping(value="/alimentsByName/{nom}",method = RequestMethod.GET)
	public List<Aliment> findByNomProduitContains(@PathVariable("nom") String nom) {
	return alimentService.findByNomAlimentContains(nom);
	}


}
