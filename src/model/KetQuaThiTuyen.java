package model;

import java.util.Objects;

public class KetQuaThiTuyen extends HocSinh {

	private float diemToan, diemVan, diemAnh, diemMonTC, tongDiemThi;

	public KetQuaThiTuyen(String maHS, String sBD, float diemToan, float diemVan, float diemAnh, float diemMonTC,
			float tongDiemThi) {
		super(maHS, sBD);
		this.diemToan = diemToan;
		this.diemVan = diemVan;
		this.diemAnh = diemAnh;
		this.diemMonTC = diemMonTC;
		this.tongDiemThi = tongDiemThi;
	}

	public float getDiemToan() {
		return diemToan;
	}

	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}

	public float getDiemVan() {
		return diemVan;
	}

	public void setDiemVan(float diemVan) {
		this.diemVan = diemVan;
	}

	public float getDiemAnh() {
		return diemAnh;
	}

	public void setDiemAnh(float diemAnh) {
		this.diemAnh = diemAnh;
	}

	public float getDiemMonTC() {
		return diemMonTC;
	}

	public void setDiemMonTC(float diemMonTC) {
		this.diemMonTC = diemMonTC;
	}

	public float getTongDiemThi() {
		return diemToan + diemAnh + diemVan + diemMonTC;
	}

	public void setTongDiemThi() {
		this.tongDiemThi = this.diemToan + this.diemAnh + this.diemVan + this.diemMonTC;
	}

	public KetQuaThiTuyen(String maHS, String sBD, float diemToan, float diemVan, float diemAnh, float diemMonTC) {
		super(maHS, sBD);
		this.diemToan = diemToan;
		this.diemVan = diemVan;
		this.diemAnh = diemAnh;
		this.diemMonTC = diemMonTC;
	}

	public KetQuaThiTuyen(String maHS, String sBD) {
		super(maHS, sBD);
	}

	@Override
	public String toString() {
		return "KetQuaThiTuyen [diemToan=" + diemToan + ", diemVan=" + diemVan + ", diemAnh=" + diemAnh + ", diemMonTC="
				+ diemMonTC + ", tongDiemThi=" + tongDiemThi + "]";
	}

	public KetQuaThiTuyen() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(diemAnh, diemMonTC, diemToan, diemVan);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		KetQuaThiTuyen other = (KetQuaThiTuyen) obj;
		return Float.floatToIntBits(diemAnh) == Float.floatToIntBits(other.diemAnh)
				&& Float.floatToIntBits(diemMonTC) == Float.floatToIntBits(other.diemMonTC)
				&& Float.floatToIntBits(diemToan) == Float.floatToIntBits(other.diemToan)
				&& Float.floatToIntBits(diemVan) == Float.floatToIntBits(other.diemVan);
	}

	public static void main(String[] args) {
		KetQuaThiTuyen quaThiTuyen = new KetQuaThiTuyen();
		quaThiTuyen.setMaHS("1");
		quaThiTuyen.setsBD("1");
		quaThiTuyen.setDiemAnh(6);
		quaThiTuyen.setDiemVan(7);
		quaThiTuyen.setDiemMonTC(7);
		quaThiTuyen.setDiemMonTC(6);
		quaThiTuyen.setTongDiemThi();

		System.out.println(quaThiTuyen.toString());
	}

}
