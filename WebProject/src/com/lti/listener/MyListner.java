package com.lti.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.lti.bean.College;
import com.lti.service.CollegeService;
import com.lti.service.CollegeServiceImp;

/**
 * Application Lifecycle Listener implementation class MyListner
 *
 */
@WebListener
public class MyListner implements ServletContextListener {

  
    public MyListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         System.out.println("CONTEXT IS INITIALISED");
         CollegeService service=new CollegeServiceImp();
         List<College> clist=service.displayAllColleges();
         ServletContext application=arg0.getServletContext();
         application.setAttribute("collist", clist);
         
         List<College> cmlist=service.collegesInMumbaiEngg();
         application.setAttribute("colmlist", cmlist);
    }
	
}
