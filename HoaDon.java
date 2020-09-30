package jvswing;

public class HoaDon {
	private String maHD;
	private String maKH;
	private String maNV;
	private String maSP;
	private int soLuongMua;
	private int  donGia;
	private int thanhGia;
	private String ngayban;

	public HoaDon(String maHD,String maKH, String maNV, String maSP, int soLuongMua, int donGia, int thanhGia, String ngayban) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		this.maNV = maNV;
		this.maSP = maSP;
		this.soLuongMua = soLuongMua;
		this.donGia = donGia;
		this.thanhGia = thanhGia;
		this.ngayban = ngayban;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getNgayban() {
		return ngayban;
	}
	public void setNgayban(String ngayban) {
		this.ngayban = ngayban;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public int getSoLuongMua() {
		return soLuongMua;
	}
	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}

	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public int getThanhGia() {
		return thanhGia;
	}
	public void setThanhGia(int thanhGia) {
		this.thanhGia = thanhGia;
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
