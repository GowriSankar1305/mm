package com.jocata.service.impl.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocata.dao.admin.RoomRepository;
import com.jocata.model.admin.Room;
import com.jocata.service.admin.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRepository roomRepo;
	
	@Override
	public Room getRoomById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room saveRoom(Room room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> getRoomsBsdOnHospital(long hospitalId) {
		// TODO Auto-generated method stub
		return null;
	}

}
