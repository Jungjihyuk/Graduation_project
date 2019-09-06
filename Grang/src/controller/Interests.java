package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserInfoBean;
import model.Viw_boardBean;
import service.UserInfoService;
import service.Viw_boardService;


//@WebServlet("/Interests")
public class Interests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserInfoService userinfoservice;
	private Viw_boardService viwboardservice;
   
	public Interests() {
		userinfoservice=new UserInfoService();
		viwboardservice=new Viw_boardService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request,response);
	}	

	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String contextPath=request.getContextPath();
		String requestUri=request.getRequestURI();
		
		String id=(String) request.getSession().getAttribute("id");
		String changeCategory=request.getParameter("interest");
		
		
		if(requestUri.equals(contextPath+"/change.up")) {
			userinfoservice.updateCategory(changeCategory, id);
			RequestDispatcher dis=request.getRequestDispatcher("error/updateCategorySuccess.jsp");
			dis.forward(request, response);
		}else if(requestUri.equals(contextPath+"/show.up")) {
			String result=null;
			Vector <Viw_boardBean> list=viwboardservice.categoryList();
			result=userinfoservice.selectCategory(id);
			request.setAttribute("category",result);
			request.setAttribute("categoryList", list);
			RequestDispatcher dis=request.getRequestDispatcher("changeInfo.jsp");
			dis.forward(request, response);
		}
			
		
	}	

}
