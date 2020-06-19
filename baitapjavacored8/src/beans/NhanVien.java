package beans;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private String diaChi;
	private int cbql;

	public NhanVien() {

	}

	public NhanVien(String maNV, String tenNV, String diaChi, int cbql) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.diaChi = diaChi;
		this.cbql = cbql;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getCbql() {
		return cbql;
	}

	public void setCbql(int cbql) {
		this.cbql = cbql;
	}

	public String toString() {
		return "Mã NV: " + this.maNV + "\nTên NV: " + this.tenNV + "\nĐịa chỉ: " + this.diaChi + "\nCBQL: " + this.cbql;
	}

}
