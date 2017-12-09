package project.admin;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.controller.ActionInterface;
import project.dao.MovieListDAO;

public class InsertFilm implements ActionInterface{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String url = "/admin/InsertFilm.jsp";
		
		MovieListDAO mdao = MovieListDAO.getInstance();
		String title = request.getParameter("title");
		String age = request.getParameter("age");
		String seat = request.getParameter("seat");
		String sdate = request.getParameter("sdate");
		String edate = request.getParameter("edate");
		mdao.insertMovie(title, Integer.parseInt(age), Integer.parseInt(seat), Date.valueOf(sdate), Date.valueOf(edate));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
