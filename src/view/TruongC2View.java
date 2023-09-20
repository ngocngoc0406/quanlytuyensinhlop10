package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.TruongC2Controller;
import dao.TruongC2DAO;
import model.TruongC2;
import java.awt.SystemColor;

public class TruongC2View extends JFrame {

	private JPanel contentPane;
	private JTextField txt_matruongc2;
	private JTextField txt_tentruongc2;
	private JTextField txt_diachitruongc2;
	private JTextField txt_ghichu;
	private JTable table;
	private DefaultTableModel tablemodel = new DefaultTableModel();
	private JButton btn_add, btn_delete, btn_edit, btn_save;
	private Font f = new Font("Tahoma", Font.PLAIN, 13);
	private String maTruong = "";
	private String tenTruong = "";

	public TruongC2View() {
		setTitle("Quản lý trường cấp 2");
		setBackground(new Color(0, 64, 0));
		setForeground(new Color(0, 23, 255));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 734, 440);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		TruongC2Controller controller = new TruongC2Controller(this);
		JLabel lblNewLabel = new JLabel("Mã trường");
		lblNewLabel.setBounds(25, 29, 74, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên Trường");
		lblNewLabel_1.setBounds(25, 69, 63, 14);
		contentPane.add(lblNewLabel_1);

		txt_matruongc2 = new JTextField();
		txt_matruongc2.setBounds(109, 26, 86, 20);
		contentPane.add(txt_matruongc2);
		txt_matruongc2.setColumns(10);

		txt_tentruongc2 = new JTextField();
		txt_tentruongc2.setColumns(10);
		txt_tentruongc2.setBounds(109, 66, 213, 20);
		contentPane.add(txt_tentruongc2);

		JLabel lblNewLabel_2 = new JLabel("Địa chỉ");
		lblNewLabel_2.setBounds(374, 32, 46, 14);
		contentPane.add(lblNewLabel_2);

		txt_diachitruongc2 = new JTextField();
		txt_diachitruongc2.setColumns(10);
		txt_diachitruongc2.setBounds(441, 29, 239, 20);
		contentPane.add(txt_diachitruongc2);

		txt_ghichu = new JTextField();
		txt_ghichu.setColumns(10);
		txt_ghichu.setBounds(441, 66, 239, 20);
		contentPane.add(txt_ghichu);

		JLabel lblNewLabel_3 = new JLabel("Ghi chú");
		lblNewLabel_3.setBounds(374, 69, 46, 14);
		contentPane.add(lblNewLabel_3);

		String[] colsName = { "Mã trường", "Tên Trường", "Địa Chi", "Ghi chú" };
		tablemodel.setColumnIdentifiers(colsName);
		ResultSet rs = TruongC2DAO.getDataTruongC2("select * from truongc2");
		try {
			while (rs.next()) {
				String rows[] = new String[4];
				rows[0] = rs.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
				rows[1] = rs.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
				rows[2] = rs.getString(3);
				rows[3] = rs.getString(4);
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
		btn_add.setIcon(new ImageIcon(TruongC2View.class.getResource("/image/i_add.jpg")));
		btn_add.setIcon(new ImageIcon(TruongC2View.class.getResource("/image/i_add.jpg")));
		btn_edit.setIcon(new ImageIcon(TruongC2View.class.getResource("/image/i_edit.jpg")));
		btn_delete.setIcon(new ImageIcon(TruongC2View.class.getResource("/image/i_delete.jpg")));
		btn_save.setIcon(new ImageIcon(TruongC2View.class.getResource("/image/i_save.jpg")));
		panel.add(btn_save);
		setControl(false);
		this.setVisible(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tablemodel = (DefaultTableModel) table.getModel();
				int i_row = table.getSelectedRow();
				maTruong = tablemodel.getValueAt(i_row, 0) + "";
				tenTruong = tablemodel.getValueAt(i_row, 1) + "";
				txt_matruongc2.setText(tablemodel.getValueAt(i_row, 0) + "");
				txt_tentruongc2.setText(tablemodel.getValueAt(i_row, 1) + "");
				txt_diachitruongc2.setText(tablemodel.getValueAt(i_row, 2) + "");
				txt_ghichu.setText(tablemodel.getValueAt(i_row, 3) + "");
			}
		});
	}

	public void xoaForm() {
		txt_matruongc2.setText("");
		txt_tentruongc2.setText("");
		txt_diachitruongc2.setText("");
		txt_ghichu.setText("");

	}

	public void insertDataTruongC2() {
		String ma = txt_matruongc2.getText().trim();

		if (ma.equals("") || txt_tentruongc2.getText().trim().equals("")) {

			JOptionPane.showMessageDialog(null, "Chưa nhập mã trường và tên trường", "Thông báo", 1);
			return;
		} else {
			if (TruongC2DAO.getATruongC2(txt_matruongc2.getText().trim()) == null) {
				TruongC2DAO.insertDataTruongC2(
						new TruongC2(txt_matruongc2.getText().trim(), txt_tentruongc2.getText().trim(),
								txt_diachitruongc2.getText().trim(), txt_ghichu.getText().trim()));
				readData();
			} else {
				JOptionPane.showMessageDialog(null, "Mã trường này đã tồn tại!", "Thông báo", 1);
			}
		}

	}

	public void readData() {
		tablemodel = new DefaultTableModel();
		String[] colsName = { "Mã trường", "Tên Trường", "Địa Chi", "Ghi chú" };
		tablemodel.setColumnIdentifiers(colsName);
		ResultSet rs = TruongC2DAO.getDataTruongC2("select * from truongc2");
		try {
			while (rs.next()) {
				String rows[] = new String[4];
				rows[0] = rs.getString(1); // lấy dữ liệu tại cột số 1 (ứng với mã hàng)
				rows[1] = rs.getString(2); // lấy dữ liệu tai cột số 2 ứng với tên hàng
				rows[2] = rs.getString(3);
				rows[3] = rs.getString(4);
				tablemodel.addRow(rows);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setModel(tablemodel);

	}

	public void deleteDataTruongC2() {
		if (maTruong == "") {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn trường cần xóa!", "Thông báo", 1);
		} else {
			int result = JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn xóa trường " + tenTruong + " này");
			if (result == 0) {
				TruongC2DAO.deleteTruongC2(maTruong);
				JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", 1);
				readData();
			} else {
				return;
			}
		}
	}

	public void editTruongC2() {
		if (maTruong == "") {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn trường cần xóa!", "Thông báo", 1);
		} else {
			TruongC2DAO.UpdateTruongC2(new TruongC2(maTruong, txt_tentruongc2.getText().trim(),
					txt_diachitruongc2.getText().trim(), txt_ghichu.getText().trim()));
			readData();
		}

	}

	public void setControl(boolean b) {
		txt_matruongc2.setEnabled(b);
		txt_tentruongc2.setEnabled(b);
		txt_diachitruongc2.setEnabled(b);
		txt_ghichu.setEnabled(b);

		btn_add.setEnabled(!b);
		btn_edit.setEnabled(!b);
		btn_delete.setEnabled(!b);
		btn_save.setEnabled(b);

	}

	public void enableTextMa(boolean b) {

		txt_matruongc2.setEnabled(b);
	}

}
