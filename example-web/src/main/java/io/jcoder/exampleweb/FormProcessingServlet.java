package io.jcoder.exampleweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="form-processing-servlet", urlPatterns = {"/process"}, loadOnStartup = 1)
public class FormProcessingServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		// internal processing...
		
		String ipAndEmail = req.getRemoteAddr() + ":" + email;
		req.setAttribute("ip", ipAndEmail);
		
		req.getRequestDispatcher("/processed.jsp").forward(req, resp);
	}
	
}
