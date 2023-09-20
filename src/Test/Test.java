package Test;

import javax.swing.UIManager;

import view.UserView;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new UserView().setLocationRelativeTo(null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
