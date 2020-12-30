package com.springbootcrudfullstackwithmaven.rooms.controller;

import com.springbootcrudfullstackwithmaven.rooms.model.Owner;
import com.springbootcrudfullstackwithmaven.rooms.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = { "http://localhost:8000", "http://localhost:4200" })
@RestController
@RequestMapping("/instructors")
public class OwnController {
	
	private OwnerService ownerService;
	
	@Autowired
	public void setOwnerService(OwnerService ownerService) {
		this.ownerService = ownerService;
	}
	
	@RequestMapping(value= "/owners", method = RequestMethod.GET)
	public ResponseEntity<List<Owner>> getAllOwners(){
			return ResponseEntity.ok(ownerService.getAllOwners());
	}

	@RequestMapping(value = "/owners/{ownerId}", method = RequestMethod.GET)
	public ResponseEntity<Owner> getOwner(@PathVariable int ownerId) {
           return ResponseEntity.ok(ownerService.getOwnerById(ownerId));
	}

	@RequestMapping(value = "/owners/", method = RequestMethod.POST)
	public ResponseEntity<Owner> addOwners(@RequestBody Owner[] owners) {
			return new ResponseEntity(ownerService.addOwners(owners), HttpStatus.OK);
	}

	@RequestMapping(value = "/owners/", method = RequestMethod.PUT)
	public ResponseEntity<Integer> updateOwner(@RequestBody Owner owner) {
		return  new ResponseEntity<>(new Integer(ownerService.updateOwnerDetails(owner)), HttpStatus.OK);
	}

	@RequestMapping(value = "/owners/{ownerId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteOwner(@PathVariable int ownerId) {
		return new ResponseEntity(ownerService.deleteById(ownerId), HttpStatus.OK);
	}
}