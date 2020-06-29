package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao implements Dao<User> {
	private static Logger logger = LoggerFactory.getLogger(UserDao.class);

	private static final String GET_BY_PK = "SELECT * FROM users WHERE user_id = ?";
	private static final String GET_ALL = "SELECT * FROM users";
	private static final String INSERT = "INSERT INTO users(first_name, last_name, birth_date, email, telephone, username, password, city, address, postcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//  private static final String UPDATE = "UPDATE coders SET first_name = ?, last_name = ?, hire_date = ?, salary = ? WHERE coder_id = ?";
	private static final String DELETE = "DELETE FROM users WHERE user_id = ?";

	@Override
	public Optional<User> get(int id) {
		return null;
	}

	@Override
	public List<User> getAll() {
		List<User> results = new ArrayList<>();

		try (Connection conn = Connector.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(GET_ALL)) {
			while (rs.next()) {
				LocalDate birth_date = rs.getDate(4).toLocalDate();
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), birth_date, rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11));
				results.add(user);
			}
		} catch (SQLException se) {
			logger.error("Can't get all users", se);
		}

		return results;
	}

	@Override
	public void save(User t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
