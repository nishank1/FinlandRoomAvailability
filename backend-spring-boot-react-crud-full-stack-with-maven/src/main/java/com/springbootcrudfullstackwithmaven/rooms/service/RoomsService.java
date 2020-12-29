package com.springbootcrudfullstackwithmaven.rooms.service;

import com.springbootcrudfullstackwithmaven.rooms.model.Room;
import com.springbootcrudfullstackwithmaven.rooms.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoomsService {
	
	@Autowired
	private RoomRepository roomRepository;

	@Transactional
	public List<Room> getAllRooms() {
		List<Room> rooms = roomRepository.findAll();
		if(CollectionUtils.isEmpty(rooms)) {
			throw new IllegalArgumentException("rooms not found");
		}
		return rooms;
	}

	@Transactional
	public Room getRoomById(int roomId) {
		return tryFetchById(roomId)
				.orElseThrow(() -> new IllegalArgumentException("Room Not found"));
	}

	@Transactional
	public Room updateRoomDetails(int roomId, Room room) {
		Room room1 = tryFetchById(roomId).orElseThrow(() -> new IllegalArgumentException("Room Not found"));
		room1.setDescription(room.getDescription());
		room1.setRent(room.getRent());

	 // System.out.println("Room details::: "+roomId+"  "+room.getRent()+" id: "+room.getRoomId()+" description: "+room.getDescription());

	  return roomRepository.save(room1);
	}

	@Transactional
	public Room[] addRooms(Room[] rooms) {
		Room[] roomsAdded = new Room[rooms.length];
		int roomCount = 0;
		for(Room room: rooms){
			roomsAdded[roomCount] = roomRepository.save(room);
			roomCount ++;
		}
		return roomsAdded;
	}

	@Transactional
	public Room addRoom(Room room) {
		System.out.println("Room to be added::: "+room.getRoomId()+" room descriptions: "+ room.getDescription()+" room rent: "+ room.getRent());
		return roomRepository.save(room);
	}
	@Transactional
	public String deleteById(int roomId) {
			roomRepository.deleteRoom(roomId);
			return roomId+"has been deleted";
	}

	public Optional<Room> tryFetchById(int roomId) {
		return Optional.ofNullable(roomRepository.getOne(roomId));
	}

}