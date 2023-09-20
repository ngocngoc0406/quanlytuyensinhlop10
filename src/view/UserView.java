package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.UserController;
import dao.UserDAO;

public class UserView extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;
	private JTextField txt_password;
	private JLabel lblMtKhu;
	private JButton btn_login;

	public UserView() {
		setTitle("Đăng nhập");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setLayout(null);
		UserController controller = new UserController(this);
		JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		lblNewLabel.setBounds(55, 30, 79, 14);
		contentPane.add(lblNewLabel);

		txt_username = new JTextField();
		txt_username.setBounds(156, 27, 138, 20);
		contentPane.add(txt_username);
		txt_username.setColumns(10);

		txt_password = new JPasswordField();
		txt_password.setBounds(156, 77, 138, 20);
		contentPane.add(txt_password);

		lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setBounds(78, 80, 79, 14);
		contentPane.add(lblMtKhu);

		btn_login = new JButton("Đăng nhập");
		btn_login.addActionListener(controller);
		btn_login.setIcon(new ImageIcon(UserView.class.getResource("/image/i_login.jpg")));
		
		btn_login.setBounds(156, 133, 120, 23);
		contentPane.add(btn_login);
		this.setVisible(true);
	}

	public void login() {
		String a = "";
		if (UserDAO.login(txt_username.getText().trim(), txt_password.getText().trim())) {
			JOptionPane.showMessageDialog(null, "Đăng nhập thành công", "Thông báo", 1);
			this.setVisible(false);
			Mainview vMainview = new Mainview();
			vMainview.setLocationRelativeTo(null);
		} else {
			JOptionPane.showMessageDialog(null, "Tên Tài khoan hoặc mật khẩu không chính xác", "Thông báo", 1);
		}

	}
}
