package com.jocata.service.impl.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocata.dao.admin.RoomTypeRepository;
import com.jocata.model.admin.RoomType;
import com.jocata.service.admin.RoomTypeService;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
	
	@Autowired
	private RoomTypeRepository roomtyperepo;
	
	@Override
	public RoomType getRoomTypeById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomType saveRoomType(RoomType roomType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomType> getAllRoomTypes() {
		// TODO Auto-generated method stub
		return null;
	}

}
