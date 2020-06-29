package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminDao implements Dao<Admin> {
	private static Logger logger = LoggerFactory.getLogger(AdminDao.class);

	private static final String GET_BY_USERNAME = "SELECT * FROM admins WHERE admin_id = ?";
	private static final String GET_ALL = "SELECT * FROM admins";
	private static final String INSERT = "INSERT INTO admins(username, password) VALUES (?, ?)";
	private static final String UPDATE = "UPDATE admins SET password = ? WHERE admin_id = ?";
	private static final String DELETE = "DELETE FROM admins WHERE admin_id = ?";

	@Override
	public Optional<Admin> get(int id) {
		try (Connection conn = Connector.getConnection(); //
				PreparedStatement ps = conn.prepareStatement(GET_BY_USERNAME)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Admin admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3));
					return Optional.of(admin);
				}
			}
		} catch (SQLException se) {
			logger.error("Can't get admin " + id, se);
		}

		return Optional.empty();
	}

	@Override
	public List<Admin> getAll() {
		List<Admin> results = new ArrayList<>();

		try (Connection conn = Connector.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(GET_ALL)) {
			while (rs.next()) {
				Admin admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3));
				results.add(admin);
			}
		} catch (SQLException se) {
			logger.error("Can't get all admins", se);
		}

		return results;
	}

	@Override
	public void save(Admin admin) {
		try (Connection conn = Connector.getConnection(); PreparedStatement ps = conn.prepareStatement(INSERT)) {
			ps.setInt(1, admin.getID());
			ps.setString(2, admin.getUsername());
			ps.setString(3, admin.getPassword());
		} catch (SQLException se) {
			logger.error("Can't save admin " + admin.getID(), se);
		}
	}

	@Override
	public void update(Admin admin) {
		try (Connection conn = Connector.getConnection(); //
				PreparedStatement ps = conn.prepareStatement(UPDATE)) {
			ps.setString(1, admin.getPassword());
			ps.setInt(2, admin.getID());
			int count = ps.executeUpdate();
			if (count != 1) {
				logger.warn("Updated " + count + " lines for " + admin);
			}
		} catch (SQLException se) {
			logger.error("Can't update admin " + admin.getID(), se);
		}
	}

	@Override
	public void delete(int id) {
		try (Connection conn = Connector.getConnection(); //
				PreparedStatement ps = conn.prepareStatement(DELETE)) {
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			if (count != 1) {
				logger.warn("Deleted " + count + " lines for " + id);
			}
		} catch (SQLException se) {
			logger.error("Can't delete user " + id, se);
		}
	}
}
