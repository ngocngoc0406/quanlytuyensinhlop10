package model;

import java.sql.Date;
import java.util.Objects;

public class HocSinh {
	private String maTruongC2, hoten, diaChi, nvong1, nvong2, hocLuc, chuThich;
	private boolean gioiTinh, khoiChuyen;
	protected String maHS, sBD;

	public HocSinh(String maHS, String sBD) {

		this.maHS = maHS;
		this.sBD = sBD;
	}

	private int diemCong;
	private float diemHK9;

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	private Date ngaySinh;

	public String getMaHS() {
		return maHS;
	}

	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}

	public String getsBD() {
		return sBD;
	}

	public void setsBD(String sBD) {
		this.sBD = sBD;
	}

	public String getMaTruongC2() {
		return maTruongC2;
	}

	public void setMaTruongC2(String maTruongC2) {
		this.maTruongC2 = maTruongC2;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getNvong1() {
		return nvong1;
	}

	public void setNvong1(String nvong1) {
		this.nvong1 = nvong1;
	}

	public String getNvong2() {
		return nvong2;
	}

	public void setNvong2(String nvong2) {
		this.nvong2 = nvong2;
	}

	public String getHocLuc() {
		return hocLuc;
	}

	public void setHocLuc(String hocLuc) {
		this.hocLuc = hocLuc;
	}

	public String getChuThich() {
		return chuThich;
	}

	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public boolean isKhoiChuyen() {
		return khoiChuyen;
	}

	public void setKhoiChuyen(boolean khoiChuyen) {
		this.khoiChuyen = khoiChuyen;
	}

	public int getDiemCong() {
		return diemCong;
	}

	public void setDiemCong(int diemCong) {
		this.diemCong = diemCong;
	}

	public float getDiemHK9() {
		return diemHK9;
	}

	public void setDiemHK9(float diemHK9) {
		this.diemHK9 = diemHK9;
	}

//public LocalDateTime getNgaySinh() {
//	return ngaySinh;
//}
//public void setNgaySinh(LocalDateTime ngaySinh) {
//	this.ngaySinh = ngaySinh;
//}
	public HocSinh() {
	}

//
//public HocSinh(String maHS, String sBD, String maTruongC2, String hoten, String diaChi, String nvong1, String nvong2,
//		String hocLuc, String chuThich, boolean gioiTinh, boolean khoiChuyen, int diemCong, float diemHK9,
//		LocalDateTime ngaySinh) {
//	this.maHS = maHS;
//	this.sBD = sBD;
//	this.maTruongC2 = maTruongC2;
//	this.hoten = hoten;
//	this.diaChi = diaChi;
//	this.nvong1 = nvong1;
//	this.nvong2 = nvong2;
//	this.hocLuc = hocLuc;
//	this.chuThich = chuThich;
//	this.gioiTinh = gioiTinh;
//	this.khoiChuyen = khoiChuyen;
//	this.diemCong = diemCong;
//	this.diemHK9 = diemHK9;
//	this.ngaySinh = ngaySinh;
//}
	@Override
	public String toString() {
		return "HocSinh [maHS=" + maHS + ", sBD=" + sBD + ", maTruongC2=" + maTruongC2 + ", hoten=" + hoten
				+ ", diaChi=" + diaChi + ", nvong1=" + nvong1 + ", nvong2=" + nvong2 + ", hocLuc=" + hocLuc
				+ ", chuThich=" + chuThich + ", gioiTinh=" + gioiTinh + ", khoiChuyen=" + khoiChuyen + ", diemCong="
				+ diemCong + ", diemHK9=" + diemHK9 + ", ngaySinh=" + ngaySinh + "]";
	}

	public HocSinh(String maHS, String sBD, String maTruongC2, String hoten, String diaChi, String nvong1,
			String nvong2, String hocLuc, String chuThich, boolean gioiTinh, boolean khoiChuyen, int diemCong,
			float diemHK9, Date ngaySinh) {
		this.maHS = maHS;
		this.sBD = sBD;
		this.maTruongC2 = maTruongC2;
		this.hoten = hoten;
		this.diaChi = diaChi;
		this.nvong1 = nvong1;
		this.nvong2 = nvong2;
		this.hocLuc = hocLuc;
		this.chuThich = chuThich;
		this.gioiTinh = gioiTinh;
		this.khoiChuyen = khoiChuyen;
		this.diemCong = diemCong;
		this.diemHK9 = diemHK9;
		this.ngaySinh = ngaySinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	@Override
	public int hashCode() {
		return Objects.hash(diemHK9, maHS, sBD);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HocSinh other = (HocSinh) obj;
		return Float.floatToIntBits(diemHK9) == Float.floatToIntBits(other.diemHK9) && Objects.equals(maHS, other.maHS)
				&& Objects.equals(sBD, other.sBD);
	}

}
