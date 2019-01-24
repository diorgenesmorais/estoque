package com.dms.caixa.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dms.caixa.model.Bandeira;
import com.dms.caixa.repository.BandeirasRepository;

@RestController
@RequestMapping(path = "/bandeiras", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class BandeiraResource {

	@Autowired
	private BandeirasRepository bandeirasRepository;

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		Optional<Bandeira> bandeira = bandeirasRepository.findById(id);
		return ResponseEntity.of(bandeira);
	}
}
