package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao implements Dao<User>, AutoCloseable {
	private static Logger logger = LoggerFactory.getLogger(UserDao.class);

	private static final String GET_BY_PK = "SELECT * FROM users WHERE user_id = ?";
	private static final String GET_ALL = "SELECT * FROM users";
	private static final String INSERT = "INSERT INTO users(first_name, last_name, birth_date, email, telephone, username, password, city, address, postcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE coders SET email = ?, telephone = ?, password = ?, city = ?, address = ?, postcode = ? WHERE coder_id = ?";
	private static final String DELETE = "DELETE FROM users WHERE user_id = ?";
	
	private static final String DOES_USERNAME_EXIST = "SELECT CASE WHEN EXISTS ( SELECT 1 FROM users WHERE username = ? ) THEN 'true' ELSE 'false' END;",
								IS_PASSWORD_OK = "SELECT CASE WHEN EXISTS ( SELECT 1 FROM users WHERE username = ? AND password = ? ) THEN 'true' ELSE 'false' END;",
								GET_BY_USERNAME = "SELECT * FROM users WHERE username = ?";
	
	private Connection conn;
	
	public UserDao (DataSource ds) {
		try {
            this.conn = ds.getConnection();
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
	}

	@Override
	public Optional<User> get(int id) {
		try (PreparedStatement ps = conn.prepareStatement(GET_BY_PK)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					LocalDate birthDate = rs.getDate(4).toLocalDate();
					User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), birthDate, rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getInt(11));
					return Optional.of(user);
				}
			}
		} catch (SQLException se) {
			logger.error("Can't get user " + id, se);
		}

		return Optional.empty();
	}

	@Override
	public List<User> getAll() {
		List<User> results = new ArrayList<>();

		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(GET_ALL)) {
			while (rs.next()) {
				LocalDate birthDate = rs.getDate(4).toLocalDate();
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), birthDate, rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getInt(11));
				results.add(user);
			}
		} catch (SQLException se) {
			logger.error("Can't get all users", se);
		}

		return results;
	}

	@Override
	public void save(User user) {
		try (PreparedStatement ps = conn.prepareStatement(INSERT)) {

			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setDate(3, Date.valueOf(user.getBirthDate()));
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getTelephone());
			ps.setString(6, user.getUsername());
			ps.setString(7, user.getPassword());
			ps.setString(8, user.getCity());
			ps.setString(9, user.getAddress());
			ps.setInt(10, user.getPostcode());

			ps.executeUpdate();

		} catch (SQLException se) {
			logger.error("Can't save user " + user.getID(), se);
		}
	}

	@Override
	public void update(User user) {
		try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getTelephone());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getCity());
			ps.setString(5, user.getAddress());
			ps.setInt(6, user.getPostcode());
			ps.setInt(7, user.getID());
			int count = ps.executeUpdate();
			if (count != 1) {
				logger.warn("Updated " + count + " lines for " + user);
			}
		} catch (SQLException se) {
			logger.error("Can't update user " + user.getID(), se);
		}
	}

	@Override
	public void delete(int id) {
		try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			if (count != 1) {
				logger.warn("Deleted " + count + " lines for " + id);
			}
		} catch (SQLException se) {
			logger.error("Can't delete user " + id, se);
		}
	}

	public boolean usernameExists(String username) {
		try (PreparedStatement ps = conn.prepareStatement(DOES_USERNAME_EXIST)) {
			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return Boolean.parseBoolean(rs.getString(1));
				}
			}
		} catch (SQLException se) {
			logger.error("Can't check username" + username, se);
		}
		
		return false;
	}
	public boolean passwordCheck(String username, String password) {
		try (PreparedStatement ps = conn.prepareStatement(IS_PASSWORD_OK)) {
			ps.setString(1, username);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return Boolean.parseBoolean(rs.getString(1));
				}
			}
		} catch (SQLException se) {
			logger.error("Can't check password of username" + username, se);
		}
		return false;
	}
	public User getByUsername(String username) {
		try (PreparedStatement ps = conn.prepareStatement(GET_BY_USERNAME)) {
			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					LocalDate birthDate = rs.getDate(4).toLocalDate();
					User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), birthDate, rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getInt(11));
					return user;
				}
			}
		} catch (SQLException se) {
			logger.error("Can't get user " + username, se);
		}

		return null;
	}
	
	
	@Override
	public void close() throws IOException {
		try {
            conn.close();
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
	}
}
