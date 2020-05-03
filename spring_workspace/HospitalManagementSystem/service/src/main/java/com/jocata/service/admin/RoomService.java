package com.jocata.service.admin;

import java.util.List;

import com.jocata.model.admin.Room;

public interface RoomService {
	
	Room getRoomById(long id);
	Room saveRoom(Room room);
	List<Room> getRoomsBsdOnHospital(long hospitalId);
	
}
