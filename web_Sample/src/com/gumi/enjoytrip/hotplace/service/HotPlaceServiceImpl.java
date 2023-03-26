package com.gumi.enjoytrip.hotplace.service;

import java.util.List;
import java.util.Map;

import com.gumi.enjoytrip.hotplace.dao.HotPlaceDao;
import com.gumi.enjoytrip.hotplace.dao.HotPlaceDaoImpl;
import com.gumi.enjoytrip.hotplace.dto.HotPlaceDTO;
import com.gumi.enjoytrip.util.PageNavigation;

public class HotPlaceServiceImpl implements HotPlaceService {
	private static HotPlaceService hotplaceService = new HotPlaceServiceImpl();
	private HotPlaceDao hotplaceDao;

	private HotPlaceServiceImpl() {
		hotplaceDao = HotPlaceDaoImpl.getHotPlaceDao();
	}

	public static HotPlaceService getHotPlaceService() {
		return hotplaceService;
	}

	@Override
	public void writeHotPlace(HotPlaceDTO hotplaceDTO) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<HotPlaceDTO> listHotPlace(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotPlaceDTO getHotPlace(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyHotPlace(HotPlaceDTO hotplaceDTO) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteHotPlace(int id) throws Exception {
		// TODO Auto-generated method stub

	}

}
