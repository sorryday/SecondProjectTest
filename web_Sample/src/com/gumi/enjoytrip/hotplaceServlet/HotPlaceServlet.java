package com.gumi.enjoytrip.hotplaceServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gumi.enjoytrip.hotplaceDto.HotPlaceDTO;
import com.gumi.enjoytrip.service.HotPlaceServiceImpl;

@WebServlet("/hotplace")
public class HotPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hotPlaceProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		hotPlaceProcess(request, response);
	}
	
	protected void hotPlaceProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "insertPlace" :
			doInsert(request, response);
			break;

		case "listPlace" :
			doList(request, response);
			break;
			
		case "updatePlace" :
			doUpdate(request, response);
			break;
			
		case "deletePlace" :
			doDel(request, response);
			break;
		}
	}

	private void doInsert(HttpServletRequest request, HttpServletResponse response) {
		HotPlaceDTO dto = new HotPlaceDTO();
		dto.setTitle(request.getParameter("title"));
		dto.setTitle(request.getParameter("title"));
		dto.setTitle(request.getParameter("title"));
		dto.setTitle(request.getParameter("title"));
		dto.setTitle(request.getParameter("title"));
		
		String root = request.getContextPath();
		
		int n = HotPlaceServiceImpl.getInstance().insertHotPlace(dto);
		
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) {
		
	}

	private void doDel(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
