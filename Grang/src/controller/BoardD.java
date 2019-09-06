package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import service.HashService;


@WebServlet("/BoardD.act")
public class BoardD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardservice;
	private HashService hashservice;
	
	public BoardD() {
		boardservice=new BoardService();
		hashservice=new HashService();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int boardNum=Integer.parseInt(request.getParameter("boardNum"));
		
		if(hashservice.deleteHash(boardNum)==true) {
			boardservice.removeBoard(boardNum);
			RequestDispatcher dis=request.getRequestDispatcher("error/deleteSuccess.jsp");
			dis.forward(request, response);
			//response.sendRedirect("error/deleteSuccess.jsp");
		}else {
			//삭제 실패 데이터베이스 오류
			RequestDispatcher dis=request.getRequestDispatcher("error/deleteFail.jsp");
			dis.forward(request, response);
			//response.sendRedirect("error/deleteFail.jsp");
		}
	}

}
