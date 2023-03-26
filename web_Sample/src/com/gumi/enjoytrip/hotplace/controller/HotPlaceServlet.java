package com.gumi.enjoytrip.hotplace.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
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
		hotplaceService = HotPlaceServiceImpl.getInstance();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		pgno = ParameterCheck.notNumberToOne(request.getParameter("pgno"));
		key = ParameterCheck.nullToBlank(request.getParameter("key"));
		word = ParameterCheck.nullToBlank(request.getParameter("word"));
		queryStrig = "?pgno=" + pgno + "&key=" + key + "&word=" + URLEncoder.encode(word, "utf-8");
		
		System.out.println(pgno);

		String path = "";
		if ("list".equals(action)) {
			path = list(request, response);
			forward(request, response, path);
		} else if ("view".equals(action)) {
			path = view(request, response);
			forward(request, response, path);
		} else if ("write".equals(action)) {
			path = write(request, response);
			redirect(request, response, path);
		} else if ("mvmodify".equals(action)) {
			path = mvModify(request, response);
			forward(request, response, path);
		}
		else if ("modify".equals(action)) {
			path = modify(request, response);
			forward(request, response, path);
		} else if ("delete".equals(action)) {
			path = delete(request, response);
			redirect(request, response, path);
		} else {
			redirect(request, response, path);
		}	
	}

	private String write(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
//		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//		if (memberDto != null) {
			HotPlaceDTO hotPlaceDto = new HotPlaceDTO();
			
			hotPlaceDto.setTitle(request.getParameter("place-name"));
			hotPlaceDto.setContent(request.getParameter("content"));
			
			hotPlaceDto.setDate(Date.valueOf(request.getParameter("date")));
			hotPlaceDto.setPlacetype(Integer.parseInt(request.getParameter("type")));
			
			hotPlaceDto.setUser_id("ssafy"); // 임시 아이디
			
			hotPlaceDto.setLatitude(request.getParameter("latitude"));
			hotPlaceDto.setLongitude(request.getParameter("longitude"));
			
			try {
				int n = HotPlaceServiceImpl.getInstance().writeHotPlace(hotPlaceDto);
				
				if (n > 0) {
					return "/hotplace?action=list";
				} 
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글작성 중 문제 발생!!!");
				return "/error/error.jsp";
			}
			return "/error/error.jsp";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
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
				
				List<HotPlaceDTO> list = HotPlaceServiceImpl.getInstance().listHotPlace(map);
				request.setAttribute("hotplaces", list);
				
				PageNavigation pageNavigation = HotPlaceServiceImpl.getInstance().makePageNavigation(map);
				request.setAttribute("navigation", pageNavigation);

				return "list.jsp" + queryStrig;
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글목록 출력 중 문제 발생!!!");
				return "/error/error.jsp";
			}
//		} else
//			return "/user/login.jsp";
	}
	
	private String view(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
//		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//		if (memberDto != null) {
			int id = Integer.parseInt(request.getParameter("hotplace-id"));
			try {
				HotPlaceDTO hotplaceDto = hotplaceService.getHotPlace(id);
//				hotplaceService.updateHit(id);
				request.setAttribute("selectedHotPlace", hotplaceDto);

				return "/view.jsp" + queryStrig;
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글내용 출력 중 문제 발생!!!");
				return "/error/error.jsp";
			}
//		} else
//			return "/user/login.jsp";
	}
	
	private String mvModify(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 수정하고자하는 글의 글번호를 얻는다.
		// TODO : 글번호에 해당하는 글정보를 얻고 글정보를 가지고 modify.jsp로 이동.
		try {
			HttpSession session = request.getSession();
//			MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//			if(memberDto != null) {
				int id = Integer.parseInt(request.getParameter("selectedHotPlace-id"));
				HotPlaceDTO hotplaceDto = hotplaceService.getHotPlace(id);
				request.setAttribute("modifyHotPlace", hotplaceDto);
				
				return "modify.jsp";
//			} else
//				return "/user/login.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글내용 얻는 중 문제 발생!!!");
			return "/error/error.jsp";
		}
	}

	private String modify(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 수정 할 글정보를 얻고 BoardDto에 set.
		// TODO : boardDto를 파라미터로 service의 modifyArticle() 호출.
		// TODO : 글수정 완료 후 view.jsp로 이동.(이후의 프로세스를 생각해 보세요.)
		HttpSession session = request.getSession();
//		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//		if(memberDto != null) {
			HotPlaceDTO hotplaceDto = new HotPlaceDTO();
			hotplaceDto.setId(Integer.parseInt(request.getParameter("modifyHotPlace-id")));
			hotplaceDto.setTitle(request.getParameter("title"));
			hotplaceDto.setDate(Date.valueOf(request.getParameter("date")));
			hotplaceDto.setContent(request.getParameter("content"));
			hotplaceDto.setPlacetype(Integer.parseInt(request.getParameter("type")));
			hotplaceDto.setLatitude(request.getParameter("latitude"));
			hotplaceDto.setLongitude(request.getParameter("longitude"));
			
			try {
				int n = hotplaceService.modifyHotPlace(hotplaceDto);
				
				if (n > 0) {
					return "/hotplace?action=list&pgno=1&key=&word=";
				} else {
					request.setAttribute("msg", "글수정 중 문제 발생!!!");
					return "/error/error.jsp";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글수정 중 문제 발생!!!");
				return "/error/error.jsp";
			}
			
//		} else
//			return "/user/login.jsp";
	}
	
	private String delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 삭제할 글 번호를 얻는다.
		// TODO : 글번호를 파라미터로 service의 deleteArticle()을 호출.
		// TODO : 글삭제 완료 후 list.jsp로 이동.(이후의 프로세스를 생각해 보세요.)
		HttpSession session = request.getSession();
//		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//		if(memberDto != null) {
			int id = Integer.parseInt(request.getParameter("selectedHotPlace-id"));
			
			try {
				hotplaceService.deleteHotPlace(id);
				return "/hotplace?action=list&pgno=1&key=&word=";
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "글삭제 중 문제 발생!!!");
				return "/error/error.jsp";
			}
			
//		} else
//			return "/user/login.jsp";
	}
}
