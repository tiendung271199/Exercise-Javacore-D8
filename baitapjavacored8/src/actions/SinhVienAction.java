package actions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import beans.SinhVien;
import exception.NumberException;

public class SinhVienAction {

	public void nhap(File file, ArrayList<SinhVien> list) throws IOException {
		if (file != null && file.exists()) {
			Scanner input = new Scanner(System.in);
			int n = 0;
			while (true) {
				try {
					System.out.print("Số sinh viên cần nhập: ");
					n = Integer.parseInt(input.nextLine());
					if (n < 0) {
						throw new NumberException("Vui lòng nhập số lượng >= 0!");
					}
					break;
				} catch (NumberFormatException e) {
					System.out.println("Vui lòng nhập đúng định dạng số!");
				} catch (NumberException e) {
					System.out.println(e.getMessage());
				}
			}
			int maSV = 0;
			String tenSV = "", lop = "";
			for (int i = 0; i < n; i++) {
				while (true) {
					try {
						System.out.print("Nhập mã: ");
						maSV = Integer.parseInt(input.nextLine());
						if (maSV <= 0) {
							throw new NumberException("Vui lòng nhập mã > 0!");
						}
						if (checkMa(maSV, list)) {
							throw new NumberException("Vui lòng nhập mã không trùng với mã đã nhập trước đó!");
						}
						break;
					} catch (NumberFormatException e) {
						System.out.println("Vui lòng nhập đúng định dạng số!");
					} catch (NumberException e) {
						System.out.println(e.getMessage());
					}
				}
				System.out.print("Nhập tên: ");
				tenSV = input.nextLine();
				System.out.print("Nhập lớp: ");
				lop = input.nextLine();
				SinhVien obj = new SinhVien(maSV, tenSV, lop);
				list.add(obj);
				writeData(file, obj);
			}
		}

	}

	public boolean checkMa(int ma, ArrayList<SinhVien> list) {
		if (list.size() > 0) {
			for (SinhVien sinhVien : list) {
				if (ma == sinhVien.getMaSV()) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	private void writeData(File file, SinhVien obj) throws IOException {
		if (file != null && file.exists() && file.canWrite()) {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(obj.getMaSV() + "," + obj.getTenSV() + "," + obj.getLop());
			bw.newLine();
			bw.close();
			fw.close();
		}

	}

	public ArrayList<SinhVien> readData(File file) throws IOException {
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		if (file != null && file.exists() && file.canRead()) {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] svInfo = line.split(",");
				try {
					SinhVien sv = new SinhVien(Integer.parseInt(svInfo[0]), svInfo[1], svInfo[2]);
					list.add(sv);
				} catch (NumberFormatException e) {
					throw e;
				}
			}
			br.close();
			fr.close();
		}
		return list;
	}

	public void addSinhVien(File file, ArrayList<SinhVien> list) throws IOException {
		if (file != null && file.exists()) {
			Scanner input = new Scanner(System.in);
			System.out.println("======== NHẬP THÔNG TIN SINH VIÊN CẦN THÊM ========");
			int maSV = 0;
			String tenSV = "", lop = "";
			while (true) {
				try {
					System.out.print("Nhập mã: ");
					maSV = Integer.parseInt(input.nextLine());
					if (maSV <= 0) {
						throw new NumberException("Vui lòng nhập mã > 0!");
					}
					if (checkMa(maSV, list)) {
						throw new NumberException("Vui lòng nhập mã không trùng với mã đã nhập trước đó!");
					}
					break;
				} catch (NumberFormatException e) {
					System.out.println("Vui lòng nhập đúng định dạng số!");
				} catch (NumberException e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.print("Nhập tên: ");
			tenSV = input.nextLine();
			System.out.print("Nhập lớp: ");
			lop = input.nextLine();
			SinhVien sv = new SinhVien(maSV, tenSV, lop);
			list.add(sv);
			writeData(file, sv);
			System.out.println("Đã thêm sinh viên!");
		}
	}

	public void updateSinhVien(File file, ArrayList<SinhVien> list) throws IOException {
		if (file != null && file.exists()) {
			if (list.size() > 0) {
				Scanner input = new Scanner(System.in);
				int maSV = 0;
				while (true) {
					try {
						System.out.print("Nhập mã sinh viên cần sửa: ");
						maSV = Integer.parseInt(input.nextLine());
						if (maSV <= 0) {
							throw new NumberException("Vui lòng nhập mã > 0!");
						}
						if (!checkMa(maSV, list)) {
							throw new NumberException("Mã bạn nhập không tồn tại!");
						}
						break;
					} catch (NumberFormatException e) {
						System.out.println("Vui lòng nhập đúng định dạng số!");
					} catch (NumberException e) {
						System.out.println(e.getMessage());
					}
				}
				for (int i = 0; i < list.size(); i++) {
					if (maSV == list.get(i).getMaSV()) {
						System.out.println("======= SỬA THÔNG TIN SINH VIÊN CÓ MÃ = " + maSV + " ========");
						int ma = 0;
						String tenSV = "", lop = "";
						while (true) {
							try {
								System.out.print("Nhập mã: ");
								ma = Integer.parseInt(input.nextLine());
								if (ma <= 0) {
									throw new NumberException("Vui lòng nhập mã > 0!");
								}
								if (checkMa(ma, list)) {
									throw new NumberException("Vui lòng nhập mã không trùng với mã đã nhập trước đó!");
								}
								break;
							} catch (NumberFormatException e) {
								System.out.println("Vui lòng nhập đúng định dạng số!");
							} catch (NumberException e) {
								System.out.println(e.getMessage());
							}
						}
						System.out.print("Nhập tên: ");
						tenSV = input.nextLine();
						System.out.print("Nhập lớp: ");
						lop = input.nextLine();
						SinhVien obj = new SinhVien(ma, tenSV, lop);
						list.set(i, obj);
						clearFile(file);
						for (SinhVien sinhVien : list) {
							writeData(file, sinhVien);
						}
						System.out.println("Đã sửa thông tin sinh viên!");
						return;
					}
				}

			} else {
				System.out.println("Chưa có dữ liệu sinh viên!");
			}
		}
	}

	public void deleteSinhVien(File file, ArrayList<SinhVien> list) throws IOException {
		if (file != null && file.exists()) {
			if (list.size() > 0) {
				Scanner input = new Scanner(System.in);
				System.out.print("Nhập tên sinh viên cần xoá: ");
				String name = input.nextLine();
				int dem = 0;
				for (int i = 0; i < list.size(); i++) {
					if (name.equalsIgnoreCase(list.get(i).getTenSV())) {
						System.out.println("Xoá sinh viên có tên: " + name);
						list.remove(i);
						dem++;
					}
				}
				if (dem == 0) {
					System.out.println("Sinh viên " + name + " không tồn tại!");
				} else {
					clearFile(file);
					for (SinhVien sinhVien : list) {
						writeData(file, sinhVien);
					}
				}
			} else {
				System.out.println("Chưa có dữ liệu sinh viên!");
			}
		}
	}

	private void clearFile(File file) throws IOException {
		if (file != null && file.exists() && file.canWrite()) {
			FileWriter fw = new FileWriter(file);
			fw.write("");
			fw.close();
		}

	}

	public void display(File file, ArrayList<SinhVien> list) throws IOException {
		if (file != null && file.exists()) {
			if (list.size() > 0) {
				System.out.println("======== Danh sách sinh viên ========");
				for (SinhVien sinhVien : list) {
					System.out.println(sinhVien);
				}
			} else {
				System.out.println("Chưa có dữ liệu sinh viên!");
			}
		}
	}

	public void menu() {
		SinhVienAction obj = new SinhVienAction();
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		File file = new File("student.dat");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			list = obj.readData(file);
			boolean cont = true;
			while (cont) {
				System.out.println("========= QUẢN LÝ SINH VIÊN =========");
				System.out.println("--0. Exit");
				System.out.println("--1. Nhập thông tin sinh viên vào file");
				System.out.println("--2. Hiển thị danh sách sinh viên");
				System.out.println("--3. Thêm sinh viên vào file");
				System.out.println("--4. Sửa thông tin sinh viên trong file");
				System.out.println("--5. Xoá sinh viên ra khỏi file");
				System.out.println("========= THE END =========");
				
				Scanner input = new Scanner(System.in);
				int luaChon = 0;
				while (true) {
					try {
						System.out.print("Nhập lựa chọn: ");
						luaChon = Integer.parseInt(input.nextLine());
						if (luaChon > 5 || luaChon < 0) {
							throw new NumberException("Vui lòng nhập lựa chọn từ 0 - 4!");
						}
						break;
					} catch (NumberFormatException e) {
						System.out.println("Vui lòng nhập đúng định dạng số!");
					} catch (NumberException e) {
						System.out.println(e.getMessage());
					}
				}
				switch (luaChon) {
				case 0:
					System.out.println("GOODBYE!");
					cont = false;
					break;
				case 1:
					obj.nhap(file, list);
					break;
				case 2:
					obj.display(file, list);
					break;
				case 3:
					obj.addSinhVien(file, list);
					break;
				case 4:
					obj.updateSinhVien(file, list);
					break;
				case 5:
					obj.deleteSinhVien(file, list);
					break;
				default:
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
