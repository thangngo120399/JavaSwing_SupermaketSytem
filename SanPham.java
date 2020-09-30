package jvswing;

public class SanPham {
	private String maSP;
	private String tenSP;
	private String loai;
	private int soLuong;
	private int donGia;
	public SanPham(String maSP, String tenSP,String loai, int soLuong, int donGia) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.loai = loai;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public SanPham() {
		super();
	}
}	
