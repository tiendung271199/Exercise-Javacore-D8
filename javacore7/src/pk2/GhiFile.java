package pk2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GhiFile {
	public static void main(String[] args) {
		// Tạo file
		File file = new File("data.txt");
		try {
			if (file.createNewFile()) {
				System.out.println("Tạo xong file!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Ghi file
		try {
			// Tạo đối tượng luồng và liên kết nguồn dữ liệu
			FileWriter fw = new FileWriter(file);
			// tạo bộ đệm ghi file
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Tôi đang thao tác với File\n");
			bw.write("Java là ngôn ngữ lập trình đỉnh của đỉnh\n");
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Ghi File thành công!");
	}
}
