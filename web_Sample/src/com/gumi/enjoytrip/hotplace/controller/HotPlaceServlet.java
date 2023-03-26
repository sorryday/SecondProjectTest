package com.gumi.enjoytrip.hotplace.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gumi.enjoytrip.hotplace.dto.HotPlaceDTO;
import com.gumi.enjoytrip.hotplace.service.HotPlaceService;
import com.gumi.enjoytrip.hotplace.service.HotPlaceServiceImpl;
import com.gumi.enjoytrip.util.PageNavigation;
import com.gumi.enjoytrip.util.ParameterCheck;


@WebServlet("/hotplace")
public class HotPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int pgno;
	private String key;
	private String word;
	private String queryStrig;
	
	private HotPlaceService hotplaceService;
       
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		hotplaceService = HotPlaceServiceImpl.getHotPlaceService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		pgno = ParameterCheck.notNumberToOne(request.getParameter("pgno"));
		key = ParameterCheck.nullToBlank(request.getParameter("key"));
		word = ParameterCheck.nullToBlank(request.getParameter("word"));
		queryStrig = "?pgno=" + pgno + "&key=" + key + "&word=" + URLEncoder.encode(word, "utf-8");

		String path = "";
//		if ("list".equals(action)) {
//			path = list(request, response);
//			forward(request, response, path);
//		} else if ("view".equals(action)) {
//			path = view(request, response);
//			forward(request, response, path);
//		} else if ("mvwrite".equals(action)) {
//			path = "/hotplace/write.jsp";
//			redirect(request, response, path);
//		} else if ("write".equals(action)) {
//			path = write(request, response);
//			redirect(request, response, path);
//		} else if ("mvmodify".equals(action)) {
//			path = mvModify(request, response);
//			forward(request, response, path);
//		} else if ("modify".equals(action)) {
//			path = modify(request, response);
//			forward(request, response, path);
//		} else if ("hotplacedelete".equals(action)) {
//			path = delete(request, response);
//			redirect(request, response, path);
//		} else {
//			redirect(request, response, path);
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}
	
	private String list(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
//		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//		if (memberDto != null) {
			try {
				Map<String, String> map = new HashMap<String, String>();
				map.put("pgno", pgno + "");
				map.put("key", key);
				map.put("word", word);
				
				List<HotPlaceDTO> list = hotplaceService.listHotPlace(map);
				request.setAttribute("hotplaces", list);
				
				PageNavigation pageNavigation = hotplaceService.makePageNavigation(map);
				request.setAttribute("navigation", pageNavigation);

				return "/hotplace/hotPlaceList.jsp" + queryStrig;
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글목록 출력 중 문제 발생!!!");
				return "/error/error.jsp";
			}
//		} else
//			return "/user/login.jsp";
	}

}
