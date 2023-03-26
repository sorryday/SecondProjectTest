package com.gumi.enjoytrip.hotplace.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.gumi.enjoytrip.hotplace.dto.HotPlaceDTO;

public interface HotPlaceDao {
	public int writeHotPlace(HotPlaceDTO hotplaceDTO) throws Exception;

	public List<HotPlaceDTO> listHotPlace(Map<String, Object> param) throws Exception;

	public int getTotalHotPlaceCount(Map<String, Object> param) throws SQLException;

	public HotPlaceDTO getHotPlace(int id) throws Exception;

	public int modifyHotPlace(HotPlaceDTO hotplaceDTO) throws Exception;

	public int deleteHotPlace(int id) throws Exception;
}
