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

import controller.QuanController;
import controller.TruongC2Controller;
import dao.QuanDAO;
import dao.TruongC2DAO;
import model.Quan;
import model.TruongC2;

public class QuanView extends JFrame {

	private JPanel contentPane;
	private JTextField txt_maQuan;
	private JTextField txt_tenQuan;
	private JTextField txt_khuvuc;
	private JTable table;
	private DefaultTableModel tablemodel = new DefaultTableModel();
	private JButton btn_add, btn_delete, btn_edit, btn_save;
	private Font f = new Font("Tahoma", Font.PLAIN, 13);
	private String maTruong = "";
	private String tenQuan = "";

	public QuanView() {
		setTitle("Quản lý Quận");
		setBackground(new Color(0, 64, 0));
		setForeground(new Color(0, 23, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 734, 440);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		QuanController controller = new QuanController(this);
		JLabel lblNewLabel = new JLabel("Mã Quận");
		lblNewLabel.setBounds(25, 29, 74, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên Quận");
		lblNewLabel_1.setBounds(25, 69, 63, 14);
		contentPane.add(lblNewLabel_1);

		txt_maQuan = new JTextField();
		txt_maQuan.setBounds(109, 26, 86, 20);
		contentPane.add(txt_maQuan);
		txt_maQuan.setColumns(10);

		txt_tenQuan = new JTextField();
		txt_tenQuan.setColumns(10);
		txt_tenQuan.setBounds(109, 66, 213, 20);
		contentPane.add(txt_tenQuan);

		JLabel lblNewLabel_2 = new JLabel("Địa chỉ");
		lblNewLabel_2.setBounds(374, 32, 46, 14);
		contentPane.add(lblNewLabel_2);

		txt_khuvuc = new JTextField();
		txt_khuvuc.setColumns(10);
		txt_khuvuc.setBounds(441, 29, 239, 20);
		contentPane.add(txt_khuvuc);

		String[] colsName = { "Mã Quận", "Tên Quận", "Khu vực" };
		tablemodel.setColumnIdentifiers(colsName);
		ResultSet rs = QuanDAO.getDataQuan("select * from quan");
		try {
			while (rs.next()) {
				String rows[] = new String[3];
				rows[0] = rs.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
				rows[1] = rs.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
				rows[2] = rs.getString(3);
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
		scrollPane.setBounds(44, 109, 626, 172);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(47, 321, 623, 54);
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
		btn_add.setIcon(new ImageIcon(QuanView.class.getResource("/image/i_add.jpg")));
		btn_edit.setIcon(new ImageIcon(QuanView.class.getResource("/image/i_edit.jpg")));
		btn_delete.setIcon(new ImageIcon(QuanView.class.getResource("/image/i_delete.jpg")));
		btn_save.setIcon(new ImageIcon(QuanView.class.getResource("/image/i_save.jpg")));
		panel.add(btn_save);
		setControl(false);
		this.setVisible(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tablemodel = (DefaultTableModel) table.getModel();
				int i_row = table.getSelectedRow();
				maTruong = tablemodel.getValueAt(i_row, 0) + "";
				tenQuan = tablemodel.getValueAt(i_row, 1) + "";
				txt_maQuan.setText(tablemodel.getValueAt(i_row, 0) + "");
				txt_tenQuan.setText(tablemodel.getValueAt(i_row, 1) + "");
				txt_khuvuc.setText(tablemodel.getValueAt(i_row, 2) + "");

			}
		});
	}

	public void xoaForm() {
		txt_maQuan.setText("");
		txt_tenQuan.setText("");
		txt_khuvuc.setText("");
	}

	public void insertDataQuan() {
		String ma = txt_maQuan.getText().trim();

		if (ma.equals("") || txt_tenQuan.getText().trim().equals("")) {

			JOptionPane.showMessageDialog(null, "Chưa nhập mã Quận", "Thông báo", 1);
			return;
		} else {
			if (QuanDAO.getAQuan(txt_maQuan.getText().trim()) == null) {
				QuanDAO.insertDataQuan(new Quan(txt_maQuan.getText().trim(), txt_tenQuan.getText().trim(),
						txt_khuvuc.getText().trim()));
				readData();
			} else {
				JOptionPane.showMessageDialog(null, "Mã trường này đã tồn tại!", "Thông báo", 1);
			}
		}

	}

	public void readData() {
		tablemodel = new DefaultTableModel();
		String[] colsName = { "Mã Quận", "Tên Quận", "Khu vực" };
		tablemodel.setColumnIdentifiers(colsName);
		ResultSet rs = QuanDAO.getDataQuan("select * from quan");
		try {
			while (rs.next()) {
				String rows[] = new String[3];
				rows[0] = rs.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
				rows[1] = rs.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
				rows[2] = rs.getString(3);
				tablemodel.addRow(rows);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(tablemodel);

	}

	public void deleteDataQuan() {
		if (maTruong == "") {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn trường cần xóa!", "Thông báo", 1);
		} else {
			int result = JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn xóa  " + tenQuan + " này");
			if (result == 0) {
				if (QuanDAO.deleteQuan(maTruong)) {
					JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", 1);
				} else {
					JOptionPane.showMessageDialog(null, "Xóa thất bại!", "Thông báo", 1);
				}

				readData();
			} else {
				return;
			}
		}
	}

	public void editQuan() {
		if (maTruong == "") {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn trường cần xóa!", "Thông báo", 1);
		} else {

			if (QuanDAO.UpdateQuan(
					new Quan(txt_maQuan.getText().trim(), txt_tenQuan.getText().trim(), txt_khuvuc.getText().trim()))) {
				JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", 1);
			} else {
				JOptionPane.showMessageDialog(null, "Sửa thất bại!", "Thông báo", 1);
			}
			readData();
		}

	}

	public void setControl(boolean b) {
		txt_maQuan.setEnabled(b);
		txt_tenQuan.setEnabled(b);
		txt_khuvuc.setEnabled(b);

		btn_add.setEnabled(!b);
		btn_edit.setEnabled(!b);
		btn_delete.setEnabled(!b);
		btn_save.setEnabled(b);

	}

	public void enableTextMa(boolean b) {

		txt_maQuan.setEnabled(b);
	}
}
