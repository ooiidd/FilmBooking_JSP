package project.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.beans.MemberBeans;
import project.controller.ActionInterface;
import project.dao.MemberListDAO;

public class RemoveMember implements ActionInterface{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String url = "/admin/AdminMember.jsp";
		String id = request.getParameter("id");
		
		MemberListDAO mdao = MemberListDAO.getInstance();
		mdao.removeMember(id);
		
		List<MemberBeans> members = mdao.getMemberList();
		request.setAttribute("memberList", members);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
