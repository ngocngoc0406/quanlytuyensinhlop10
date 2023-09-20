package view;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.KetQuaThiTuyenDAO;
import dao.KetQuaTrungTuyenDAO;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;

public class DanhSachTrungTuyenView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tablemodel = new DefaultTableModel();

	public DanhSachTrungTuyenView() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setTitle("Danh sách trúng tuyển");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		String[] colsName = { "MaHS", "Hoten", "MaTruongC3", "TenTruongC3", "DiemChuanTruong", "DiemXT",
				"Tình Trạng Đậu" };
		tablemodel.setColumnIdentifiers(colsName);
		String sql_listHsdathi = "select hs.MaHS, Hoten,MaTruongC3,TenTruongC3,DiemChuan, DiemXT, TinhTrangDau as DiemXT "
				+ "from HocSinh hs join TruongC3  t3 on t3.MaTruongC3=hs.NV1 or t3.MaTruongC3=hs.NV2 join KetquaThiTuyen "
				+ "kqtt on kqtt.MaHS= hs.MaHS join KetQuaTrungTuyen trungtuyen on trungtuyen.MaHS= hs.MaHS order by MaHS";
		ResultSet rs = KetQuaTrungTuyenDAO.getAllHSDaThi(sql_listHsdathi);
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

		table.setModel(tablemodel);

		table.setRowHeight(25);

		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setBounds(31, 24, 699, 410);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		contentPane.add(scrollPane);
		this.setVisible(true);

	}
}
