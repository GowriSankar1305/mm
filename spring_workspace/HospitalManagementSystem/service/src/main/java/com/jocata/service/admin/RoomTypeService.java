package com.jocata.service.admin;

import java.util.List;

import com.jocata.model.admin.RoomType;

public interface RoomTypeService {
	
	RoomType getRoomTypeById();
	RoomType saveRoomType(RoomType roomType);
	List<RoomType> getAllRoomTypes();
}
