package controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
//import java.io.File;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
//import model.BoardBean;
//import model.HashBean;
import model.Viw_boardBean;
import service.BoardService;
import service.HashService;
import service.UserInfoService;
import service.Viw_boardService;

//@WebServlet("/uploadBoard.do")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private BoardService boardservice;
	private HashService hashservice;
	private Viw_boardService viwboardservice;
	private UserInfoService userinfoservice;
	public Board() {
		boardservice=new BoardService();
		hashservice=new HashService();
		viwboardservice=new Viw_boardService();
		userinfoservice=new UserInfoService();
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
		
		String contextPath=request.getContextPath();
		String requestUri=request.getRequestURI();
		//int boardNumber=Integer.parseInt(request.getParameter("boardNum"));
		//HttpSession session=request.getSession();
		//UserBean userbean=(UserBean) session.getAttribute("userbean");
		
		//requestUri.equals(contextPath+"uploadBoard.do")
		if(requestUri.equals(contextPath+"/uploadBoard.act")) {
			//게시물 업로드
			String directory=request.getSession().getServletContext().getRealPath("/upload/");
			
			int maxSize=1024*1024*100;
			String encoding="UTF-8";
			
			MultipartRequest multipartRequest=new MultipartRequest(request, directory, maxSize, encoding, new DefaultFileRenamePolicy());
					
			String fileName=multipartRequest.getOriginalFileName("photo"); 
			String fileRealName=multipartRequest.getFilesystemName("photo");	
			
			
			HttpSession session=request.getSession();
			//UserBean userbean=(UserBean) session.getAttribute("userbean");
			//String userId=(String) userbean.getId();
			
			String content=multipartRequest.getParameter("content");
			//String photo=request.getParameter("photo");//photo도 여러개 받아와야되는데...
			String hash=multipartRequest.getParameter("hash");//hash 어떻게 받아올까
			String category=multipartRequest.getParameter("category");
			String userId=(String) session.getAttribute("id");
			
			//게시물 DB insert
			int result=boardservice.uploadBoard(content, fileName, fileRealName, category, userId);
			
			if(result==1) {
				//board가 제대로 저장되었다면 boardNum을 가지고와 hash 테이블에도 넣기.
				//저장 작업이 완료되었으면 feed.jsp로 이동
				int boardNum=0;
				BoardDAO boarddao=new BoardDAO();
				boardNum=boarddao.selectOneBoardNum();
				hashservice.uploadBoard(hash, boardNum);
				
				RequestDispatcher dis=request.getRequestDispatcher("/selectAllBoard.act");
				dis.forward(request, response);
			}else if(boardservice.uploadBoard(content, fileName, fileRealName, category, userId)==2) {
				//로그인이 필요합니다.
				RequestDispatcher dis=request.getRequestDispatcher("error/NeedId.jsp");
				dis.forward(request, response);
			}else if(boardservice.uploadBoard(content, fileName, fileRealName, category, userId)==3) {
				//카테고리를 선택해주세요.
				RequestDispatcher dis=request.getRequestDispatcher("error/NeedCategory.jsp");
				dis.forward(request, response);
			}else {
				//오류
				RequestDispatcher dis=request.getRequestDispatcher("uploadError.jsp");
				dis.forward(request, response);
			}
		}else if(requestUri.equals(contextPath+"/userBoard.act")) {
			//유저 관심사 게시물 보기 
			HttpSession session=request.getSession();
			String userId=(String) session.getAttribute("id");
			String category=userinfoservice.selectCategory(userId);
			
			Vector <Viw_boardBean> list=viwboardservice.userBoard(category);
			request.setAttribute("list", list);
			RequestDispatcher dis=request.getRequestDispatcher("feed.jsp");
			dis.forward(request, response);
		}else if(requestUri.equals(contextPath+"/selectAllBoard.act")) {
			//전체 게시물 보기 
			Vector <Viw_boardBean> list=viwboardservice.selectAllBoard();
			request.setAttribute("list", list);
			RequestDispatcher dis=request.getRequestDispatcher("feed.jsp");
			dis.forward(request, response);
		}else if(requestUri.equals(contextPath+"/myFeed.act")) {
			//내 게시물 보기 
			HttpSession session=request.getSession();
			String userId=(String) session.getAttribute("id");
			Vector <Viw_boardBean> list=viwboardservice.myBoard(userId);
			request.setAttribute("list", list);
			RequestDispatcher dis=request.getRequestDispatcher("myFeed.jsp");
			dis.forward(request, response);
		}else if(requestUri.equals(contextPath+"/searchHash.act")) {
			//해시 검색 
			String hash=URLDecoder.decode(request.getParameter("hash"),"UTF-8");
			Vector <Viw_boardBean> Slist=viwboardservice.searchBoard(hash);
			request.setAttribute("Slist", Slist);
			RequestDispatcher dis=request.getRequestDispatcher("feedSearch.jsp");
			dis.forward(request, response);
		}
		
	}

}
