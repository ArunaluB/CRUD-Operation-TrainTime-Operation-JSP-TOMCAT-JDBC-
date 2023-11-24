package com.TrainManegment.DBAdmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.TrainManegment.Model.*;

public class TrainDBAdmin {

	private String jdbcURL = "jdbc:mysql://localhost:3306/train_web_app?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Arunalu200#";

	private static final String INSERT_USERS_SQL = "INSERT INTO time_table"
			+ "   (trainname,startstation,endstation,date,starttime,endtime) VALUES" + " (?,?,?,?,?,?);";
	private static final String SELECT_ALL_USERS = "select * from time_table";
	private static final String SELECT_USER_BY_ID = "select id,trainname,startstation, endstation,date,starttime,endtime"
			+ " from time_table where id =?";
	private static final String DELETE_USERS_SQL = "DELETE FROM time_table WHERE id = ?;";
	private static final String UPDATE_USERS_SQL = "UPDATE time_table"
			+ " SET trainname = ?, startstation = ?, endstation = ?, date = ?, starttime = ?, endtime = ?"
			+ " WHERE id = ?;";

	public TrainDBAdmin() {

	}

	// connection database
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// insert data in database
	public void insertTime(TrainTime traintime) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, traintime.getTrainname());
			preparedStatement.setString(2, traintime.getStartstation());
			preparedStatement.setString(3, traintime.getEndstation());
			preparedStatement.setString(4, traintime.getDate());
			preparedStatement.setString(5, traintime.getStarttime());
			preparedStatement.setString(6, traintime.getEndtime());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public TrainTime selectTime(int id) {
		TrainTime traintime = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String trainname = rs.getString("trainname");
				String startstation = rs.getString("startstation");
				String endstation = rs.getString("endstation");
				String date = rs.getString("date");
				String starttime = rs.getString("starttime");
				String endtime = rs.getString("endtime");
				traintime = new TrainTime(id, trainname, startstation, endstation, date, starttime, endtime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return traintime;
	}

	public List<TrainTime> selectAllTimes() {
		List<TrainTime> traintimes = new ArrayList<>();

		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String trainname = rs.getString("trainname");
				String startstation = rs.getString("startstation");
				String endstation = rs.getString("endstation");
				String date = rs.getString("date");
				String starttime = rs.getString("starttime");
				String endtime = rs.getString("endtime");
				traintimes.add(new TrainTime(id, trainname, startstation, endstation, date, starttime, endtime));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return traintimes;
	}

	public boolean deleteTime(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateTime(TrainTime traintime) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, traintime.getTrainname());
			statement.setString(2, traintime.getStartstation());
			statement.setString(3, traintime.getEndstation());
			statement.setString(4, traintime.getDate());
			statement.setString(5, traintime.getStarttime());
			statement.setString(6, traintime.getEndtime());
			statement.setInt(7, traintime.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}
