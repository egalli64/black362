package dao;

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

public class BookingDao implements Dao<Booking>, AutoCloseable {

	private static Logger logger = LoggerFactory.getLogger(BookingDao.class);

	private static final String GET_BY_PK = "SELECT * FROM bookings WHERE booking_id = ?";
	private static final String GET_ALL = "SELECT * FROM bookings";
	private static final String INSERT = "INSERT INTO bookings(booking_id, user_id, status) VALUES (?, ?, ?)";
	private static final String UPDATE = "UPDATE bookings SET status = ? WHERE booking_id = ?";
	private static final String DELETE = "DELETE FROM bookings WHERE booking_id = ?";

	private Connection conn;

	public BookingDao (DataSource ds) {
		try {
            this.conn = ds.getConnection();
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
	}

	@Override
	public List<Booking> getAll() {
		List<Booking> results = new ArrayList<>();

		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(GET_ALL)) {
			while (rs.next()) {
				Booking booking = new Booking(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
				results.add(booking);
			}
		} catch (SQLException se) {
			logger.error("Can't get all bookings", se);
		}

		return results;
	}

	@Override
	public Optional<Booking> get(int bookingId) {
		try (PreparedStatement ps = conn.prepareStatement(GET_BY_PK)) {
			ps.setInt(1, bookingId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Booking my = new Booking(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
					return Optional.of(my);
				}
			}
		} catch (SQLException se) {
			logger.error("Can't get booking " + bookingId, se);
		}

		return Optional.empty();
	}

	public Booking legacyGet(int bookingId) {
		try (PreparedStatement ps = conn.prepareStatement(GET_BY_PK)) {
			ps.setInt(1, bookingId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new Booking(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
				}
			}
		} catch (SQLException se) {
			logger.error("Can't get booking " + bookingId, se);
		}

		return null;
	}

	@Override
	public void save(Booking booking) {
		try (PreparedStatement ps = conn.prepareStatement(INSERT)) {
			ps.setInt(1, booking.getID());
			ps.setInt(2, booking.getUserID());
			ps.setString(3, booking.getStatus());
			ps.setString(4, booking.getValues());
			ps.executeUpdate();
		} catch (SQLException se) {
			logger.error("Can't save booking " + booking.getID(), se);
		}
	}

	@Override
	public void update(Booking booking) {
		try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
			ps.setInt(1, booking.getID());
			ps.setInt(2, booking.getUserID());
			ps.setString(4, booking.getStatus());
			ps.setString(5, booking.getValues());
			int count = ps.executeUpdate();
			if (count != 1) {
				logger.warn("Updated " + count + " lines for " + booking);
			}
		} catch (SQLException se) {
			logger.error("Can't update booking " + booking.getID(), se);
		}
	}

	@Override
	public void delete(int bookingId) {
		try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
			ps.setInt(1, bookingId);
			int count = ps.executeUpdate();
			if (count != 1) {
				logger.warn("Deleted " + count + " lines for " + bookingId);
			}
		} catch (SQLException se) {
			logger.error("Can't delete booking " + bookingId, se);
		}
	}

	@Override
	public void close() throws Exception {
		try {
			conn.close();
		} catch (SQLException se) {
			throw new IllegalStateException("Database issue " + se.getMessage());
		}
	}
}
