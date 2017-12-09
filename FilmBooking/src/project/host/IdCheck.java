package project.host;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.ActionInterface;
import project.dao.MemberListDAO;


public class IdCheck implements ActionInterface{
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/host/idcheck.jsp";
		String userid = request.getParameter("userid");
		MemberListDAO mDao = MemberListDAO.getInstance();

		String num = request.getParameter("num");
		request.setAttribute("num", num);
		System.out.println(num);
		int result = mDao.confirmID(userid);
		request.setAttribute("userid", userid);
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
