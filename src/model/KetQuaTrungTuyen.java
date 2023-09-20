package model;

public class KetQuaTrungTuyen extends KetQuaThiTuyen {

	private String maHS, tinhtrangDau;
	private float diemXT;

	public String getMaHS() {
		return maHS;
	}

	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}

	public void setDiemXT(float diemXT) {
		this.diemXT = diemXT;
	}

	public KetQuaTrungTuyen() {

	}

	public KetQuaTrungTuyen(String maHS, String sBD, String maHS2, String tinhtrangDau, float diemXT) {
		super(maHS, sBD);
		maHS = maHS2;
		this.tinhtrangDau = tinhtrangDau;
		this.diemXT = diemXT;
	}

	public KetQuaTrungTuyen(String maHS, String tinhtrangDau, float diemXT) {

		this.maHS = maHS;
		this.tinhtrangDau = tinhtrangDau;
		this.diemXT = diemXT;
	}

	public String getTinhtrangDau() {
		return tinhtrangDau;
	}

	public void setTinhtrangDau(String tinhtrangDau) {
		this.tinhtrangDau = tinhtrangDau;
	}

	public float getDiemXT() {
		return diemXT;
	}

	public void setDiemXT() {
		this.diemXT = this.getDiemCong() + this.getTongDiemThi();
	}

	@Override
	public String toString() {
		return "KetQuaTrungTuyen [maHS=" + maHS + ", tinhtrangDau=" + tinhtrangDau + ", diemXT=" + diemXT + "]";
	}

}
