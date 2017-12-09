package project.host;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.beans.MemberBeans;
import project.beans.MovieListBeans;
import project.beans.MovieReservationBeans;
import project.controller.ActionInterface;
import project.dao.MovieListDAO;
import project.dao.ReserveListDAO;

public class HostPayList implements ActionInterface{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String url = "/host/MoviePay.jsp";
		
		MovieListDAO mdao = MovieListDAO.getInstance();
		ReserveListDAO rdao = ReserveListDAO.getInstance();
		HttpSession session = request.getSession();
		MemberBeans user = (MemberBeans)session.getAttribute("loginUser");
		String id = user.getId_mem();
		int age = user.getAge_mem();

		String num = request.getParameter("num");
		String movie_id = request.getParameter("movie");
		MovieListBeans movie = mdao.selectMovie(Integer.parseInt(movie_id));
		int movie_age = movie.getAge_phase();
		System.out.println(num+" "+age+" "+movie_age);
		if(movie_age<=age) {
			if(num != null) {
				String seat = request.getParameter("seat");
				rdao.setReserve(id, Integer.parseInt(seat), Integer.parseInt(num));
			}
			List<MovieReservationBeans> reservations =rdao.getReserveList(id);
			request.setAttribute("reserveList", reservations);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("<script>"); 
			out.println("alert('연령 제한입니다. 영화 리스트로 돌아갑니다.');");
			out.println("location.href=\"action?command=movielist\"");
			out.println("</script>");
			out.close();
		}
	}
}
