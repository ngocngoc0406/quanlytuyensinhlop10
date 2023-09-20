package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import view.Mainview;

public class MainController implements Action {

	private Mainview Mainview;

	public MainController(Mainview v) {
		this.Mainview = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String cm = e.getActionCommand();

		if (cm.equals("Quản lý học sinh")) {
			this.Mainview.loadFormSV();

		} else if (cm.equals("Quản Trường Cấp 3")) {
			this.Mainview.loadFormQLC3();

		} else if (cm.equals("Quản lý Trường Cấp 2")) {
			this.Mainview.loadFormQLC2();

		} else if (cm.equals("Quản lý Quận")) {
			this.Mainview.loadFormQLQuan();
		} else if (cm.equals("Quản lý thi cử")) {
			this.Mainview.loadFormQLThicu();
		}
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

}
