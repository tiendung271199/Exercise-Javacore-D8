package actions;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import beans.NhanVien;
import exception.NumberException;

public class NhanVienAction {
	public ArrayList<NhanVien> inputData() {
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		int n = 0;
		Scanner input = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("Nhập số lượng nhân viên: ");
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
		System.out.println("========= NHẬP THÔNG TIN NHÂN VIÊN =========");
		String maNV = "", tenNV = "", diaChi = "";
		int cbql = 0;
		for (int i = 0; i < n; i++) {
			System.out.println("========= Nhập thông tin nhân viên thứ " + i + " =========");
			System.out.print("Nhập mã: ");
			maNV = input.nextLine();
			System.out.print("Nhập tên: ");
			tenNV = input.nextLine();
			System.out.print("Nhập địa chỉ: ");
			diaChi = input.nextLine();
			while (true) {
				try {
					System.out.print("Là cán bộ quản lý? (1: true, 0: false): ");
					cbql = Integer.parseInt(input.nextLine());
					if (cbql != 0 && cbql != 1) {
						throw new NumberException("Vui lòng nhập cbql theo định dạng!");
					}
					break;
				} catch (NumberFormatException e) {
					System.out.println("Vui lòng nhập đúng định dạng số!");
				} catch (NumberException e) {
					System.out.println(e.getMessage());
				}
			}
			list.add(new NhanVien(maNV, tenNV, diaChi, cbql));
		}
		return list;
	}

	public boolean laCBQL(NhanVien nv) {
		if (nv.getCbql() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public void inTieuDe() {
		System.out.printf("%-15s%-25s%s\n", "Mã", "Họ tên", "Địa chỉ");
	}

	public void toString1(NhanVien nv) {
		System.out.printf("%-15s%-25s%s\n", nv.getMaNV(), nv.getTenNV(), nv.getDiaChi());
	}

	public void displayCBQL(ArrayList<NhanVien> list) {
		if (list.size() > 0) {
			System.out.println("========= DANH SÁCH NHÂN VIÊN LÀ CÁN BỘ QUẢN LÝ =========");
			inTieuDe();
			for (NhanVien nhanVien : list) {
				if (laCBQL(nhanVien)) {
					toString1(nhanVien);
				}
			}
		} else {
			System.out.println("Chưa có dữ liệu nhân viên!");
		}
	}
}
