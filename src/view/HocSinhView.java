package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.HocSinhController;
import dao.HocSinhDAO;
import dao.TruongC2DAO;
import dao.TruongC3DAO;
import model.HocSinh;
import model.TruongC2;
import model.TruongC3;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class HocSinhView extends JFrame {

	private JPanel contentPane;
	private JTextField txt_ghichu;
	private JTable table;
	private DefaultTableModel tablemodel = new DefaultTableModel();
	private JButton btn_add, btn_delete, btn_edit, btn_save;
	private Font f = new Font("Tahoma", Font.PLAIN, 13);
	private String maHS = "";
	private String sbd = "";
	private List<TruongC2> list_TC2;
	private TruongC2[] array_trC2s;
	private JComboBox cb_nv2, cb_nv1, cb_truongc2;
	private JTextField txt_hoten;
	private JTextField txt_mahs;
	private JTextField txt_diachi;
	private JTextField txt_ngaysinh;
	private JTextField txt_diemcong;
	private JTextField txt_sbd;
	private JTextField txt_diemtb;
	private JTextField txt_hocluc;
	private JRadioButton rdio_nam, rdio_nu;
	private JCheckBox checkbox_kchuyen;
	private ButtonGroup bg;

	public HocSinhView() {

		setTitle("Quản lý học sinh");
		setBackground(new Color(0, 64, 0));
		setForeground(new Color(0, 23, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 950, 700);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		HocSinhController controller = new HocSinhController(this);

		txt_ghichu = new JTextField();
		txt_ghichu.setFont(f);
		txt_ghichu.setColumns(10);
		txt_ghichu.setBounds(616, 29, 239, 75);
		contentPane.add(txt_ghichu);

		JLabel lblNewLabel1 = new JLabel("Ghi chú");
		lblNewLabel1.setBounds(544, 29, 46, 14);
		contentPane.add(lblNewLabel1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(100, 574, 623, 54);
		contentPane.add(panel);
		panel.setLayout(null);

		btn_add = new JButton("Thêm");
		btn_add.addActionListener(controller);
		btn_add.setBounds(26, 11, 89, 23);
		panel.add(btn_add);

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
		btn_save.setBounds(496, 11, 89, 23);
		btn_add.setIcon(new ImageIcon(HocSinhView.class.getResource("/image/i_add.jpg")));
		btn_edit.setIcon(new ImageIcon(HocSinhView.class.getResource("/image/i_edit.jpg")));
		btn_delete.setIcon(new ImageIcon(HocSinhView.class.getResource("/image/i_delete.jpg")));
		btn_save.setIcon(new ImageIcon(HocSinhView.class.getResource("/image/i_save.jpg")));
		panel.add(btn_save);
//			
		cb_truongc2 = new JComboBox();
		cb_truongc2.setModel(loadDataToComboxTruongC2());
		cb_truongc2.setBounds(616, 115, 239, 21);
		contentPane.add(cb_truongc2);

		JLabel lblNewLabel12 = new JLabel("Tên Trường cấp 2");
		lblNewLabel12.setBounds(519, 115, 109, 14);
		contentPane.add(lblNewLabel12);

		cb_nv1 = new JComboBox();
		cb_nv1.setModel(loadDataToComboxNguyenVong());
		cb_nv1.setBounds(616, 147, 239, 22);
		contentPane.add(cb_nv1);

		cb_nv2 = new JComboBox();
		cb_nv2.setModel(loadDataToComboxNguyenVong());
		cb_nv2.setBounds(616, 194, 239, 22);
		contentPane.add(cb_nv2);

		JLabel lblNguynVng = new JLabel("Nguyện vọng 1");
		lblNguynVng.setBounds(519, 151, 109, 14);
		contentPane.add(lblNguynVng);

		JLabel lblNewLabel2 = new JLabel("Nguyện vọng 2");
		lblNewLabel2.setBounds(519, 198, 83, 14);
		contentPane.add(lblNewLabel2);

		txt_hoten = new JTextField();
		txt_hoten.setEnabled(false);
		txt_hoten.setColumns(10);
		txt_hoten.setBounds(100, 60, 239, 20);
		contentPane.add(txt_hoten);

		txt_mahs = new JTextField();
		txt_mahs.setEnabled(false);
		txt_mahs.setColumns(10);
		txt_mahs.setBounds(100, 26, 103, 20);
		contentPane.add(txt_mahs);

		JLabel lblNewLabel3 = new JLabel("Mã học sinh ");
		lblNewLabel3.setBounds(33, 26, 73, 14);
		contentPane.add(lblNewLabel3);

		JLabel lblNewLabel4 = new JLabel("Họ tên");
		lblNewLabel4.setBounds(33, 63, 46, 14);
		contentPane.add(lblNewLabel4);

		txt_diachi = new JTextField();
		txt_diachi.setEnabled(false);
		txt_diachi.setColumns(10);
		txt_diachi.setBounds(100, 128, 339, 20);
		contentPane.add(txt_diachi);

		txt_ngaysinh = new JTextField();
		txt_ngaysinh.setEnabled(false);
		txt_ngaysinh.setColumns(10);
		txt_ngaysinh.setBounds(100, 91, 239, 20);
		contentPane.add(txt_ngaysinh);

		JLabel lblNewLabel5 = new JLabel("Ngày sinh");
		lblNewLabel5.setBounds(33, 94, 73, 14);
		contentPane.add(lblNewLabel5);

		JLabel lblNewLabel6 = new JLabel("Địa chỉ");
		lblNewLabel6.setBounds(33, 131, 46, 14);
		contentPane.add(lblNewLabel6);

		txt_diemcong = new JTextField();
		txt_diemcong.setEnabled(false);
		txt_diemcong.setColumns(10);
		txt_diemcong.setBounds(100, 169, 59, 20);
		contentPane.add(txt_diemcong);

		JLabel lblNewLabel7 = new JLabel("Điểm cộng");
		lblNewLabel7.setBounds(33, 172, 73, 14);
		contentPane.add(lblNewLabel7);

		JLabel lblNewLabel8 = new JLabel("Số BD");
		lblNewLabel8.setBounds(230, 29, 73, 14);
		contentPane.add(lblNewLabel8);

		txt_sbd = new JTextField();
		txt_sbd.setEnabled(false);
		txt_sbd.setColumns(10);
		txt_sbd.setBounds(268, 26, 103, 20);
		contentPane.add(txt_sbd);

		JLabel lblNewLabel9 = new JLabel("Điểm TB lớp 9");
		lblNewLabel9.setBounds(169, 172, 91, 14);
		contentPane.add(lblNewLabel9);

		txt_diemtb = new JTextField();
		txt_diemtb.setEnabled(false);
		txt_diemtb.setColumns(10);
		txt_diemtb.setBounds(252, 169, 59, 20);
		contentPane.add(txt_diemtb);

		JLabel lblNewLabel10 = new JLabel("Học lực");
		lblNewLabel10.setBounds(327, 172, 73, 14);
		contentPane.add(lblNewLabel10);

		txt_hocluc = new JTextField();
		txt_hocluc.setEnabled(false);
		txt_hocluc.setColumns(10);
		txt_hocluc.setBounds(380, 169, 59, 20);
		contentPane.add(txt_hocluc);

		rdio_nam = new JRadioButton("Nam");
		rdio_nam.setBackground(SystemColor.activeCaption);
		rdio_nam.setBounds(50, 210, 59, 23);
		contentPane.add(rdio_nam);

		rdio_nu = new JRadioButton("Nữ");
		rdio_nu.setBackground(SystemColor.activeCaption);
		rdio_nu.setBounds(128, 210, 59, 23);
		contentPane.add(rdio_nu);
		bg = new ButtonGroup();
		bg.add(rdio_nam);
		bg.add(rdio_nu);

		String[] colsName = { "MaHS", "SBD", "MaTruongC2", "Hoten", "NgaySinh", "DiaChi", "GioiTinh", "KhoiChuyen",
				"DiemCong", "NV1", "NV2", "DiemHK9", "HL9", "ChuThich" };
		tablemodel.setColumnIdentifiers(colsName);
		ResultSet rs = HocSinhDAO.getDataAllHocSinh("select * from HOCSINH");
		try {
			while (rs.next()) {
				String rows[] = new String[14];
				rows[0] = rs.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)

				rows[1] = rs.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
				rows[2] = rs.getString(3);
				rows[3] = rs.getString(4);
				rows[4] = rs.getString(5);
				rows[5] = rs.getString(6);
				rows[6] = rs.getString(7);
				rows[7] = rs.getString(8);
				rows[8] = rs.getString(9);
				rows[9] = rs.getString(10);
				rows[10] = rs.getString(11);
				rows[11] = rs.getString(12);
				rows[12] = rs.getString(13);
				rows[13] = rs.getString(14);

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
		table.setAutoResizeMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(75);
		table.getColumnModel().getColumn(1).setPreferredWidth(75);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(75);
		table.getColumnModel().getColumn(5).setPreferredWidth(75);
		table.getColumnModel().getColumn(6).setPreferredWidth(75);
		table.getColumnModel().getColumn(7).setPreferredWidth(75);
		table.getColumnModel().getColumn(8).setPreferredWidth(75);
		table.getColumnModel().getColumn(9).setPreferredWidth(75);
		table.getColumnModel().getColumn(10).setPreferredWidth(75);
		table.getColumnModel().getColumn(11).setPreferredWidth(75);
		table.getColumnModel().getColumn(12).setPreferredWidth(75);
		table.getColumnModel().getColumn(13).setPreferredWidth(75);
		table.setRowHeight(25);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		scrollPane.setBounds(58, 279, 777, 271);

		contentPane.add(scrollPane);

		checkbox_kchuyen = new JCheckBox("Khối chuyên");
		checkbox_kchuyen.setBackground(SystemColor.activeCaption);
		checkbox_kchuyen.setBounds(252, 210, 97, 23);
		contentPane.add(checkbox_kchuyen);

		setControl(false);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tablemodel = (DefaultTableModel) table.getModel();
				int i_row = table.getSelectedRow();
				maHS = tablemodel.getValueAt(i_row, 0) + "";
				txt_mahs.setText(tablemodel.getValueAt(i_row, 0) + "");
				txt_sbd.setText(tablemodel.getValueAt(i_row, 1) + "");
				cb_truongc2.setSelectedItem(((TruongC2) cb_truongc2.getSelectedItem()).getTenTruongC2() + "");
				txt_hoten.setText(tablemodel.getValueAt(i_row, 3) + "");
				txt_ngaysinh.setText(tablemodel.getValueAt(i_row, 4) + "");
				txt_diachi.setText(tablemodel.getValueAt(i_row, 5) + "");
				String gioitinh = tablemodel.getValueAt(i_row, 6) + "";
				if (gioitinh.equals("1")) {
					rdio_nu.setSelected(true);

				} else if (gioitinh.equals("0")) {
					rdio_nam.setSelected(true);
				}
				String khoichuyen = tablemodel.getValueAt(i_row, 7) + "";
				if (khoichuyen.equals("1")) {
					checkbox_kchuyen.setSelected(true);

				} else if (khoichuyen.equals("0")) {
					checkbox_kchuyen.setSelected(false);
				}
				txt_diemcong.setText(tablemodel.getValueAt(i_row, 8) + "");
				txt_diemtb.setText(tablemodel.getValueAt(i_row, 11) + "");
				txt_hocluc.setText(tablemodel.getValueAt(i_row, 12) + "");
				txt_ghichu.setText(tablemodel.getValueAt(i_row, 13) + "");
				// "MaHS","SBD","MaTruongC2","Hoten","NgaySinh","DiaChi",
				// "GioiTinh","KhoiChuyen","DiemCong","NV1","NV2","DiemHK9","HL9","ChuThich"
			}
		});
	}

	public void xoaForm() {
		txt_mahs.setText("");
		txt_diachi.setText("");
		txt_diemcong.setText("");
		txt_ghichu.setText("");
		txt_hocluc.setText("");
		txt_hoten.setText("");
		txt_ngaysinh.setText("");
		txt_sbd.setText("");
		cb_nv2.setSelectedIndex(-1);
		cb_nv1.setSelectedIndex(-1);
		cb_truongc2.setSelectedIndex(-1);
		txt_diemtb.setText("");

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DefaultComboBoxModel loadDataToComboxTruongC2() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		List<TruongC2> list = TruongC2DAO.getDataTruongC2Cbox("select matruongc2,tentruongc2 from truongc2");
		for (int i = 0; i < list.size(); i++) {
			model.addElement(list.get(i));
		}
		return model;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DefaultComboBoxModel loadDataToComboxNguyenVong() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		List<TruongC3> list = TruongC3DAO.getDataTruongC3Cbox("select matruongc3,tentruongc3 from truongc3");
		for (int i = 0; i < list.size(); i++) {
			model.addElement(list.get(i));
		}
		return model;
	}

	public void insertDataHocSinh() {
		if (txt_mahs.getText().trim().equals("") || txt_sbd.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập mã học sinh và số báo danh", "Thông báo", 0);
			return;
		} else {
			HocSinh hs1 = HocSinhDAO.getAHocSinh(txt_mahs.getText().trim());
			HocSinh hs2 = HocSinhDAO.getAHocSinhBySBD(txt_sbd.getText().trim());
			if (hs1 == null || hs2 == null) {
				String matruong = ((TruongC2) cb_truongc2.getSelectedItem()).getMaTruongC2() + "";
				System.out.println(matruong);
				Boolean gioitinh = true;
				Boolean khoiChuyen = false;
				if (rdio_nam.isSelected()) {
					gioitinh = false;
				}
				if (checkbox_kchuyen.isSelected()) {
					khoiChuyen = true;
				}

				/*
				 * convert string to java.util.date DateFormat df = new
				 * SimpleDateFormat("MM/dd/yyyy"); Date startDate; String newDateString=""; try
				 * { startDate = (Date) df.parse(txt_ngaysinh.getText().trim()); newDateString =
				 * df.format(startDate); System.out.println(newDateString); } catch
				 * (ParseException e) { e.printStackTrace(); }
				 */
				// convert string to java.sql.date
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date parsed = null;
				try {
					parsed = sdf.parse(txt_ngaysinh.getText().trim());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				java.sql.Date data = new java.sql.Date(parsed.getTime());
				try {
					HocSinh hS = new HocSinh(txt_mahs.getText().trim(), txt_sbd.getText().trim(), matruong,
							txt_hoten.getText().trim(), txt_diachi.getText().trim(),
							((TruongC3) cb_nv1.getSelectedItem()).getMaTruongC3() + "",
							((TruongC3) cb_nv1.getSelectedItem()).getMaTruongC3() + "", txt_hocluc.getText().trim(),
							txt_ghichu.getText().trim(), gioitinh, khoiChuyen,
							Integer.valueOf(txt_diemcong.getText().trim()), Float.valueOf(txt_diemtb.getText().trim()),
							data);
					HocSinhDAO.insertDataHocSinh(hS);
				} catch (Exception e) {
					e.printStackTrace();
				}

				readData();
			}
		}
	}

	public void readData() {
		tablemodel = new DefaultTableModel();
		String[] colsName = { "MaHS", "SBD", "MaTruongC2", "Hoten", "NgaySinh", "DiaChi", "GioiTinh", "KhoiChuyen",
				"DiemCong", "NV1", "NV2", "DiemHK9", "HL9", "ChuThich" };
		tablemodel.setColumnIdentifiers(colsName);
		ResultSet rs = HocSinhDAO.getDataAllHocSinh("select * from HOCSINH");
		try {
			while (rs.next()) {
				String rows[] = new String[14];
				rows[0] = rs.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
				rows[1] = rs.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
				rows[2] = rs.getString(3);
				rows[3] = rs.getString(4);
				rows[4] = rs.getString(5);
				rows[5] = rs.getString(6);
				rows[6] = rs.getString(7);
				rows[7] = rs.getString(8);
				rows[8] = rs.getString(9);
				rows[9] = rs.getString(10);
				rows[10] = rs.getString(11);
				rows[11] = rs.getString(12);
				rows[12] = rs.getString(13);
				rows[13] = rs.getString(14);
				tablemodel.addRow(rows);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		table.setModel(tablemodel);
	}

	public void deleteDataAHocSinh() {
		if (maHS == "") {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn trường cần xóa!", "Thông báo", 1);
		} else {
			int result = JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn xóa trường có  " + maHS + " này");
			if (result == 0) {
				HocSinhDAO.deleteHocSinh(maHS);
				JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", 1);
				readData();
			} else {
				return;
			}
		}
	}

	public void editHocSinh() {
		if (maHS == "") {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn trường cần sửa!", "Thông báo", 1);
		} else {
			String matruong = ((TruongC2) cb_truongc2.getSelectedItem()).getMaTruongC2() + "";
			System.out.println(matruong);
			Boolean gioitinh = true;
			Boolean khoiChuyen = false;
			if (rdio_nam.isSelected()) {
				gioitinh = false;
			}
			if (checkbox_kchuyen.isSelected()) {
				khoiChuyen = true;
			}

			// convert string to java.sql.date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
			Date parsed = null;
			try {
				parsed = sdf.parse(txt_ngaysinh.getText().trim());
				// parsed = sdf1.parse(txt_ngaysinh.getText().trim());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			java.sql.Date data = new java.sql.Date(parsed.getTime());
			try {
				HocSinh hS = new HocSinh(txt_mahs.getText().trim(), txt_sbd.getText().trim(), matruong,
						txt_hoten.getText().trim(), txt_diachi.getText().trim(),
						((TruongC3) cb_nv1.getSelectedItem()).getMaTruongC3() + "",
						((TruongC3) cb_nv1.getSelectedItem()).getMaTruongC3() + "", txt_hocluc.getText().trim(),
						txt_ghichu.getText().trim(), gioitinh, khoiChuyen,
						Integer.valueOf(txt_diemcong.getText().trim()), Float.valueOf(txt_diemtb.getText().trim()),
						data);
				if (HocSinhDAO.updateHocSinh(hS)) {
					JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", 1);
				} else {
					JOptionPane.showMessageDialog(null, "Sửa thất bại", "Thông báo", 0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			readData();
		}

	}

	public void setControl(boolean b) {
		txt_ghichu.setEnabled(b);
		txt_mahs.setEnabled(b);
		txt_diachi.setEnabled(b);
		txt_diemcong.setEnabled(b);
		txt_ghichu.setEnabled(b);
		txt_hocluc.setEnabled(b);
		txt_hoten.setEnabled(b);
		txt_ngaysinh.setEnabled(b);
		txt_sbd.setEnabled(b);
		txt_diemtb.setEnabled(b);

		btn_add.setEnabled(!b);
		btn_edit.setEnabled(!b);
		btn_delete.setEnabled(!b);
		btn_save.setEnabled(b);

	}

	public void enableTextMa(boolean b) {

		txt_sbd.setEnabled(b);
		txt_mahs.setEnabled(b);
	}

}
