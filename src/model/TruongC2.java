package model;

import java.util.Objects;

public class TruongC2 {
	private String maTruongC2, tenTruongC2, diachiTruongC2, ghiChu;

	public String getMaTruongC2() {
		return maTruongC2;
	}

	public void setMaTruongC2(String maTruongC2) {
		this.maTruongC2 = maTruongC2;
	}

	public String getTenTruongC2() {
		return tenTruongC2;
	}

	public void setTenTruongC2(String tenTruongC2) {
		this.tenTruongC2 = tenTruongC2;
	}

	public String getDiachiTruongC2() {
		return diachiTruongC2;
	}

	public void setDiachiTruongC2(String diachiTruongC2) {
		this.diachiTruongC2 = diachiTruongC2;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public TruongC2(String maTruongC2, String tenTruongC2, String diachiTruongC2, String ghiChu) {
		super();
		this.maTruongC2 = maTruongC2;
		this.tenTruongC2 = tenTruongC2;
		this.diachiTruongC2 = diachiTruongC2;
		this.ghiChu = ghiChu;
	}

	public TruongC2() {

	}

	public TruongC2(String maTruongC2, String tenTruongC2) {

		this.maTruongC2 = maTruongC2;
		this.tenTruongC2 = tenTruongC2;
	}

	@Override
	public String toString() {
		return tenTruongC2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTruongC2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TruongC2 other = (TruongC2) obj;
		return Objects.equals(maTruongC2, other.maTruongC2);
	}

}
