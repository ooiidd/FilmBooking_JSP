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

public class AdminLogin implements ActionInterface{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String url = "/admin/AdminMovieList.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		if(id.equals("admin") && pwd.equals("admin")) {
			MovieListDAO mdao = MovieListDAO.getInstance();
			List<MovieListBeans> movies = mdao.getMovieList();
			request.setAttribute("movieList", movies);
		}else {
			url = "/admin/AdminLogin.jsp";
			request.setAttribute("ip", 1);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}