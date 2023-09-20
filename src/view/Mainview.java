package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MainController;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Mainview extends JFrame {

	private JPanel contentPane;

	public Mainview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Quản lí tuyển sinh vào lớp 10");
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		MainController controller = new MainController(this);

		JButton btn_qlyhs = new JButton("Quản lý học sinh");
		btn_qlyhs.setBounds(30, 72, 280, 80);
		btn_qlyhs.addActionListener(controller);
		btn_qlyhs.setIcon(new ImageIcon(Mainview.class.getResource("/image/img1_1.jpg")));
		contentPane.add(btn_qlyhs);

		JButton btn_qlyTruongC3 = new JButton("Quản Trường Cấp 3");
		btn_qlyTruongC3.setBounds(350, 72, 280, 80);
		btn_qlyTruongC3.addActionListener(controller);
		btn_qlyTruongC3.setBackground(new Color(100,100,124));
		btn_qlyTruongC3.setIcon(new ImageIcon(Mainview.class.getResource("/image/img2.jpg")));
		contentPane.add(btn_qlyTruongC3);

		JButton btn_qlyTruongC2 = new JButton("Quản lý Trường Cấp 2");
		btn_qlyTruongC2.setBounds(220, 300, 280, 80);
		btn_qlyTruongC2.addActionListener(controller);
		btn_qlyTruongC2.setIcon(new ImageIcon(Mainview.class.getResource("/image/img3.png")));
		contentPane.add(btn_qlyTruongC2);

		JButton btn_qlyQuan = new JButton("Quản lý Quận");
		btn_qlyQuan.setBounds(30, 170, 280, 80);
		btn_qlyQuan.addActionListener(controller);
		btn_qlyQuan.setIcon(new ImageIcon(Mainview.class.getResource("/image/img4.jpg")));
		contentPane.add(btn_qlyQuan);

		JButton btn_qlythicu = new JButton("Quản lý thi cử");
		btn_qlythicu.setBounds(350, 170, 280,80);
		btn_qlythicu.addActionListener(controller);
		btn_qlythicu.setIcon(new ImageIcon(Mainview.class.getResource("/image/img5.jpg")));
		contentPane.add(btn_qlythicu);
		this.setVisible(true);
	}

	public void loadFormSV() {
		HocSinhView v = new HocSinhView();
		v.setLocationRelativeTo(null);
		v.setVisible(true);

	}

	public void loadFormQLC3() {
		TruongC3View c3View = new TruongC3View();
		c3View.setLocationRelativeTo(null);

	}

	public void loadFormQLC2() {
		TruongC2View c2View = new TruongC2View();
		c2View.setLocationRelativeTo(null);

	}

	public void loadFormQLQuan() {
		QuanView quanView = new QuanView();
		quanView.setLocationRelativeTo(null);

	}

	public void loadFormQLThicu() {
		KetQuaThiTuyenView ketQuaThiTuyenView = new KetQuaThiTuyenView();
		ketQuaThiTuyenView.setLocationRelativeTo(null);

	}

}
