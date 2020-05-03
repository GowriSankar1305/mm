package com.jocata.dao.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jocata.model.admin.RoomType;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
	
	RoomType findByRoomTypeId(long id);
}
