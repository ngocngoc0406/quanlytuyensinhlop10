package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import view.KetQuaThiTuyenView;

public class KetQuaThiTuyenController implements Action {
	private KetQuaThiTuyenView view;
	private boolean modeNew;

	public KetQuaThiTuyenController(KetQuaThiTuyenView v) {
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
				this.view.insertKQTT();

			} else {

				this.view.editKQTT();
			}

			this.view.setControl(false);

		} else if (cm.equals("Danh sách Trúng Tuyển")) {
			this.view.loadDSTrungTuyen();

		} else if (cm.equals("Xóa")) {
			this.view.deleteDataKQTT();
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
