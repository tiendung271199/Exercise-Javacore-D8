package pk1;

import java.io.File;
import java.io.IOException;

public class FileDemo {
	public static void main(String[] args) {
		File file = new File("filedemo.txt");
		try {
			if (file.createNewFile()) {
				System.out.println("Tạo xong file");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File file2 = new File("ahihi/filedemo.txt");
		try {
			if (file2.createNewFile()) {
				System.out.println("Tạo xong file");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// get tên file
		System.out.println(file2.getName());
		// get Path (Địa chỉ đến file)
		System.out.println(file2.getPath());
		// get đường dẫn vật lý đến file
		System.out.println(file2.getAbsolutePath());
		
		// Kiểm tra file tồn tại
		if (file2.exists()) {
			System.out.println("Tồn tại");
		}
		
		System.out.println(file2.canRead());
		System.out.println(file2.canWrite());
		System.out.println(file2.isFile());
		System.out.println(file2.isDirectory());
	}
}
