package project.host;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.beans.MemberBeans;
import project.beans.MovieReservationBeans;
import project.controller.ActionInterface;
import project.dao.ReserveListDAO;

public class HostPaySuccess implements ActionInterface{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String url = "/host/MoviePay.jsp";
		
		ReserveListDAO rdao = ReserveListDAO.getInstance();
		
		//session user accept
		HttpSession session = request.getSession();
		MemberBeans user = (MemberBeans)session.getAttribute("loginUser");
		String id = user.getId_mem();
		
		String id_resv = request.getParameter("id_resv");
		rdao.updateReserve(Integer.parseInt(id_resv));
		
		List<MovieReservationBeans> reservations =rdao.getReserveList(id);
		request.setAttribute("reserveList", reservations);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
