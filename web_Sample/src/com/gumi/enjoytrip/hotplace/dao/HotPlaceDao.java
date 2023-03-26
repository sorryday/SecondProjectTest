package com.gumi.enjoytrip.hotplace.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.gumi.enjoytrip.hotplace.dto.HotPlaceDTO;

public interface HotPlaceDao {
	void writeHotPlace(HotPlaceDTO hotplaceDTO) throws Exception;

	List<HotPlaceDTO> listHotPlace(Map<String, Object> param) throws Exception;

	int getTotalHotPlaceCount(Map<String, Object> param) throws SQLException;

	HotPlaceDTO getHotPlace(int id) throws Exception;

	void modifyHotPlace(HotPlaceDTO hotplaceDTO) throws Exception;

	void deleteHotPlace(int id) throws Exception;
}
