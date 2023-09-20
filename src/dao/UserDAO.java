package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDAO {

	public static PreparedStatement ps;
	public static ResultSet rs;
	public static List<User> listUser = new ArrayList<>();

	public static List<User> getDataAllUser(String sql) {
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				listUser.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}

	public static boolean login(String username, String password) {
		User u;
		boolean flag = false;
		try {
			String sql = "Select username, password from Users where username=? and password= ?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet r = ps.executeQuery();
			while (r.next()) {

				u = new User(r.getString(1), r.getString(2));
				flag = true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
}
