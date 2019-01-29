package com.dms.caixa.resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/test", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class ResourceTest {

	@GetMapping
	public ResponseEntity<String> index(){
		return ResponseEntity.ok("index");
	}
	
	@GetMapping("/noAcceptable")
	public void notAcceptable() throws HttpMediaTypeNotAcceptableException{
		
		throw new HttpMediaTypeNotAcceptableException("Tipo de mídia não aceita");
	}
}
