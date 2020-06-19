package pk2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DocFile {
	public static void main(String[] args) {
		// Đọc data từ file data.txt
		File file = new File("data.txt");
		
		// Đọc file
		String result = "";
		try {
			// Tạo đối tượng luồng và liên kết nguồn dữ liệu (file data.txt)
			FileReader fr = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null) {
				result = result + line + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Đọc xong!");
		System.out.println("Data:\n" + result);
		
	}
}
