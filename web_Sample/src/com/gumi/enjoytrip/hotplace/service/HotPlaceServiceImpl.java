package com.gumi.enjoytrip.hotplace.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gumi.enjoytrip.hotplace.dao.HotPlaceDao;
import com.gumi.enjoytrip.hotplace.dao.HotPlaceDaoImpl;
import com.gumi.enjoytrip.hotplace.dto.HotPlaceDTO;
import com.gumi.enjoytrip.util.PageNavigation;
import com.gumi.enjoytrip.util.SizeConstant;

public class HotPlaceServiceImpl implements HotPlaceService {
	private static HotPlaceServiceImpl instance;

	public static HotPlaceServiceImpl getInstance() {
		
		if (instance == null) {
			instance = new HotPlaceServiceImpl();
		}
		return instance;
	}

	@Override
	public int writeHotPlace(HotPlaceDTO hotplaceDTO) throws Exception {
		return HotPlaceDaoImpl.getInstance().writeHotPlace(hotplaceDTO);
	}

	@Override
	public List<HotPlaceDTO> listHotPlace(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<>();
		String key = map.get("key");
//		if("userid".equals(key))
//			key = "user_id";
		param.put("key", key.isEmpty() ? "" : key);
		param.put("word", map.get("word").isEmpty() ? "" : map.get("word"));
		int pgno = Integer.parseInt(map.get("pgno"));
		int start = pgno * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
		param.put("start", start);
		param.put("listsize", SizeConstant.LIST_SIZE);
		
		return HotPlaceDaoImpl.getInstance().listHotPlace(param);
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = SizeConstant.NAVIGATION_SIZE;
		int sizePerPage = SizeConstant.LIST_SIZE;
		int currentPage = Integer.parseInt(map.get("pgno"));

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
//		if ("userid".equals(key))
//			key = "user_id";
		param.put("key", key.isEmpty() ? "" : key);
		param.put("word", map.get("word").isEmpty() ? "" : map.get("word"));
		int totalCount = HotPlaceDaoImpl.getInstance().getTotalHotPlaceCount(param);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();

		return pageNavigation;
	}

	@Override
	public HotPlaceDTO getHotPlace(int id) throws Exception {
		return HotPlaceDaoImpl.getInstance().getHotPlace(id);
	}

	@Override
	public int modifyHotPlace(HotPlaceDTO hotplaceDTO) throws Exception {
		return HotPlaceDaoImpl.getInstance().modifyHotPlace(hotplaceDTO);		
	}

	@Override
	public int deleteHotPlace(int id) throws Exception {
		return HotPlaceDaoImpl.getInstance().deleteHotPlace(id);
	}

}
