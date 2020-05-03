package com.jocata.service.impl.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jocata.dao.admin.OccupiedRoomRepository;
import com.jocata.model.admin.OccupiedRoom;
import com.jocata.service.admin.OccupiedRoomService;

@Service
public class OccupiedServiceImpl implements OccupiedRoomService {
	
	@Autowired
	private OccupiedRoomRepository occupiedRoomRepo;
	
	@Override
	public OccupiedRoom findById(long id) {
		return occupiedRoomRepo.findByOccupiedId(id);
	}

	@Override
	public OccupiedRoom saveOccupiedRoom(OccupiedRoom rooms) {
		return occupiedRoomRepo.save(rooms);
	}

	@Override
	public List<OccupiedRoom> getRoomsBsdOnPatientId(long patientId) {
		return occupiedRoomRepo.findByPatientPatientId(patientId);
	}

	@Override
	public List<OccupiedRoom> getRoomsBsdOnDoctorId(long doctorId) {
		return occupiedRoomRepo.findByDoctorDoctorId(doctorId);
	}

}
