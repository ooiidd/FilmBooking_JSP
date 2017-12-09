package project.host;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
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

public class HostLoginAction implements ActionInterface{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String url="/host/Login.jsp";
		
		String num = request.getParameter("num");
		request.setAttribute("num", num);
		
		
		//login
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberListDAO Mdao = MemberListDAO.getInstance();
		MemberBeans member = new MemberBeans();
		if(id != null && pwd !=null) {
			member=Mdao.matchIdpwd(id, pwd);
		}
		if(member.getId_mem()==null) {
			request.setAttribute("ip", 1);
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", member);
			url = "/host/BuyTicket.jsp";
		}
		
		
		SeatableListDAO dao = SeatableListDAO.getInstance();
		List<MovieSeatBeans> seats = dao.getSeatsList(Integer.parseInt(num));
		Iterator iterator = seats.iterator();
		boolean bo=false;
		while(iterator.hasNext()) {
			MovieSeatBeans seat = (MovieSeatBeans)iterator.next();
			int possible = seat.getPossible();
			if(possible == 1)
				bo=true;
		}
		if(bo) {
			request.setAttribute("seatList", seats);
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("<script>"); 
			out.println("alert('이용 가능한 좌석이 없습니다.');");
			out.println("location.href=\"action?command=movielist\"");
			out.println("</script>");
			out.close();
		}
	}
}
