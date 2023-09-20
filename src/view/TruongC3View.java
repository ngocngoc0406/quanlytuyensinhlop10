package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
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

import controller.TruongC3Controller;
import dao.QuanDAO;
import dao.TruongC2DAO;
import dao.TruongC3DAO;
import model.Quan;
import model.TruongC2;
import model.TruongC3;

import javax.swing.JComboBox;
import javax.swing.ScrollPaneConstants;

public class TruongC3View extends JFrame {

	private JPanel contentPane;
	private JTextField txt_matruongc3;
	private JTextField txt_tentruongc3;
	private JTextField txt_diachitruongc3;
	private JTextField txt_chitieu;
	private JTable table;
	private DefaultTableModel tablemodel = new DefaultTableModel();
	private JButton btn_add, btn_delete, btn_edit, btn_save;
	private Font f = new Font("Tahoma", Font.PLAIN, 13);
	private String maTruong = "";
	private String tenTruong = "";
	private JComboBox cb_quan;
	private JTextField txt_ghichu;
	private JTextField txt_diemChuan;

	public TruongC3View() {
		setTitle("Quản lý trường cấp 3");
		setBackground(new Color(0, 64, 0));
		setForeground(new Color(0, 23, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new JPanel();

		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		TruongC3Controller controller = new TruongC3Controller(this);
		JLabel lblNewLabel = new JLabel("Mã trường");
		lblNewLabel.setBounds(25, 29, 74, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel1 = new JLabel("Tên Trường");
		lblNewLabel1.setBounds(25, 117, 63, 14);
		contentPane.add(lblNewLabel1);

		txt_matruongc3 = new JTextField();
		txt_matruongc3.setBounds(119, 26, 86, 20);
		contentPane.add(txt_matruongc3);
		txt_matruongc3.setColumns(10);

		txt_tentruongc3 = new JTextField();
		txt_tentruongc3.setColumns(10);
		txt_tentruongc3.setBounds(119, 114, 213, 20);
		contentPane.add(txt_tentruongc3);

		JLabel lblNewLabel_2 = new JLabel("Địa chỉ");
		lblNewLabel_2.setBounds(374, 32, 46, 14);
		contentPane.add(lblNewLabel_2);

		txt_diachitruongc3 = new JTextField();
		txt_diachitruongc3.setColumns(10);
		txt_diachitruongc3.setBounds(441, 29, 294, 20);
		contentPane.add(txt_diachitruongc3);

		txt_chitieu = new JTextField();
		txt_chitieu.setColumns(10);
		txt_chitieu.setBounds(441, 66, 86, 20);
		contentPane.add(txt_chitieu);

		JLabel lblNewLabel_3 = new JLabel("Chỉ tiêu");
		lblNewLabel_3.setBounds(374, 69, 46, 14);
		contentPane.add(lblNewLabel_3);

		String[] colsName = { "MaTruongC3", "TenTruongC3", "ChiTieu", "DiemChuan", "GhiChu", "MaQuan",
				"DiaChiTruongC3" };
		tablemodel.setColumnIdentifiers(colsName);
		ResultSet rs = TruongC3DAO.getDataTruongC3("select * from truongc3");
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

		table.setRowHeight(25);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(25, 174, 798, 209);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(105, 419, 623, 54);
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
		btn_add.setIcon(new ImageIcon(TruongC3View.class.getResource("/image/i_add.jpg")));
		btn_edit.setIcon(new ImageIcon(TruongC3View.class.getResource("/image/i_edit.jpg")));
		btn_delete.setIcon(new ImageIcon(TruongC3View.class.getResource("/image/i_delete.jpg")));
		btn_save.setIcon(new ImageIcon(TruongC3View.class.getResource("/image/i_save.jpg")));
		panel.add(btn_save);

		cb_quan = new JComboBox();
		cb_quan.setModel(loadDataToComboxQuan());
		cb_quan.setBounds(119, 65, 152, 22);

		contentPane.add(cb_quan);

		JLabel lblNewLabel_1 = new JLabel("Quận");
		lblNewLabel_1.setBounds(25, 69, 63, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel3 = new JLabel("Ghi chú");
		lblNewLabel3.setBounds(374, 117, 46, 14);
		contentPane.add(lblNewLabel3);

		txt_ghichu = new JTextField();
		txt_ghichu.setEnabled(false);
		txt_ghichu.setColumns(10);
		txt_ghichu.setBounds(441, 114, 294, 20);
		contentPane.add(txt_ghichu);

		JLabel lblNewLabel4 = new JLabel("Điểm Chuẩn");
		lblNewLabel4.setBounds(558, 69, 86, 14);
		contentPane.add(lblNewLabel4);

		txt_diemChuan = new JTextField();
		txt_diemChuan.setEnabled(false);
		txt_diemChuan.setColumns(10);
		txt_diemChuan.setBounds(649, 66, 86, 20);
		contentPane.add(txt_diemChuan);
		setControl(false);
		this.setVisible(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tablemodel = (DefaultTableModel) table.getModel();
				// "MaTruongC3","TenTruongC3","ChiTieu","DiemChuan","GhiChu","MaQuan",
				// "DiaChiTruongC3"
				int i_row = table.getSelectedRow();
				maTruong = tablemodel.getValueAt(i_row, 0) + "";
				tenTruong = tablemodel.getValueAt(i_row, 1) + "";
				txt_matruongc3.setText(tablemodel.getValueAt(i_row, 0) + "");
				txt_tentruongc3.setText(tablemodel.getValueAt(i_row, 1) + "");
				txt_chitieu.setText(tablemodel.getValueAt(i_row, 2) + "");
				txt_diemChuan.setText(tablemodel.getValueAt(i_row, 3) + "");
				txt_ghichu.setText(tablemodel.getValueAt(i_row, 4) + "");
				txt_diachitruongc3.setText(tablemodel.getValueAt(i_row, 6) + "");
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DefaultComboBoxModel loadDataToComboxQuan() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		List<Quan> list = QuanDAO.getDataQuanCbox("Select * from Quan");
		for (int i = 0; i < list.size(); i++) {
			model.addElement(list.get(i));
		}
		return model;
	}

	public void xoaForm() {
		txt_matruongc3.setText("");
		txt_tentruongc3.setText("");
		txt_diachitruongc3.setText("");
		txt_chitieu.setText("");
		txt_diemChuan.setText("");
		txt_ghichu.setText("");

	}

	public void insertDataTruongC3() {
		String ma = txt_matruongc3.getText().trim();

		if (ma.equals("") || txt_tentruongc3.getText().trim().equals("")) {

			JOptionPane.showMessageDialog(null, "Chưa nhập mã trường và tên trường", "Thông báo", 2);
			return;
		} else {
			if (TruongC3DAO.getATruongC3(txt_matruongc3.getText().trim()) == null) {

				try {
					String maQuan = ((Quan) cb_quan.getSelectedItem()).getMaQuan() + "";
					TruongC3DAO.insertDataTruongC3(new TruongC3(txt_matruongc3.getText().trim(),
							txt_tentruongc3.getText().trim(), txt_ghichu.getText().trim(), maQuan,
							txt_diachitruongc3.getText().trim(), Integer.valueOf(txt_chitieu.getText().trim()),
							Float.valueOf(txt_diemChuan.getText().trim())));
				} catch (NumberFormatException e) {

					e.printStackTrace();
				}
				readData();
			} else {
				JOptionPane.showMessageDialog(null, "Mã trường này đã tồn tại!", "Thông báo", 1);
			}
		}

	}

	public void editTruongC3() {
		if (maTruong == "") {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn trường cần xóa!", "Thông báo", 1);
		} else {
			try {
				String maQuan = ((Quan) cb_quan.getSelectedItem()).getMaQuan() + "";
				Boolean boolean1 = TruongC3DAO.updateTruongC3(new TruongC3(txt_matruongc3.getText().trim(),
						txt_tentruongc3.getText().trim(), txt_ghichu.getText().trim(), maQuan,
						txt_diachitruongc3.getText().trim(), Integer.valueOf(txt_chitieu.getText().trim()),
						Float.valueOf(txt_diemChuan.getText().trim())));
				if (boolean1) {
					JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", 1);
				} else {
					JOptionPane.showMessageDialog(null, "Sửa thất bại", "Thông báo", 0);
				}
				readData();
			} catch (NumberFormatException e) {

				e.printStackTrace();
			}
		}

	}

	public void readData() {
		tablemodel = new DefaultTableModel();
		String[] colsName = { "MaTruongC3", "TenTruongC3", "ChiTieu", "DiemChuan", "GhiChu", "MaQuan",
				"DiaChiTruongC3" };
		tablemodel.setColumnIdentifiers(colsName);
		ResultSet rs = TruongC3DAO.getDataTruongC3("select * from truongc3");
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

	public void deleteDataTruongC3() {
		if (maTruong == "") {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn trường cần xóa!", "Thông báo", 1);
		} else {
			int result = JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn xóa trường " + tenTruong + " này");
			if (result == 0) {
				if (TruongC3DAO.deleteTruongC3(maTruong)) {
					JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", 1);
				} else {
					JOptionPane.showMessageDialog(null, "Xóa thất bại!", "Thông báo", 0);
				}

				readData();
			} else {
				return;
			}
		}
	}

	public void setControl(boolean b) {
		txt_matruongc3.setEnabled(b);
		txt_tentruongc3.setEnabled(b);
		txt_diachitruongc3.setEnabled(b);
		txt_chitieu.setEnabled(b);
		txt_ghichu.setEnabled(b);
		txt_diemChuan.setEnabled(b);

		btn_add.setEnabled(!b);
		btn_edit.setEnabled(!b);
		btn_delete.setEnabled(!b);
		btn_save.setEnabled(b);

	}

	public void enableTextMa(boolean b) {

		txt_matruongc3.setEnabled(b);
	}
}
