package com.jocata.dao.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jocata.model.admin.OccupiedRoom;

public interface OccupiedRoomRepository extends JpaRepository<OccupiedRoom, Long> {
	
	public OccupiedRoom findByOccupiedId(long id);
	public List<OccupiedRoom> findByPatientPatientId(long patientId);
	public List<OccupiedRoom> findByDoctorDoctorId(long doctorId);
}
