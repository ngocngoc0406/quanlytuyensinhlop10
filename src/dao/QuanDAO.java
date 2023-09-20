package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Quan;

public class QuanDAO {
	public static PreparedStatement ps;
	public static ResultSet rs;

	public static ResultSet getDataQuan(String sql) {
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			return ps.executeQuery();
		} catch (Exception e) {
			return null;
		}
	}

	public static List<Quan> getDataQuanCbox(String sql) {
		List<Quan> items = new ArrayList<>();
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				items.add(new Quan(r.getString(1), r.getString(2)));

			}
		} catch (Exception e) {

		}
		return items;
	}

	public static Quan getAQuan(String ma) {
		Quan tr = null;
		try {
			String sql = " select * from Quan where maQuan= ?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tr = new Quan(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tr;
	}

	public static void insertDataQuan(Quan tr) {
		String sql = "insert into Quan values(?,?,?)";
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setString(1, tr.getMaQuan());
			ps.setString(2, tr.getTenQuan());
			ps.setString(3, tr.getKhuVuc());

			ps.execute();
			JOptionPane.showMessageDialog(null, "Thêm  thành công!", "Thông báo", 1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Thêm thất bại", "Thông báo", 0);
		}
	}

	public static boolean UpdateQuan(Quan tr) {
		try {
			ps = ConnectDB.getConnect()
					.prepareStatement("UPDATE Quan SET   tenquan = ?," + "Khuvuc = ? where maquan = ?");

			ps.setString(3, tr.getMaQuan());
			ps.setString(1, tr.getTenQuan());
			ps.setString(2, tr.getKhuVuc());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean deleteQuan(String maTruong) {
		try {
			ps = ConnectDB.getConnect().prepareStatement("DELETE FROM Quan WHERE MAQuan = ?");
			ps.setString(1, maTruong);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
