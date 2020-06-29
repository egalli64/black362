package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminDao implements Dao<Admin>{
	private static Logger logger = LoggerFactory.getLogger(AdminDao.class);
	
	private static final String GET_BY_PK = "SELECT * FROM admins WHERE username = ?";
	private static final String GET_ALL = "SELECT * FROM admins";
	private static final String INSERT = "INSERT INTO admins(username, password) VALUES (?, ?)";
	private static final String UPDATE = "UPDATE admins SET password = ? WHERE admin_id = ?";
	private static final String DELETE = "DELETE FROM admins WHERE admin_id = ?";

	@Override
	public Optional<Admin> get(int id) {
		try (Connection conn = Connector.getConnection(); //
                PreparedStatement ps = conn.prepareStatement(GET_BY_PK)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
//                    Admin admin = new Admin(rs.getString(1), );
//                    return Optional.of(admin);
                }
            }
        } catch (SQLException se) {
            logger.error("Can't get admin " + id, se);
        }

        return Optional.empty();
	}

	@Override
	public List<Admin> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Admin t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Admin t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
}
