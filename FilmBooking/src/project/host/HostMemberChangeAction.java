package project.host;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.beans.MemberBeans;
import project.beans.MovieSeatBeans;
import project.controller.ActionInterface;
import project.dao.MemberListDAO;
import project.dao.SeatableListDAO;

public class HostMemberChangeAction implements ActionInterface{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String url = "/host/BuyTicket.jsp";

		MemberListDAO mdao = MemberListDAO.getInstance();
		String id = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String age = request.getParameter("age");
		String num = request.getParameter("num");
		request.setAttribute("num", num);
		
		//멤버 db변경
		mdao.updateMember(id, pwd, Integer.parseInt(age));
		MemberBeans member = new MemberBeans();
		member = mdao.matchIdpwd(id, pwd);
		
		//session 변경
		HttpSession session = request.getSession();
		session.invalidate();
		session = request.getSession();
		session.setAttribute("loginUser", member);
		
		SeatableListDAO dao = SeatableListDAO.getInstance();
		List<MovieSeatBeans> seats = dao.getSeatsList(Integer.parseInt(num));
		request.setAttribute("seatList", seats);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
