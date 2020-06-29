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

public class BookingDao implements Dao<Booking>{
	
	private static Logger logger = LoggerFactory.getLogger(BookingDao.class);

    private static final String GET_BY_PK = "SELECT booking_id, user_id, status, values FROM bookings WHERE booking_id = ?";
    private static final String GET_ALL = "SELECT booking_id, user_id, status, values FROM bookings";
    private static final String INSERT = "INSERT INTO bookings(booking_id, user_id, status, values) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE bookings SET status = ?, values = ? WHERE booking_id = ? AND user_id = ?";
    //user_id ???? Where o update
    private static final String DELETE = "DELETE FROM bookings WHERE booking_id = ?";

    
//  booking_id integer primary key auto_increment,
//	user_id foreign key(user_id) references users (user_id),
//	status varchar(30),
//	values varchar(30) 
	
    @Override
    public List<Booking> getAll() {
        List<Booking> results = new ArrayList<>();

        try (Connection conn = Connector.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(GET_ALL)) {
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
        try (Connection conn = Connector.getConnection(); //
                PreparedStatement ps = conn.prepareStatement(GET_BY_PK)) {
            ps.setLong(1, bookingId);
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
        try (Connection conn = Connector.getConnection(); //
                PreparedStatement ps = conn.prepareStatement(GET_BY_PK)) {
            ps.setLong(1, bookingId);
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
        try (Connection conn = Connector.getConnection(); //
                PreparedStatement ps = conn.prepareStatement(INSERT)) {
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
        try (Connection conn = Connector.getConnection(); //
                PreparedStatement ps = conn.prepareStatement(UPDATE)) {
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
        try (Connection conn = Connector.getConnection(); //
                PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setInt(1, bookingId);
            int count = ps.executeUpdate();
            if (count != 1) {
                logger.warn("Deleted " + count + " lines for " + bookingId);
            }
        } catch (SQLException se) {
            logger.error("Can't delete booking " + bookingId, se);
        }
    }
	
	
	
}