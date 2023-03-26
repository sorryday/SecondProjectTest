package com.gumi.enjoytrip.hotplace.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.gumi.enjoytrip.hotplace.dto.HotPlaceDTO;
import com.gumi.enjoytrip.util.DBUtil;

public class HotPlaceDaoImpl implements HotPlaceDao{
	
	private static HotPlaceDaoImpl instance;
	private DBUtil dbUtil;

	private HotPlaceDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}

	public static HotPlaceDaoImpl getInstance() {
		if (instance == null)
			instance = new HotPlaceDaoImpl();
		return instance;
	}
	
	@Override
	public int writeHotPlace(HotPlaceDTO hotplaceDTO) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n = 0;
		
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			
			sql.append("insert into hotplace(title, content, placetype, date, user_id, latitude, longitude) values(?, ?, ?, ?, ?, ?, ?)");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, hotplaceDTO.getTitle());
			pstmt.setString(2, hotplaceDTO.getContent());
			pstmt.setInt(3, hotplaceDTO.getPlacetype());
			pstmt.setDate(4, hotplaceDTO.getDate());
			pstmt.setString(5, hotplaceDTO.getUser_id());
			pstmt.setString(6, hotplaceDTO.getLatitude());
			pstmt.setString(7, hotplaceDTO.getLongitude());
			
			n = pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		
		return n;
	}
	
	@Override
	public List<HotPlaceDTO> listHotPlace(Map<String, Object> param) throws Exception {
		List<HotPlaceDTO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtil.getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select * from hotplace ");
			
			String key = (String) param.get("key");
			String word = (String) param.get("word");
			
			if (!key.isEmpty() && !word.isEmpty()) {
				if ("title".equals(key)) {
					sql.append("where title like concat('%', ?, '%') \n");
				} else {
					sql.append("where ").append(key).append(" = ? \n");
				}
			}
			
			sql.append("order by id desc \n");
			sql.append("limit ?, ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			int idx = 0;
			if (!key.isEmpty() && !word.isEmpty()) {
				pstmt.setString(++idx, word);
			}
				
			pstmt.setInt(++idx, (Integer) param.get("start"));
			pstmt.setInt(++idx, (Integer) param.get("listsize"));
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				HotPlaceDTO hotplaceDTO = new HotPlaceDTO();
				hotplaceDTO.setId(rs.getInt("id"));
				hotplaceDTO.setTitle(rs.getString("title"));
				hotplaceDTO.setContent(rs.getString("content"));
				hotplaceDTO.setPlacetype(Integer.parseInt(rs.getString("placetype")));
				hotplaceDTO.setDate(rs.getDate("date"));
				hotplaceDTO.setUser_id(rs.getString("user_id"));
				hotplaceDTO.setLatitude(rs.getString("latitude"));
				hotplaceDTO.setLongitude(rs.getString("longitude"));

				list.add(hotplaceDTO);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public int getTotalHotPlaceCount(Map<String, Object> param) throws SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select count(id) \n");
			sql.append("from hotplace \n");
			String key = (String) param.get("key");
			String word = (String) param.get("word");
			if (!key.isEmpty() && !word.isEmpty()) {
				if ("title".equals(key)) {
					sql.append("where title like concat('%', ?, '%') \n");
				} else {
					sql.append("where ").append(key).append(" = ? \n");
				}
			}
			pstmt = conn.prepareStatement(sql.toString());
			if (!key.isEmpty() && !word.isEmpty())
				pstmt.setString(1, word);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt(1);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return cnt;
	}

	@Override
	public HotPlaceDTO getHotPlace(int id) throws Exception {
		HotPlaceDTO hotplaceDTO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id, title, content, placetype, date, user_id, latitude, longitude \n");
			sql.append("from hotplace \n");
			sql.append("where id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				hotplaceDTO = new HotPlaceDTO();
				hotplaceDTO.setId(rs.getInt("id"));
				hotplaceDTO.setTitle(rs.getString("title"));
				hotplaceDTO.setContent(rs.getString("content"));
				hotplaceDTO.setPlacetype(Integer.parseInt(rs.getString("placetype")));
				hotplaceDTO.setDate(rs.getDate("date"));
				hotplaceDTO.setUser_id(rs.getString("user_id"));
				hotplaceDTO.setLatitude(rs.getString("latitude"));
				hotplaceDTO.setLongitude(rs.getString("longitude"));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return hotplaceDTO;
	}

	@Override
	public int modifyHotPlace(HotPlaceDTO hotplaceDTO) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n = 0;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update hotplace \n");
			sql.append("set title = ?, content = ?, placetype = ?, date = ?, latitude = ?, longitude = ?");
			sql.append("where id = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, hotplaceDTO.getTitle());
			pstmt.setString(2, hotplaceDTO.getContent());
			pstmt.setInt(3, hotplaceDTO.getPlacetype());
			pstmt.setDate(4, hotplaceDTO.getDate());
			pstmt.setString(5, hotplaceDTO.getLatitude());
			pstmt.setString(6, hotplaceDTO.getLongitude());
			
			pstmt.setInt(7, hotplaceDTO.getId());
			
			n = pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
		return n;
	}

	@Override
	public int deleteHotPlace(int id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n = 0;
		
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete from hotplace \n");
			sql.append("where id = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, id);
			
			n = pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
		return n;
	}
}
