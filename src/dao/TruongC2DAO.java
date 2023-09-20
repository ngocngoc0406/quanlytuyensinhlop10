package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.TruongC2;

public class TruongC2DAO {

	public static PreparedStatement ps;
	public static ResultSet rs;
	public static List<TruongC2> listTrc2;

	public static ResultSet getDataTruongC2(String sql) {
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			return ps.executeQuery();
		} catch (Exception e) {
			return null;
		}
	}

	public static TruongC2[] getDataAllTruongC2(String sql) {

		TruongC2[] itemC2s = null;
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				itemC2s = new TruongC2[] { new TruongC2(r.getString(1), r.getString(2)) };
			}
		} catch (Exception e) {

		}
		return itemC2s;
	}

	public static List<TruongC2> getDataTruongC2Cbox(String sql) {

		List<TruongC2> itemC2s = new ArrayList<>();
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				itemC2s.add(new TruongC2(r.getString(1), r.getString(2)));

			}
		} catch (Exception e) {

		}
		return itemC2s;
	}

	public static TruongC2 getATruongC2(String ma) {
		TruongC2 tr = null;
		try {
			String sql = " select * from TruongC2 where matruongc2= ?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tr = new TruongC2(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (Exception e) {

		}
		return tr;
	}

	public static void insertDataTruongC2(TruongC2 tr) {
		String sql = "insert into TruongC2 values(?,?,?,?)";
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setString(1, tr.getMaTruongC2());
			ps.setString(2, tr.getTenTruongC2());
			ps.setString(3, tr.getDiachiTruongC2());
			ps.setString(4, tr.getGhiChu());
			ps.execute();
			JOptionPane.showMessageDialog(null, "Thêm  thành công!", "Thông báo", 1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Thêm thất bại", "Thông báo", 2);
		}
	}

	public static boolean UpdateTruongC2(TruongC2 tr) {
		try {
			ps = ConnectDB.getConnect().prepareStatement(
					"UPDATE TRUONGC2 SET   TENTRUONGC2 = ?," + "DIACHITRUONGC2 = ?, GHICHU = ? where MATRUONGC2 = ?");

			ps.setString(4, tr.getMaTruongC2());
			ps.setString(1, tr.getTenTruongC2());
			ps.setString(2, tr.getDiachiTruongC2());
			ps.setString(3, tr.getGhiChu());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean deleteTruongC2(String maTruong) {
		try {
			ps = ConnectDB.getConnect().prepareStatement("DELETE FROM TRUONGC2 WHERE MATRUONGC2 = ?");
			ps.setString(1, maTruong);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}

}
