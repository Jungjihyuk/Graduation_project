package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Viw_boardBean;
import service.BoardService;
import service.HashService;
import service.Viw_boardService;


@WebServlet("/BoardU.act")
public class BoardU extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private Viw_boardService viwboardservice;
	//private BoardService boardservice;
	//private HashService hashservice;
	
	public BoardU() {
		//boardservice=new BoardService();
		//hashservice=new HashService();
		viwboardservice=new Viw_boardService();
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
		Vector <Viw_boardBean> Ulist=viwboardservice.updateBoard(boardNum);
		request.setAttribute("Ulist", Ulist);
		RequestDispatcher dis=request.getRequestDispatcher("updateMyFeed.jsp");
		dis.forward(request, response);
		 

	}

}
