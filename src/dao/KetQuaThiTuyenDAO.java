package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JOptionPane;

import model.KetQuaThiTuyen;

public class KetQuaThiTuyenDAO {
	public static PreparedStatement ps;
	public static ResultSet rs;
	public static List<KetQuaThiTuyen> listKQTT;

	public static ResultSet getDataAllKQTT(String sql) {
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			return ps.executeQuery();
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public static KetQuaThiTuyen getAKQTT(String ma) {
		KetQuaThiTuyen kqtt = null;
		try {
			String sql = " select * from Ketquathituyen where MaHS= ?";
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setString(1, ma);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				kqtt = new KetQuaThiTuyen(rs.getString("MaHS"), rs.getString("SBD"), rs.getFloat("DiemToan"),
						rs.getFloat("DiemVan"), rs.getFloat("DiemAnh"), rs.getFloat("DiemMonTC"),
						rs.getFloat("DiemTong"));
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return kqtt;
	}

	public static void insertKQTT(KetQuaThiTuyen hs) {
		String sql = "insert into KetQuaThiTuyen values(?,?,?,?,?,?,?)";
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			ps.setString(1, hs.getMaHS());
			ps.setString(2, hs.getsBD());
			ps.setFloat(3, hs.getDiemToan());
			ps.setFloat(4, hs.getDiemVan());
			ps.setFloat(5, hs.getDiemAnh());
			ps.setFloat(6, hs.getDiemMonTC());
			ps.setFloat(7, hs.getTongDiemThi());

			ps.execute();
			JOptionPane.showMessageDialog(null, "Thêm  thành công!", "Thông báo", 1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Thêm thất bại", "Thông báo", 2);
		}
	}

	public static boolean updateKQTT(KetQuaThiTuyen hs) {
		try {
			ps = ConnectDB.getConnect().prepareStatement(
					"update KetquaThituyen set SBD=?,diemtoan=?,diemvan=?,diemanh=?, diemmontc=?,diemtong=? where MaHS=?");

			ps.setString(7, hs.getMaHS());
			ps.setString(1, hs.getsBD());
			ps.setFloat(2, hs.getDiemToan());
			ps.setFloat(3, hs.getDiemVan());
			ps.setFloat(4, hs.getDiemAnh());
			ps.setFloat(5, hs.getDiemMonTC());
			ps.setFloat(6, hs.getTongDiemThi());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean deleteKQTT(String maHS) {
		try {
			ps = ConnectDB.getConnect().prepareStatement("DELETE FROM KetquaThiTuyen WHERE MAHS = ?");
			ps.setString(1, maHS);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			return false;
		}
	}
}
