package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DishDao implements Dao<Dish>, AutoCloseable {

	private static Logger logger = LoggerFactory.getLogger(DishDao.class);

	private static final String GET_BY_PK = "SELECT * FROM dishes WHERE dish_id = ?";
	private static final String GET_ALL = "SELECT * FROM dishes";
	private static final String INSERT = "INSERT INTO dishes(dish_id, name, prices, description) VALUES (?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE dishes SET name = ?, prices = ?, description = ? WHERE dish_id = ?";
	private static final String DELETE = "DELETE FROM dishes WHERE dish_id = ?";
	
	private Connection conn;
	
	public DishDao(DataSource ds) {
		try {
            this.conn = ds.getConnection();
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
	}

	@Override
	public List<Dish> getAll() {
		List<Dish> results = new ArrayList<>();

		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(GET_ALL)) {
			while (rs.next()) {
				Dish dish = new Dish(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
				results.add(dish);
			}
		} catch (SQLException se) {
			logger.error("Can't get all dishes", se);
		}

		return results;
	}

	@Override
	public Optional<Dish> get(int id) {
		try (PreparedStatement ps = conn.prepareStatement(GET_BY_PK)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Dish my = new Dish(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
					return Optional.of(my);
				}
			}
		} catch (SQLException se) {
			logger.error("Can't get dish " + id, se);
		}

		return Optional.empty();
	}

	public Dish legacyGet(int id) {
		try (PreparedStatement ps = conn.prepareStatement(GET_BY_PK)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new Dish(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
				}
			}
		} catch (SQLException se) {
			logger.error("Can't get dish " + id, se);
		}

		return null;
	}

	@Override
	public void save(Dish dish) {
		try (PreparedStatement ps = conn.prepareStatement(INSERT)) {
			ps.setInt(1, dish.getID());
			ps.setString(2, dish.getName());
			ps.setDouble(3, dish.getPrice());
			ps.setString(5, dish.getDescription());
			ps.executeUpdate();
		} catch (SQLException se) {
			logger.error("Can't save dish " + dish.getID(), se);
		}
	}

	@Override
	public void update(Dish dish) {
		try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
			ps.setInt(1, dish.getID());
			ps.setString(2, dish.getName());
			ps.setDouble(3, dish.getPrice());
			ps.setString(3, dish.getDescription());


			int count = ps.executeUpdate();
			if (count != 1) {
				logger.warn("Updated " + count + " lines for " + dish);
			}
		} catch (SQLException se) {
			logger.error("Can't update dish " + dish.getID(), se);
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
			logger.error("Can't delete dish " + id, se);
		}
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
