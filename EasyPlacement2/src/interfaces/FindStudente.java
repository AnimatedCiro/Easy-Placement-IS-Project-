package interfaces;

import java.sql.SQLException;

public interface FindStudente {
	int findUserId(String username) throws SQLException, ClassNotFoundException;
}
