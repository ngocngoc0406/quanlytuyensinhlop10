package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import view.TruongC2View;

public class TruongC2Controller implements Action {
	private TruongC2View view;
	private boolean modeNew;

	public TruongC2Controller(TruongC2View v) {
		this.view = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		// JOptionPane.showMessageDialog(view, "Bạn vừa nhấn vào: "+cm);
		if (cm.equals("Thêm")) {
			this.view.xoaForm();
			this.view.setControl(true);
			modeNew = true;
		} else if (cm.equals("Lưu")) {
			if (modeNew) {
				this.view.insertDataTruongC2();

			} else {

				this.view.editTruongC2();
			}

			this.view.setControl(false);

		} else if (cm.equals("Xóa")) {
			this.view.deleteDataTruongC2();
			this.view.setControl(false);
		} else if (cm.equals("Sửa")) {

			this.view.setControl(true);
			this.view.enableTextMa(false);

			modeNew = false;
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
