package project.host;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.beans.MovieListBeans;
import project.controller.ActionInterface;
import project.dao.MovieListDAO;

public class HostMovieList implements ActionInterface{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String url = "/host/MovieList.jsp";
		MovieListDAO mDao = MovieListDAO.getInstance();
		
		List<MovieListBeans> movies = mDao.getMovieList();
		request.setAttribute("movieList", movies);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}