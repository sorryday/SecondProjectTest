package com.gumi.enjoytrip.service;

import java.util.List;

import com.gumi.enjoytrip.hotplaceDao.HotPlaceDaoImpl;
import com.gumi.enjoytrip.hotplaceDto.HotPlaceDTO;

public class HotPlaceServiceImpl implements HotPlaceService{
	private static HotPlaceServiceImpl instance;
	private HotPlaceServiceImpl() {}
	public static HotPlaceServiceImpl getInstance() {
		if (instance == null) {
			instance = new HotPlaceServiceImpl();
		}
		return instance;
	}
	

	@Override
	public int insertHotPlace(HotPlaceDTO dto) {
		return HotPlaceDaoImpl.getInstance().insertHotPlace(dto);
	}

	@Override
	public List<HotPlaceDTO> listHotPlace() {
		return HotPlaceDaoImpl.getInstance().listHotPlace();
	}

	@Override
	public int updateHotPlace(HotPlaceDTO dto) {
		return HotPlaceDaoImpl.getInstance().updateHotPlace(dto);
	}

	@Override
	public int deleteHotPlace(int id) {
		return HotPlaceDaoImpl.getInstance().deleteHotPlace(id);
	}
}
