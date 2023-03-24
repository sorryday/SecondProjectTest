package com.gumi.enjoytrip.hotplaceDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import com.gumi.enjoytrip.hotplaceDto.HotPlaceDTO;
import com.gumi.enjoytrip.util.DBUtil;

public class HotPlaceDaoImpl implements HotPlaceDao{
	
	private static HotPlaceDaoImpl instance;
	private HotPlaceDaoImpl() {}
	public static HotPlaceDaoImpl getInstance() {
		if (instance == null) {
			instance = new HotPlaceDaoImpl();
		}
		return instance;
	}
	
	
	@Override
	public int insertHotPlace(HotPlaceDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n = 0;
		
		try {
			conn = DBUtil.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("insert into hotplace(id, title, content, date, file_name, user_id, created_at) ");
			sb.append("values(?, ?, ?, ?, ?)");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setDate(3, dto.getDate());
			pstmt.setString(4, dto.getFile_name());
			pstmt.setString(5, dto.getUser_id());
			
			n = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		
		return n;
	}

	@Override
	public List<HotPlaceDTO> listHotPlace() {
		return null;
	}

	@Override
	public int updateHotPlace(HotPlaceDTO dto) {
		return 0;
	}

	@Override
	public int deleteHotPlace(int id) {
		return 0;
	}

}
