package project.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.beans.MovieListBeans;
import project.controller.ActionInterface;
import project.dao.MovieListDAO;

public class RemoveMovie implements ActionInterface{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String url = "/admin/AdminMovieList.jsp";
		
		MovieListDAO mdao = MovieListDAO.getInstance();
		String id_film = request.getParameter("num");
		mdao.removeMovie(Integer.parseInt(id_film));
		List<MovieListBeans> movies = mdao.getMovieList();
		request.setAttribute("movieList", movies);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
