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


@WebServlet("/UpfeesServlet")
public class UpfeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpfeesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//try

		String cname=request.getParameter("cname");
	
		int new_fees=Integer.parseInt(request.getParameter("fees"));
		
		
		CollegeService service=new CollegeServiceImp();
		service.changeCollegeFees(cname, new_fees);
		
		request.setAttribute("err", "");
		request.setAttribute("status", "Record Successfully Updated!");
		RequestDispatcher red=request.getRequestDispatcher("Upfees.jsp");
		red.forward(request, response);
	
	/*catch(Exception e)
	{
		String error=e.getMessage();
		request.setAttribute("err", error);
		request.setAttribute("status", "");
		RequestDispatcher red=request.getRequestDispatcher("Upfees.jsp");
		red.forward(request, response);
	}*/

	
	}
	
	
}
