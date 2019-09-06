package controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserInfoBean;
import service.UserInfoService;
import service.UserService;


//@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userservice;
	private UserInfoService userinfoservice;
	public User() {
		userservice=new UserService();
		userinfoservice=new UserInfoService();
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
		
		HttpSession session=request.getSession();
		/*
		if(request.getSession().getAttribute("id")!=null) {
			RequestDispatcher dis=request.getRequestDispatcher("error/AlreadyLogin.jsp");
			dis.forward(request, response);
		}
		*/
		String contextPath=request.getContextPath();
		String requestUri=request.getRequestURI();
		
		if(requestUri.equals(contextPath+"/signup.do")) {
			String name=request.getParameter("userName");
			String id=request.getParameter("id");
			String password=request.getParameter("password");
			String passwordchk=request.getParameter("passwordchk");
		
			boolean result=userservice.signup(name, id, password, passwordchk);
			if(result==true) {
				request.getSession().setAttribute("id", id);
				userinfoservice.insertUserInfo(id);
				RequestDispatcher dis=request.getRequestDispatcher("interests.jsp");
				dis.forward(request, response);
			}else {
				request.setAttribute("msg", "존재하는 아이디입니다.");
				RequestDispatcher dis=request.getRequestDispatcher("error/AlreadyExistId.jsp");
				dis.forward(request, response);
			}
		}else if(requestUri.equals(contextPath+"/login.do")){
			String id=request.getParameter("id");
			String password=request.getParameter("password");
			if(userservice.login(id, password)==1) {                //로그인 성공시 True 값을 반환
				request.setAttribute("msg", "로그인 성공");
				request.getSession().setAttribute("id", id);
				//response.sendRedirect("feed.jsp");
				request.getRequestDispatcher("selectAllBoard.act").forward(request, response);
			}else if(userservice.login(id, password)==0){
				RequestDispatcher dis=request.getRequestDispatcher("error/NotExistError.jsp");
				dis.forward(request, response);
			}else if(userservice.login(id, password)==2) {
				RequestDispatcher dis=request.getRequestDispatcher("error/NoMatchPw.jsp");
				dis.forward(request, response);
			}
		}else if(requestUri.equals(contextPath+"/logout.do")){
			//로그아웃
			//session이 없다면 로그인을 하라는 메시지 
			//session이 있다면 invalidate()으로 로그아웃 처리 
			session.invalidate();
			RequestDispatcher dis=request.getRequestDispatcher("index.jsp");
			dis.forward(request, response);
		}else if(requestUri.equals(contextPath+"/insertInterests.do")) {
			//userInfo에 카테고리 저장하기 
			//가입한 유저 session 가져오기 
			//관심사 리스트로 받아오기 
			//관심사 userinfo table에 저장
			
			//미완성
			UserInfoBean userinfobean=new UserInfoBean();
			
			String user=userinfobean.getUserId();
			String interest=URLDecoder.decode(request.getParameter("interest"),"UTF-8");
			
			userinfoservice.updateCategory(interest, user);
			
			RequestDispatcher dis=request.getRequestDispatcher("feed.jsp");
			dis.forward(request, response);
			
		}else if(requestUri.equals(contextPath+"")) {
			//사진 수정하기
		}
	}
}
