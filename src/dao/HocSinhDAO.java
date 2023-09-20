package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JOptionPane;

import model.HocSinh;

public class HocSinhDAO {
	public static PreparedStatement ps;
	public static ResultSet rs;
	public static List<HocSinh> listHS;

	public static ResultSet getDataAllHocSinh(String sql) {
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			return ps.executeQuery();
		} catch (Exception e) {
			return null;
		}
	}

	public static HocSinh getAHocSinh(String ma) {
		HocSinh hs = null;
		try {
			String sql = " select * from HocSinh where MaHS= ?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				hs = new HocSinh(rs.getString("MaHS"), rs.getString("SBD"), rs.getString("MaTruongC2"),
						rs.getString("Hoten"), rs.getString("DiaChi"), rs.getString("NV1"), rs.getString("NV2"),
						rs.getString("HL9"), rs.getString("ChuThich"), rs.getBoolean("gioitinh"),
						rs.getBoolean("KhoiChuyen"), rs.getInt("DiemCong"), rs.getFloat("DiemHK9"),
						rs.getDate("NgaySinh"));
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return hs;
	}

	public static HocSinh getAHocSinh(String ma, String sbd) {
		HocSinh hs = null;
		try {
			String sql = " select * from HocSinh where MaHS= ? and sbd=?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setString(1, ma);
			ps.setString(2, sbd);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				hs = new HocSinh(rs.getString("MaHS"), rs.getString("SBD"), rs.getString("MaTruongC2"),
						rs.getString("Hoten"), rs.getString("DiaChi"), rs.getString("NV1"), rs.getString("NV2"),
						rs.getString("HL9"), rs.getString("ChuThich"), rs.getBoolean("gioitinh"),
						rs.getBoolean("KhoiChuyen"), rs.getInt("DiemCong"), rs.getFloat("DiemHK9"),
						rs.getDate("NgaySinh"));
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return hs;
	}

	public static HocSinh getAHocSinhBySBD(String sbd) {
		HocSinh hs = null;
		try {
			String sql = " select * from HocSinh where sbd= ?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setString(1, sbd);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				hs = new HocSinh(rs.getString("MaHS"), rs.getString("SBD"), rs.getString("MaTruongC2"),
						rs.getString("Hoten"), rs.getString("DiaChi"), rs.getString("NV1"), rs.getString("NV2"),
						rs.getString("HL9"), rs.getString("ChuThich"), rs.getBoolean("gioitinh"),
						rs.getBoolean("KhoiChuyen"), rs.getInt("DiemCong"), rs.getFloat("DiemHK9"),
						rs.getDate("NgaySinh"));
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return hs;
	}

	public static void insertDataHocSinh(HocSinh hs) {
		String sql = "insert into HocSinh values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setString(1, hs.getMaHS());
			ps.setString(2, hs.getsBD());
			ps.setString(3, hs.getMaTruongC2());
			ps.setString(4, hs.getHoten());
			ps.setDate(5, hs.getNgaySinh());
			ps.setString(6, hs.getDiaChi());
			ps.setBoolean(7, hs.isGioiTinh());
			ps.setBoolean(8, hs.isKhoiChuyen());
			ps.setInt(9, hs.getDiemCong());
			ps.setString(10, hs.getNvong1());
			ps.setString(11, hs.getNvong2());
			ps.setFloat(12, hs.getDiemHK9());
			ps.setString(13, hs.getHocLuc());
			ps.setString(14, hs.getChuThich());
			ps.execute();
			JOptionPane.showMessageDialog(null, "Thêm  thành công!", "Thông báo", 1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Thêm thất bại", "Thông báo", 2);
		}
	}

	public static boolean updateHocSinh(HocSinh hs) {
		try {
			ps = ConnectDB.getConnect()
					.prepareStatement("update HocSinh set SBD=?, MaTruongC2=?, Hoten= ?, NgaySinh= ?, DiaChi=?,"
							+ " GioiTinh= ?, KhoiChuyen= ?, DiemCong= ?, NV1= ?, NV2= ?, DiemHK9=?,HL9=?,ChuThich =? where MaHS=?");

			ps.setString(14, hs.getMaHS());
			ps.setString(1, hs.getsBD());
			ps.setString(2, hs.getMaTruongC2());
			ps.setString(3, hs.getHoten());
			ps.setDate(4, hs.getNgaySinh());
			ps.setString(5, hs.getDiaChi());
			ps.setBoolean(6, hs.isGioiTinh());
			ps.setBoolean(7, hs.isKhoiChuyen());
			ps.setInt(8, hs.getDiemCong());
			ps.setString(9, hs.getNvong1());
			ps.setString(10, hs.getNvong2());
			ps.setFloat(11, hs.getDiemHK9());
			ps.setString(12, hs.getHocLuc());
			ps.setString(13, hs.getChuThich());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean deleteHocSinh(String maHS) {
		try {
			ps = ConnectDB.getConnect().prepareStatement("DELETE FROM HOCSINH WHERE MAHS = ?");
			ps.setString(1, maHS);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {
		HocSinhDAO.getAHocSinh("HS001");
		System.out.println(HocSinhDAO.getAHocSinh("HS001"));

	}
}
