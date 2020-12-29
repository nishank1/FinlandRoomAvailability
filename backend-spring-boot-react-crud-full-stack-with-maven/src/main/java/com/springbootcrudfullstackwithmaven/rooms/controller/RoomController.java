package com.springbootcrudfullstackwithmaven.rooms.controller;

import com.springbootcrudfullstackwithmaven.rooms.model.Room;
import com.springbootcrudfullstackwithmaven.rooms.service.RoomsHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class RoomController {
	
	private RoomsHardcodedService roomsHardcodedService;
	
	@Autowired
	public void setRoomService(RoomsHardcodedService roomsHardcodedService) {
		this.roomsHardcodedService = roomsHardcodedService;
	}

	@GetMapping("/instructors/{username}/rooms")
	public ResponseEntity<List<Room>> getAllRooms(@PathVariable String username){
			return ResponseEntity.ok(roomsHardcodedService.getAllRooms());
	}

	@GetMapping("/instructors/{username}/rooms/{roomId}")
	public ResponseEntity<Room> getRoom(@PathVariable String username, @PathVariable int roomId) {
           return ResponseEntity.ok(roomsHardcodedService.getRoomById(roomId));
	}


	@PostMapping(value = "/instructors/{username}/rooms/")
	public ResponseEntity<Room> addRooms(@PathVariable String username, @RequestBody Room[] rooms) {
			return new ResponseEntity(roomsHardcodedService.addRooms(rooms), HttpStatus.OK);
	}

	@PostMapping(value = "/instructors/{username}/room/")
	public ResponseEntity<Room> addRoom(@PathVariable String username, @RequestBody Room room) {
		System.out.println("new room: "+room.getRoomId()+"name: "+room.getDescription()+"rent: "+room.getRent());
		return new ResponseEntity(roomsHardcodedService.addRoom(room), HttpStatus.OK);
	}

	@PutMapping(value = "/instructors/{username}/rooms/{roomId}")
	public ResponseEntity<Room> updateRoom(@PathVariable String username, @PathVariable int roomId, @RequestBody Room room) {
		System.out.println("@@@update room: "+roomId+" Details of the room"+room.getRoomId()+"name: "+room.getDescription()+"rent: "+room.getRent());
		return  new ResponseEntity<>(roomsHardcodedService.updateRoomDetails(roomId, room), HttpStatus.OK);
	}

	@DeleteMapping(value = "/instructors/{username}/rooms/{roomId}")
	public ResponseEntity<String> deleteRoom(@PathVariable String username, @PathVariable int roomId) {
		System.out.println("@@@@Deleted the room "+roomId);
		return new ResponseEntity(roomsHardcodedService.deleteById(roomId), HttpStatus.OK);
	}
}