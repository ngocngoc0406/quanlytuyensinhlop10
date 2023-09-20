package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.KetQuaTrungTuyen;

public class KetQuaTrungTuyenDAO {
	public static PreparedStatement ps;
	public static ResultSet rs;

	public static ResultSet getAllHSDaThi(String sql) {
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			return ps.executeQuery();
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public static void insertKetquaTrungTuyen(KetQuaTrungTuyen kq) {
		String sql = "insert into Ketquatrungtuyen values(?,?,?)";
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			System.out.println(kq.getMaHS());
			System.out.println(kq.getDiemXT());

			System.out.println(kq.getTinhtrangDau());

			ps.setString(1, kq.getMaHS());
			ps.setFloat(2, kq.getDiemXT());
			ps.setString(3, kq.getTinhtrangDau());
			ps.execute();
			JOptionPane.showMessageDialog(null, "Thêm  thành công!", "Thông báo", 1);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Thêm thất bại", "Thông báo", 2);
		}
	}

	public static void updatetKetquaTrungTuyen(KetQuaTrungTuyen kq) {
		String sql = "update Ketquatrungtuyen set DiemXT=?, Tinhtrangdau=? where mahs=?";
		try {
			ps = ConnectDB.getConnect().prepareStatement(sql);
			System.out.println(kq.getMaHS());
			System.out.println(kq.getDiemXT());

			System.out.println(kq.getTinhtrangDau());

			ps.setString(3, kq.getMaHS());
			ps.setFloat(1, kq.getDiemXT());
			ps.setString(2, kq.getTinhtrangDau());
			ps.execute();

		} catch (Exception e) {
			System.err.println(e.getMessage());

		}
	}

}
