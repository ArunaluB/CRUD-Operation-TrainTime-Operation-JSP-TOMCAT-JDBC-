package com.TrainManegment.TrainControl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TrainManegment.DBAdmin.TrainDBAdmin;
import com.TrainManegment.Model.TrainTime;

@WebServlet("/")
public class TrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TrainDBAdmin trainDBadmin;

	public void init() {
		trainDBadmin = new TrainDBAdmin();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertTime(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listTime(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	// all list arraylist
	private void listTime(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<TrainTime> listTime = trainDBadmin.selectAllTimes();
		// list aka penna for ech aka use kara aka
		request.setAttribute("listTime", listTime);
		RequestDispatcher dispatcher = request.getRequestDispatcher("time-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		TrainTime existingTime = trainDBadmin.selectTime(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		// form aka user kara var aka
		request.setAttribute("train", existingTime);
		dispatcher.forward(request, response);
	}

	private void insertTime(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String trainname = request.getParameter("trainname");
		String startstation = request.getParameter("startstation");
		String endstation = request.getParameter("endstation");
		String date = request.getParameter("date");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		TrainTime newTime = new TrainTime(trainname, startstation, endstation, date, starttime, endtime);
		trainDBadmin.insertTime(newTime);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String trainname = request.getParameter("trainname");
		String startstation = request.getParameter("startstation");
		String endstation = request.getParameter("endstation");
		String date = request.getParameter("date");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");

		TrainTime updateTime = new TrainTime(id, trainname, startstation, endstation, date, starttime, endtime);

		trainDBadmin.updateTime(updateTime);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		trainDBadmin.deleteTime(id);
		response.sendRedirect("list");

	}
}// anithama end aka
