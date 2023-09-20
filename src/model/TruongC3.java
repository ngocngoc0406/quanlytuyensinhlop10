package model;

import java.util.Objects;

public class TruongC3 {
	private String maTruongC3, tenTruongC3, ghiChu, maQuan, diachiTruongC3;
	private int chiTieu;
	private float diemChuan;

	public TruongC3(String maTruongC3, String tenTruongC3) {
		super();
		this.maTruongC3 = maTruongC3;
		this.tenTruongC3 = tenTruongC3;
	}

	public String getMaTruongC3() {
		return maTruongC3;
	}

	public void setMaTruongC3(String maTruongC3) {
		this.maTruongC3 = maTruongC3;
	}

	public String getTenTruongC3() {
		return tenTruongC3;
	}

	public void setTenTruongC3(String tenTruongC3) {
		this.tenTruongC3 = tenTruongC3;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getMaQuan() {
		return maQuan;
	}

	public void setMaQuan(String maQuan) {
		this.maQuan = maQuan;
	}

	public String getDiachiTruongC3() {
		return diachiTruongC3;
	}

	public void setDiachiTruongC3(String diachiTruongC3) {
		this.diachiTruongC3 = diachiTruongC3;
	}

	public int getChiTieu() {
		return chiTieu;
	}

	public void setChiTieu(int chiTieu) {
		this.chiTieu = chiTieu;
	}

	public float getDiemChuan() {
		return diemChuan;
	}

	public void setDiemChuan(float diemChuan) {
		this.diemChuan = diemChuan;
	}

	public TruongC3() {

	}

	public TruongC3(String maTruongC3, String tenTruongC3, String ghiChu, String maQuan, String diachiTruongC3,
			int chiTieu, float diemChuan) {

		this.maTruongC3 = maTruongC3;
		this.tenTruongC3 = tenTruongC3;
		this.ghiChu = ghiChu;
		this.maQuan = maQuan;
		this.diachiTruongC3 = diachiTruongC3;
		this.chiTieu = chiTieu;
		this.diemChuan = diemChuan;
	}

	@Override
	public String toString() {
		return tenTruongC3;
	}

	@Override
	public int hashCode() {
		return Objects.hash(diemChuan, maTruongC3);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TruongC3 other = (TruongC3) obj;
		return Float.floatToIntBits(diemChuan) == Float.floatToIntBits(other.diemChuan)
				&& Objects.equals(maTruongC3, other.maTruongC3);
	}

}