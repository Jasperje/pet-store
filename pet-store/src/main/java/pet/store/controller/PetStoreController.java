package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.service.PetStoreService;


@RestController       //tells Spring that this class is a REST controller
// and it also tells Spring to map HTTP requests to class methods 
@RequestMapping("/pet_store")     //tells Spring that the URI for every HTTP request,
//that is mapped to a method in this controller class must start with ("/pet_store")
@Slf4j         //creates an SLF4J logger  (that is why we use log.info) 
public class PetStoreController {
@Autowired
     private PetStoreService petStoreService;


@PostMapping
@ResponseStatus(code = HttpStatus.CREATED) 
public PetStoreData insertPetStore(
		@RequestBody PetStoreData petStoreData) {
	log.info("Creating pet store {}", petStoreData);
	return petStoreService.savePetStore(petStoreData);
	
}

@PutMapping(("/{petStoreId}"))
@ResponseStatus(code = HttpStatus.CREATED) 
public PetStoreData updatePetStore(@PathVariable Long petStoreId,
		@RequestBody PetStoreData petStoreData) {
	petStoreData.setPetStoreId(petStoreId);
	log.info("Updating pet store with ID={}", petStoreData);
	return petStoreService.savePetStore(petStoreData);
	
}

}
