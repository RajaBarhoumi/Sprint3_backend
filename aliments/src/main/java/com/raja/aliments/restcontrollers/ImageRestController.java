package com.raja.aliments.restcontrollers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.raja.aliments.entities.Aliment;
import com.raja.aliments.entities.Image;
import com.raja.aliments.service.AlimentService;
import com.raja.aliments.service.ImageService;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	@Autowired
	ImageService imageService;

	@Autowired
	AlimentService alimentService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
	public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
		return imageService.getImageDetails(id);
	}

	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
		return imageService.getImage(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteImage(@PathVariable("id") Long id) {
		imageService.deleteImage(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Image UpdateImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@PostMapping(value = "/uplaodImageAlim/{idAlim}")
	public Image uploadMultiImages(@RequestParam("image") MultipartFile file, @PathVariable("idAlim") Long idAlim)
			throws IOException {
		return imageService.uplaodImageAlim(file, idAlim);
	}

	@RequestMapping(value = "/getImagesAlim/{idAlim}", method = RequestMethod.GET)
	public List<Image> getImagesProd(@PathVariable("idAlim") Long idAlim) throws IOException {
		return imageService.getImagesParAlim(idAlim);
	}

	@RequestMapping(value = "/uploadFS/{id}", method = RequestMethod.POST)
	public void uploadImageFS(@RequestParam("image") MultipartFile file, @PathVariable("id") Long id)
			throws IOException {
		Aliment a = alimentService.getAliment(id);
		a.setImagePath(id + ".jpg");

		Files.write(Paths.get(System.getProperty("user.home") + "/images/" + a.getImagePath()), file.getBytes());
		alimentService.saveAliment(a);

	}

	@RequestMapping(value = "/loadfromFS/{id}", method = RequestMethod.GET, produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

		Aliment a = alimentService.getAliment(id);
		return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/images/" + a.getImagePath()));
	}

}
