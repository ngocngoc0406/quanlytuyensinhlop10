package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.TruongC2;
import model.TruongC3;

public class TruongC3DAO {
	public static PreparedStatement ps;
	public static ResultSet rs;

	public static ResultSet getDataTruongC3(String sql) {
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			return ps.executeQuery();
		} catch (Exception e) {
			return null;
		}
	}

	public static TruongC3 getATruongC3(String ma) {
		TruongC3 tr = null;
		try {
			String sql = " select * from TruongC3 where matruongc3= ?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tr = new TruongC3(rs.getString("Matruongc3"), rs.getString("TenTruongc3"), rs.getString("Ghichu"),
						rs.getString("MaQuan"), rs.getString("DiaChiTruongc3"), rs.getInt("ChiTieu"),
						rs.getFloat("DiemChuan"));

			}
		} catch (Exception e) {

		}
		return tr;
	}

	public static void insertDataTruongC3(TruongC3 tr) {
		String sql = "insert into TruongC3 values(?,?,?,?,?,?,?)";
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setString(1, tr.getMaTruongC3());
			ps.setString(2, tr.getTenTruongC3());
			ps.setInt(3, tr.getChiTieu());
			ps.setFloat(4, tr.getDiemChuan());
			ps.setString(5, tr.getGhiChu());
			ps.setString(6, tr.getMaQuan());
			ps.setString(7, tr.getDiachiTruongC3());
			ps.execute();
			JOptionPane.showMessageDialog(null, "Thêm  thành công!", "Thông báo", 1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Thêm thất bại", "Thông báo", 2);
		}
	}

	public static boolean updateTruongC3(TruongC3 tr) {
		try {
			ps = ConnectDB.getConnect().prepareStatement("UPDATE TRUONGC3 SET   TENTRUONGC3 = ?,"
					+ "CHITIEU = ?, DIEMCHUAN = ?, GHICHU=?, MAQUAN =?, DIACHITRUONGC3=? where MATRUONGC3 = ?");

			ps.setString(7, tr.getMaTruongC3());
			ps.setString(1, tr.getTenTruongC3());
			ps.setInt(2, tr.getChiTieu());
			ps.setFloat(3, tr.getDiemChuan());
			ps.setString(4, tr.getGhiChu());
			ps.setString(5, tr.getMaQuan());
			ps.setString(6, tr.getDiachiTruongC3());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	public static boolean deleteTruongC3(String maTruong) {
		try {
			ps = ConnectDB.getConnect().prepareStatement("DELETE FROM TRUONGC3 WHERE MATRUONGC3 = ?");
			ps.setString(1, maTruong);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	public static List<TruongC3> getDataTruongC3Cbox(String sql) {
		List<TruongC3> itemC3s = new ArrayList<>();
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				itemC3s.add(new TruongC3(r.getString(1), r.getString(2)));

			}
		} catch (Exception e) {

		}
		return itemC3s;
	}

}
