package com.gumi.enjoytrip.service;

import java.util.List;

import com.gumi.enjoytrip.hotplaceDto.HotPlaceDTO;

public interface HotPlaceService {
	public int insertHotPlace(HotPlaceDTO dto);
	public List<HotPlaceDTO> listHotPlace();
	public int updateHotPlace(HotPlaceDTO dto);
	public int deleteHotPlace(int id);
}
