package project.host;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.beans.MemberBeans;
import project.controller.ActionInterface;
import project.dao.MemberListDAO;

public class HostMemberChange implements ActionInterface{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String url = "/host/MemberChange.jsp";

		String num = request.getParameter("num");
		request.setAttribute("num", num);
		

		HttpSession session = request.getSession();
		MemberBeans user = (MemberBeans)session.getAttribute("loginUser");
		String id = user.getId_mem();
		request.setAttribute("userid", id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
