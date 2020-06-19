package beans;

public class SinhVien {
	private int maSV;
	private String tenSV;
	private String lop;
	
	public SinhVien() {
		
	}

	public SinhVien(int maSV, String tenSV, String lop) {
		super();
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.lop = lop;
	}

	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String toString() {
		return "Mã SV: " + this.maSV + " - Tên SV: " + this.tenSV + " - Lớp: " + this.lop;
	}
	
	
}
