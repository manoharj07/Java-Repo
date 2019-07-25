package com.lti.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lti.bean.College;
import com.lti.service.CollegeService;
import com.lti.service.CollegeServiceImp;
/**
 * Servlet implementation class insertServlet
 */
@WebServlet("/insertServlet")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public insertServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int mycid=Integer.parseInt(request.getParameter("cid"));
			String c_name=request.getParameter("cname");
			String c_course=request.getParameter("coursetype");
			String c_city=request.getParameter("city");
			int myfees=Integer.parseInt(request.getParameter("fees"));
			int mypin=Integer.parseInt(request.getParameter("pincode"));		
	
			
						
			College ob = new College(mycid,c_name,c_course,c_city,myfees,mypin);
			CollegeService service = new CollegeServiceImp();
			service.addCollege(ob);
			
			request.setAttribute("err","");
			request .setAttribute("status","Record Inserted");
			RequestDispatcher red = request.getRequestDispatcher("insertCollege.jsp");
			red.forward(request, response);
			}
		catch(Exception e) {
			String error = e.getMessage();
			request.setAttribute("err", error);
			request.setAttribute("status","");
			RequestDispatcher red = request.getRequestDispatcher("insertCollege.jsp");
			red.forward(request, response);
		}

	}

}
