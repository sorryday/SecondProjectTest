package com.gumi.enjoytrip.hotplace.service;

import java.util.List;
import java.util.Map;

import com.gumi.enjoytrip.hotplace.dto.HotPlaceDTO;
import com.gumi.enjoytrip.util.PageNavigation;

public interface HotPlaceService {
	public int writeHotPlace(HotPlaceDTO hotplaceDTO) throws Exception;

	public List<HotPlaceDTO> listHotPlace(Map<String, String> map) throws Exception;

	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception;

	public HotPlaceDTO getHotPlace(int id) throws Exception;

	public int modifyHotPlace(HotPlaceDTO hotplaceDTO) throws Exception;

	public int deleteHotPlace(int id) throws Exception;
}
