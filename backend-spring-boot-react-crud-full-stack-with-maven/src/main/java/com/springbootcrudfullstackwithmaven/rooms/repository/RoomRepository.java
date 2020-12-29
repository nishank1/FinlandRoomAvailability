package com.springbootcrudfullstackwithmaven.rooms.repository;

import com.springbootcrudfullstackwithmaven.rooms.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Modifying
    @Query("update Room r set r.description = :description, r.rent = :rent where r.roomId = :roomId")
    int updateRoom(@Param("roomId") int roomId, @Param("description") String description, @Param("rent") double rent);

    @Modifying
    @Query("delete from Room r where r.roomId = :roomId")
    int deleteRoom(@Param("roomId") int roomId);
}