package com.lti.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.service.CollegeService;
import com.lti.service.CollegeServiceImp;

/**
 * Servlet implementation class DeleteColServlet
 */
@WebServlet("/DeleteColServlet")
public class DeleteColServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteColServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
		int cid=Integer.parseInt(request.getParameter("cid"));
		CollegeService service=new CollegeServiceImp();
		service.removeCollege(cid);
		
		request.setAttribute("err", "");
		request.setAttribute("status", "Record Successfully Deleted!");
		RequestDispatcher red=request.getRequestDispatcher("DeleteCol.jsp");
		red.forward(request, response);
		}
	catch(Exception e)
	{
		String error=e.getMessage();
		request.setAttribute("err", error);
		request.setAttribute("status", "");
		RequestDispatcher red=request.getRequestDispatcher("DeleteCol.jsp");
		red.forward(request, response);
	}

	}

}
