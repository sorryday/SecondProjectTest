package com.gumi.enjoytrip.hotplace.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.gumi.enjoytrip.hotplace.dto.HotPlaceDTO;
import com.gumi.enjoytrip.util.DBUtil;

public class HotPlaceDaoImpl implements HotPlaceDao{
	
	private static HotPlaceDao hotPlaceDao;
	private DBUtil dbUtil;

	private HotPlaceDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}

	public static HotPlaceDao getHotPlaceDao() {
		if (hotPlaceDao == null)
			hotPlaceDao = new HotPlaceDaoImpl();
		return hotPlaceDao;
	}
	
	@Override
	public void writeHotPlace(HotPlaceDTO hotplaceDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<HotPlaceDTO> listHotPlace(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getTotalHotPlaceCount(Map<String, Object> param) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
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
