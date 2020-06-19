package pk3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GhiObject {

	public static void main(String[] args) {
		// Tạo đối tượng file
		File file = new File("data.dat");
		try {
			if (file.createNewFile()) {
				System.out.println("Tạo xong file!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Ghi đối tượng vào file
		ArrayList<News> list = new ArrayList<News>();
		list.add(new News(1, "Tin mới nhất"));
		list.add(new News(2, "Tin cũ nhất"));

		// Tạo đối tượng luồng và liên kết nguồn dữ liệu
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Đã ghi file!");

	}

}
