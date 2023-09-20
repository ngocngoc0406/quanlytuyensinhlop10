package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.KetQuaThiTuyenController;
import dao.HocSinhDAO;
import dao.KetQuaThiTuyenDAO;
import dao.KetQuaTrungTuyenDAO;
import dao.TruongC3DAO;
import model.HocSinh;
import model.KetQuaThiTuyen;
import model.KetQuaTrungTuyen;
import model.TruongC3;

public class KetQuaThiTuyenView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tablemodel = new DefaultTableModel();
	private JButton btn_add, btn_delete, btn_edit, btn_save, btn_dstt;
	private Font f = new Font("Tahoma", Font.PLAIN, 13);
	private String maHS = "";
	private String sbd = "";
	private JTextField txt_diemtoan;
	private JTextField txt_mahs;
	private JTextField txt_diemanh;
	private JTextField txt_diemvan;
	private JTextField txt_diemmontc;
	private JTextField txt_sbd;
	private JTextField txt_diemtong;

	public KetQuaThiTuyenView() {
		setTitle("Quản lý thi tuyển");
		setBackground(new Color(0, 64, 0));
		setForeground(new Color(0, 23, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 826, 629);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		KetQuaThiTuyenController controller = new KetQuaThiTuyenController(this);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(10, 500, 790, 54);
		contentPane.add(panel);
		panel.setLayout(null);

		btn_add = new JButton("Thêm");
		btn_add.addActionListener(controller);
		btn_add.setBounds(26, 11, 89, 23);
		panel.add(btn_add);

		btn_dstt = new JButton("Danh sách Trúng Tuyển");
		btn_dstt.addActionListener(controller);
		btn_dstt.setBounds(600, 11, 175, 23);
		panel.add(btn_dstt);

		btn_edit = new JButton("Sửa");
		btn_edit.addActionListener(controller);
		btn_edit.setBounds(171, 11, 89, 23);
		panel.add(btn_edit);

		btn_delete = new JButton("Xóa");
		btn_delete.addActionListener(controller);
		btn_delete.setBounds(316, 11, 89, 23);
		panel.add(btn_delete);

		btn_save = new JButton("Lưu");
		btn_save.addActionListener(controller);
		btn_save.setBounds(450, 11, 89, 23);
		btn_add.setIcon(new ImageIcon(KetQuaThiTuyenView.class.getResource("/image/i_add.jpg")));
		btn_edit.setIcon(new ImageIcon(KetQuaThiTuyenView.class.getResource("/image/i_edit.jpg")));
		btn_delete.setIcon(new ImageIcon(KetQuaThiTuyenView.class.getResource("/image/i_delete.jpg")));
		btn_save.setIcon(new ImageIcon(KetQuaThiTuyenView.class.getResource("/image/i_save.jpg")));
		panel.add(btn_save);

		txt_diemtoan = new JTextField();
		txt_diemtoan.setEnabled(false);
		txt_diemtoan.setColumns(10);
		txt_diemtoan.setBounds(344, 71, 239, 20);
		contentPane.add(txt_diemtoan);

		txt_mahs = new JTextField();
		txt_mahs.setEnabled(false);
		txt_mahs.setColumns(10);
		txt_mahs.setBounds(344, 37, 103, 20);
		contentPane.add(txt_mahs);

		JLabel lblNewLabel3 = new JLabel("Mã học sinh ");
		lblNewLabel3.setBounds(261, 43, 73, 14);
		contentPane.add(lblNewLabel3);

		JLabel lblNewLabel4 = new JLabel("Điểm toán");
		lblNewLabel4.setBounds(261, 77, 73, 14);
		contentPane.add(lblNewLabel4);

		txt_diemanh = new JTextField();
		txt_diemanh.setEnabled(false);
		txt_diemanh.setColumns(10);
		txt_diemanh.setBounds(344, 139, 239, 20);
		contentPane.add(txt_diemanh);

		txt_diemvan = new JTextField();
		txt_diemvan.setEnabled(false);
		txt_diemvan.setColumns(10);
		txt_diemvan.setBounds(344, 102, 239, 20);
		contentPane.add(txt_diemvan);

		JLabel lblNewLabel5 = new JLabel("Điểm văn");
		lblNewLabel5.setBounds(261, 108, 73, 14);
		contentPane.add(lblNewLabel5);

		JLabel lblNewLabel6 = new JLabel("Điểm Anh");
		lblNewLabel6.setBounds(261, 145, 73, 14);
		contentPane.add(lblNewLabel6);

		txt_diemmontc = new JTextField();
		txt_diemmontc.setEnabled(false);
		txt_diemmontc.setColumns(10);
		txt_diemmontc.setBounds(344, 180, 59, 20);
		contentPane.add(txt_diemmontc);

		JLabel lblNewLabel7 = new JLabel("Điểm môn TC");
		lblNewLabel7.setBounds(255, 183, 91, 14);
		contentPane.add(lblNewLabel7);

		JLabel lblNewLabel8 = new JLabel("Số BD");
		lblNewLabel8.setBounds(474, 40, 73, 14);
		contentPane.add(lblNewLabel8);

		txt_sbd = new JTextField();
		txt_sbd.setEnabled(false);
		txt_sbd.setColumns(10);
		txt_sbd.setBounds(512, 37, 103, 20);
		contentPane.add(txt_sbd);

		JLabel lblNewLabel9 = new JLabel("Điêm Tổng");
		lblNewLabel9.setBounds(413, 183, 91, 14);
		contentPane.add(lblNewLabel9);

		txt_diemtong = new JTextField();
		txt_diemtong.setEnabled(false);
		txt_diemtong.setColumns(10);
		txt_diemtong.setBounds(496, 180, 59, 20);
		txt_diemtong.setEnabled(false);
		contentPane.add(txt_diemtong);

		String[] colsName = { "MaHS", "SBD", "DiemToan", "DiemVan", "DiemAnh", "DiemMonTC", "DiemTong" };
		tablemodel.setColumnIdentifiers(colsName);
		ResultSet rs = KetQuaThiTuyenDAO.getDataAllKQTT("Select * from ketquathituyen");
		try {
			while (rs.next()) {
				String rows[] = new String[7];
				rows[0] = rs.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)

				rows[1] = rs.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
				rows[2] = rs.getString(3);
				rows[3] = rs.getString(4);
				rows[4] = rs.getString(5);
				rows[5] = rs.getString(6);
				rows[6] = rs.getString(7);
				tablemodel.addRow(rows);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table = new JTable();
		table.setBounds(76, 199, 512, -71);
		table = new JTable();
		table.setFont(f);

		table.setModel(tablemodel);
//			table.getColumnModel().getColumn(0).setPreferredWidth(300);

		table.setRowHeight(25);

		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setBounds(72, 229, 651, 271);

		contentPane.add(scrollPane);

		setControl(false);
		this.setVisible(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tablemodel = (DefaultTableModel) table.getModel();
				int i_row = table.getSelectedRow();
				sbd = tablemodel.getValueAt(i_row, 1) + "";
				maHS = tablemodel.getValueAt(i_row, 0) + "";
				txt_mahs.setText(tablemodel.getValueAt(i_row, 0) + "");
				txt_sbd.setText(tablemodel.getValueAt(i_row, 1) + "");
				txt_diemtoan.setText(tablemodel.getValueAt(i_row, 2) + "");
				txt_diemvan.setText(tablemodel.getValueAt(i_row, 3) + "");
				txt_diemanh.setText(tablemodel.getValueAt(i_row, 4) + "");
				txt_diemmontc.setText(tablemodel.getValueAt(i_row, 5) + "");
				txt_diemtong.setText(tablemodel.getValueAt(i_row, 6) + "");

			}
		});
	}

	public void xoaForm() {
		txt_mahs.setText("");
		txt_diemanh.setText("");
		txt_diemmontc.setText("");
		txt_diemtoan.setText("");
		txt_diemvan.setText("");
		txt_sbd.setText("");
		txt_diemtong.setText("");

	}

	public void readData() {
		tablemodel = new DefaultTableModel();
		String[] colsName = { "MaHS", "SBD", "DiemToan", "DiemVan", "DiemAnh", "DiemMonTC", "DiemTong" };
		tablemodel.setColumnIdentifiers(colsName);
		ResultSet rs = KetQuaThiTuyenDAO.getDataAllKQTT("Select * from ketquathituyen");
		try {
			while (rs.next()) {
				String rows[] = new String[7];
				rows[0] = rs.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
				rows[1] = rs.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
				rows[2] = rs.getString(3);
				rows[3] = rs.getString(4);
				rows[4] = rs.getString(5);
				rows[5] = rs.getString(6);
				rows[6] = rs.getString(7);
				tablemodel.addRow(rows);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(tablemodel);
	}

	public void setControl(boolean b) {
		txt_mahs.setEnabled(b);
		txt_diemanh.setEnabled(b);
		txt_diemmontc.setEnabled(b);
		txt_diemtoan.setEnabled(b);
		txt_diemvan.setEnabled(b);
		txt_sbd.setEnabled(b);
		// txt_diemtong.setEnabled(b);
		btn_add.setEnabled(!b);
		btn_edit.setEnabled(!b);
		btn_delete.setEnabled(!b);
		btn_save.setEnabled(b);

	}

	public void enableTextMa(boolean b) {
		txt_sbd.setEnabled(b);
		txt_mahs.setEnabled(b);
	}

	public void insertKQTT() {

		if (txt_mahs.getText().trim().equals("") || txt_sbd.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin đầy đủ", "Thông báo", 1);
			return;
		} else if (HocSinhDAO.getAHocSinh(txt_mahs.getText().trim(), txt_sbd.getText().trim()) == null) {
			JOptionPane.showMessageDialog(null, "Học sinh không có trong hệ thống", "Thông báo", 1);

		} else {
			try {
				KetQuaThiTuyen kq = new KetQuaThiTuyen(txt_mahs.getText().trim(), txt_sbd.getText().trim(),
						Float.valueOf(txt_diemtoan.getText().trim()), Float.valueOf(txt_diemvan.getText().trim()),
						Float.valueOf(txt_diemanh.getText().trim()), Float.valueOf(txt_diemmontc.getText().trim()));
				kq.setTongDiemThi();
				// System.out.print(kq.getTongDiemThi());

				HocSinh hSinh = HocSinhDAO.getAHocSinh(txt_mahs.getText().trim());
				TruongC3 tr3_nv1 = TruongC3DAO.getATruongC3(hSinh.getNvong1());
				TruongC3 tr3_nv2 = TruongC3DAO.getATruongC3(hSinh.getNvong2());
				float diemxt = hSinh.getDiemCong() + kq.getTongDiemThi();
				String isDau = "";
				if (diemxt > tr3_nv1.getDiemChuan() || diemxt > tr3_nv2.getDiemChuan()) {
					isDau = "Đậu";
				} else {
					isDau = "Không đậu";
				}
				KetQuaTrungTuyen ketQuaTrungTuyen = new KetQuaTrungTuyen(kq.getMaHS(), isDau, diemxt);
				System.out.println(ketQuaTrungTuyen);

				KetQuaThiTuyenDAO.insertKQTT(kq);
				System.out.println(ketQuaTrungTuyen.getMaHS());

				KetQuaTrungTuyenDAO.insertKetquaTrungTuyen(ketQuaTrungTuyen);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		readData();
	}

	public void editKQTT() {
		if (maHS.equals("") || sbd.equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn chọn hàng cần sửa", "Thông báo", 1);
		} else {
			try {
				KetQuaThiTuyen kq = new KetQuaThiTuyen(txt_mahs.getText().trim(), txt_sbd.getText().trim(),
						Float.valueOf(txt_diemtoan.getText().trim()), Float.valueOf(txt_diemvan.getText().trim()),
						Float.valueOf(txt_diemanh.getText().trim()), Float.valueOf(txt_diemmontc.getText().trim()));
				kq.setTongDiemThi();
				// System.out.print(kq.getTongDiemThi());

				HocSinh hSinh = HocSinhDAO.getAHocSinh(maHS);
				TruongC3 tr3_nv1 = TruongC3DAO.getATruongC3(hSinh.getNvong1());
				TruongC3 tr3_nv2 = TruongC3DAO.getATruongC3(hSinh.getNvong2());
				float diemxt = hSinh.getDiemCong() + kq.getTongDiemThi();
				String isDau = "";
				if (diemxt > tr3_nv1.getDiemChuan() || diemxt > tr3_nv2.getDiemChuan()) {
					isDau = "Đậu";
				} else {
					isDau = "Không đậu";
				}
				KetQuaTrungTuyen ketQuaTrungTuyen = new KetQuaTrungTuyen(kq.getMaHS(), isDau, diemxt);
				System.out.println(ketQuaTrungTuyen);

				if (KetQuaThiTuyenDAO.updateKQTT(kq)) {
					KetQuaTrungTuyenDAO.updatetKetquaTrungTuyen(ketQuaTrungTuyen);
					JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", 1);
				} else {
					JOptionPane.showMessageDialog(null, "Sửa thất bại", "Thông báo", 1);
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		readData();
	}

	public void deleteDataKQTT() {
		if (maHS.equals("") || sbd.equals("")) {
			JOptionPane.showMessageDialog(null, "Bạn chọn hàng cần sửa", "Thông báo", 1);
		} else {
			int result = JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn xóa trường có  " + maHS + " này");
			if (result == 0) {
				if (KetQuaThiTuyenDAO.deleteKQTT(maHS)) {
					JOptionPane.showMessageDialog(null, "Xóa thành công", "Thông báo", 1);
				} else {
					JOptionPane.showMessageDialog(null, "Xóa không  thành công", "Thông báo", 0);
				}
			} else {
				return;
			}
		}
		readData();

	}

	public void loadDSTrungTuyen() {
		DanhSachTrungTuyenView v = new DanhSachTrungTuyenView();

	}

}
