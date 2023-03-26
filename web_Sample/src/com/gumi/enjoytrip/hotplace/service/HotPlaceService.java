package com.gumi.enjoytrip.hotplace.service;

import java.util.List;
import java.util.Map;

import com.gumi.enjoytrip.hotplace.dto.HotPlaceDTO;
import com.gumi.enjoytrip.util.PageNavigation;

public interface HotPlaceService {
	void writeHotPlace(HotPlaceDTO hotplaceDTO) throws Exception;

	List<HotPlaceDTO> listHotPlace(Map<String, String> map) throws Exception;

	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;

	HotPlaceDTO getHotPlace(int id) throws Exception;

	void modifyHotPlace(HotPlaceDTO hotplaceDTO) throws Exception;

	void deleteHotPlace(int id) throws Exception;
}
