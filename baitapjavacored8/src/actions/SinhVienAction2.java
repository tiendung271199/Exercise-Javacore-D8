package actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import beans.SinhVien;
import exception.NumberException;

public class SinhVienAction2 {
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

	public void display(ArrayList<SinhVien> list) {
		if (list.size() > 0) {
			System.out.println("======== DANH SÁCH SINH VIÊN ========");
			for (SinhVien sinhVien : list) {
				System.out.println(sinhVien);
			}
		} else {
			System.out.println("Chưa có dữ liệu sinh viên!");
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

	public ArrayList<SinhVien> addSinhVien(ArrayList<SinhVien> list) {
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
		System.out.println("Đã thêm!");
		return list;
	}

	public ArrayList<SinhVien> updateSinhVien(ArrayList<SinhVien> list) {
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
					break;
				}
			}
			System.out.println("Đã sửa!");
			return list;
		} else {
			System.out.println("Chưa có dữ liệu sinh viên!");
			return list;
		}
	}

	public ArrayList<SinhVien> deleteSinhVien(ArrayList<SinhVien> list) {
		if (list.size() > 0) {
			Scanner input = new Scanner(System.in);
			System.out.print("Nhập tên sinh viên cần xoá: ");
			String name = input.nextLine();
			int dem = 0;
			for (int i = 0; i < list.size(); i++) {
				if (name.equalsIgnoreCase(list.get(i).getTenSV())) {
					list.remove(i);
					dem++;
				}
			}
			if (dem == 0) {
				System.out.println("Không có sinh viên " + name + " trong danh sách!");
			} else {
				System.out.println("Đã xoá!");
			}
			return list;
		} else {
			System.out.println("Chưa có dữ liệu sinh viên!");
			return list;
		}
	}

	public void menu() {
		File file = new File("thisinh.txt");
		SinhVienAction2 obj = new SinhVienAction2();
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		try {
			list = obj.readData(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		boolean cont = true;
		while (cont) {
			System.out.println("======= QUẢN LÝ SINH VIÊN =======");
			System.out.println("--0. Exit");
			System.out.println("--1. Hiển thị danh sách sinh viên");
			System.out.println("--2. Thêm sinh viên");
			System.out.println("--3. Sửa thông tin sinh viên");
			System.out.println("--4. Xoá sinh viên");
			System.out.println("======= THE END =======");

			Scanner input = new Scanner(System.in);
			int luaChon = 0;
			while (true) {
				try {
					System.out.print("Nhập lựa chọn: ");
					luaChon = Integer.parseInt(input.nextLine());
					if (luaChon < 0 || luaChon > 4) {
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
				obj.display(list);
				break;
			case 2:
				list = obj.addSinhVien(list);
				break;
			case 3:
				list = obj.updateSinhVien(list);
				break;
			case 4:
				list = obj.deleteSinhVien(list);
				break;
			default:
				break;
			}
		}
	}
}
