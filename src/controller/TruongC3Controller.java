package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import view.TruongC3View;

public class TruongC3Controller implements Action {
	private TruongC3View view;
	private boolean modeNew;

	public TruongC3Controller(TruongC3View v) {
		this.view = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();

		if (cm.equals("Thêm")) {
			this.view.xoaForm();
			this.view.setControl(true);
			modeNew = true;
		} else if (cm.equals("Lưu")) {
			if (modeNew) {
				this.view.insertDataTruongC3();
			} else {
				this.view.editTruongC3();
			}
			this.view.setControl(false);

		} else if (cm.equals("Xóa")) {
			this.view.deleteDataTruongC3();
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
