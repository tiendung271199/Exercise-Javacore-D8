package bai1;

import java.util.ArrayList;

import actions.NhanVienAction;
import beans.NhanVien;

public class NhanVienDemo {
	public static void main(String[] args) {
		NhanVienAction obj = new NhanVienAction();
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		list = obj.inputData();
		obj.displayCBQL(list);
	}
}
