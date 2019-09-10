package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.applyBean;
import dao.applyDao;

public class applyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String firstname=request.getParameter("firstname");
		String middlename=request.getParameter("middlename");
		String lastname=request.getParameter("lastname");
		PrintWriter pw=response.getWriter();
		applyBean ApplyBean = new applyBean();
		
		ApplyBean.setTitle(title);
		ApplyBean.setFirstname(firstname);
		ApplyBean.setMiddlename(middlename);
		ApplyBean.setLastname(lastname);
		
		applyDao applyDao = new applyDao();
		 
		 String UserApply= applyDao.apply(ApplyBean);
		 if(UserApply.equals("SUCCESS")) 
		 {
			 pw.println("success");
		 request.getRequestDispatcher("/viewemp.jsp").forward(request, response);
		 }
		 else   
		 {
		 request.setAttribute("errMessage", UserApply);
		 request.getRequestDispatcher("/Register.html").forward(request, response);
		 } 
		}
	}


