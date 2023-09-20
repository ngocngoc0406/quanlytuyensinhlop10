package model;

import java.util.Objects;

public class Quan {
	private String maQuan, tenQuan, khuVuc;

	public String getMaQuan() {
		return maQuan;
	}

	public void setMaQuan(String maQuan) {
		this.maQuan = maQuan;
	}

	public String getTenQuan() {
		return tenQuan;
	}

	public void setTenQuan(String tenQuan) {
		this.tenQuan = tenQuan;
	}

	public String getKhuVuc() {
		return khuVuc;
	}

	public void setKhuVuc(String khuVuc) {
		this.khuVuc = khuVuc;
	}

	@Override
	public String toString() {
		return tenQuan;
	}

	public Quan(String maQuan, String tenQuan) {
		super();
		this.maQuan = maQuan;
		this.tenQuan = tenQuan;
	}

	public Quan(String maQuan, String tenQuan, String khuVuc) {

		this.maQuan = maQuan;
		this.tenQuan = tenQuan;
		this.khuVuc = khuVuc;
	}

	public Quan() {

	}

	@Override
	public int hashCode() {
		return Objects.hash(maQuan, tenQuan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quan other = (Quan) obj;
		return Objects.equals(maQuan, other.maQuan) && Objects.equals(tenQuan, other.tenQuan);
	}

}
