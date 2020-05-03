package com.jocata.service.admin;

import java.util.List;

import com.jocata.model.admin.OccupiedRoom;

public interface OccupiedRoomService {
	
	OccupiedRoom findById(long id);
	OccupiedRoom saveOccupiedRoom(OccupiedRoom rooms);
	List<OccupiedRoom> getRoomsBsdOnPatientId(long patientId);
	List<OccupiedRoom> getRoomsBsdOnDoctorId(long doctorId);
}
