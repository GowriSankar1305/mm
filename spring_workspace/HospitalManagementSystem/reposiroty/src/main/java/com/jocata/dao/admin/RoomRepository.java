package com.jocata.dao.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jocata.model.admin.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
	
	Room findById(long id);
}
