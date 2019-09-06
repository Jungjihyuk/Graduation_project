package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.oreilly.servlet.MultipartRequest;
//import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.BoardBean;
import service.BoardService;
import service.HashService;


@WebServlet("/BoardUS.act")
public class BoardUS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	private BoardService boardservice;
	private HashService hashservice;
	
	public BoardUS() {
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
	
		//String fileName=request.getParameter("photo"); 
		//String fileRealName=request.getParameter("photo");
		String content=request.getParameter("content");
		//String photo=request.getParameter("photo");//photo도 여러개 받아와야되는데...
		String hash=request.getParameter("hash");//hash 어떻게 받아올까
		String category=request.getParameter("category");
		
		BoardBean boardbean=new BoardBean();
		boardbean.setCategory(category);
		//boardbean.setPhotoName(fileName);
		//boardbean.setPhotoRealName(fileRealName);
		boardbean.setContent(content);
		
		hashservice.updateHash(hash, boardNum);
		boardservice.updateBoard(boardbean, boardNum);
		RequestDispatcher dis=request.getRequestDispatcher("error/updateSuccess.jsp");
		dis.forward(request, response);
		/*
		if(hashservice.updateHash(hash, boardNum)==true&&boardservice.updateBoard(boardbean, boardNum)==true) {
				RequestDispatcher dis=request.getRequestDispatcher("error/updateSuccess.jsp");
				dis.forward(request, response);
	
		}else {
			//데이터베이스 오류 
			RequestDispatcher dis=request.getRequestDispatcher("error/updateFail.jsp");
			dis.forward(request, response);
			
		}
		*/
	}

}