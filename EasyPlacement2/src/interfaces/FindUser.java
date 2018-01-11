package interfaces;

import java.sql.SQLException;

public interface FindUser {
	String findUser(String username) throws ClassNotFoundException, SQLException;
}
