package project.host;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.ActionInterface;
import project.dao.MemberListDAO;

public class HostSignin implements ActionInterface{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String url = "/host/Login.jsp";

		String num = request.getParameter("num");
		request.setAttribute("num", num);
		System.out.println(num);
		String id = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String age = request.getParameter("age");
		
		MemberListDAO mdao = MemberListDAO.getInstance();
		mdao.setMember(id, pwd, Integer.parseInt(age));
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}