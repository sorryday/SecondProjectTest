package com.gumi.enjoytrip.hotplaceDao;

import java.util.List;

import com.gumi.enjoytrip.hotplaceDto.HotPlaceDTO;

public interface HotPlaceDao {
	public int insertHotPlace(HotPlaceDTO dto);
	public List<HotPlaceDTO> listHotPlace();
	public int updateHotPlace(HotPlaceDTO dto);
	public int deleteHotPlace(int id);
}
