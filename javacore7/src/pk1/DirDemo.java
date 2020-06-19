package pk1;

import java.io.File;

public class DirDemo {
	public static void main(String[] args) {
		File dir1 = new File("thu-muc-1");
		if (dir1.mkdir()) {
			System.out.println("Tạo xong thư mục 1");
		}
		
		// Tạo cấu trúc thư mục
		File dir2 = new File("thumuc/thu-muc-2/dir");
		if (dir2.mkdirs()) {
			System.out.println("Xong!");
		}
		
		System.out.println(dir2.isDirectory());
	}
}
