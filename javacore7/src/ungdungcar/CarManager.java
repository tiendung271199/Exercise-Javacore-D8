package ungdungcar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarManager {

	public void nhap(File file) throws IOException {
		if (file != null && file.exists()) {
			Scanner input = new Scanner(System.in);

			System.out.print("Số xe cần nhập: ");
			int number = Integer.parseInt(input.nextLine());

			for (int i = 0; i < number; i++) {
				System.out.print("Nhập serial: ");
				int serial = Integer.parseInt(input.nextLine());
				System.out.print("Nhập model: ");
				String model = input.nextLine();

				Car car = new Car(serial, model);
				// Ghi dữ liệu
				writeData(file, car);
			}
		}

	}

	private void writeData(File file, Car car) throws IOException {
		if (file != null && file.exists() && file.canWrite()) {
			// Tạo đối tượng luồng và liên kết nguồn dữ liệu
			FileWriter fw = new FileWriter(file, true); // true: cho phép ghi nối vào file
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(car.getSerial() + "," + car.getModel());
			bw.newLine();
			bw.close();
			fw.close();
		}

	}

	public ArrayList<Car> readData(File file) throws IOException {
		ArrayList<Car> list = new ArrayList<Car>();
		if (file != null && file.exists() && file.canRead()) {
			// Tạo đối tượng luồng và liên kết nguồn dữ liệu
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				String[] carInfo = line.split(",");

				try {
					Car car = new Car(Integer.parseInt(carInfo[0]), carInfo[1]);
					list.add(car);
				} catch (NumberFormatException e) {
					throw e;
				}

			}
			br.close();
			fr.close();
		}
		return list;
	}

	public void search(ArrayList<Car> list) {
		if (list.size() > 0) {
			Scanner input = new Scanner(System.in);
			System.out.print("Nhập serial cần tìm: ");
			int serial = Integer.parseInt(input.nextLine());

			for (Car car : list) {
				if (car.getSerial() == serial) {
					System.out.println("Model tương ứng với serial vừa nhập: " + car.getModel());
					return;
				}
			}
			System.out.println("Serial vừa nhập không tồn tại");
		} else {
			System.out.println("Chưa có dữ liệu");
		}
	}

	public void deleteCar(File file, ArrayList<Car> list) throws IOException {
		if (file != null && file.exists()) {
			if (list.size() > 0) {
				Scanner input = new Scanner(System.in);
				System.out.print("Nhập model cần xoá: ");
				String model = input.nextLine();
				int dem = 0;
				// Phải dùng for i
				for (int i = 0; i < list.size(); i++) {
					if (model.equals(list.get(i).getModel())) {
						System.out.println("Xoá xe có model: " + model);
						list.remove(i);
						dem++;
					}
				}
				if (dem == 0) {
					System.out.println("Model vừa nhập không tồn tại");
				} else {
					// Làm rỗng file
					clearFile(file);

					// Ghi lại
					for (Car car : list) {
						writeData(file, car);
					}
				}
			} else {
				System.out.println("Chưa có dữ liệu");
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

	public void addCar(File file, ArrayList<Car> list) throws IOException {
		if (file != null && file.exists()) {
			Scanner input = new Scanner(System.in);
			System.out.println("======== Nhâp thông tin xe cần thêm ========");
			System.out.print("Nhập serial: ");
			int serial = Integer.parseInt(input.nextLine());
			System.out.print("Nhập model: ");
			String model = input.nextLine();

			Car car = new Car(serial, model);
			list.add(car); // Thêm car vào list
			writeData(file, car); // Ghi thêm car vào file
			System.out.println("Đã thêm");
		}
	}

	public static void main(String[] args) {
		CarManager obj = new CarManager();

		// Tạo file
		File file = new File("Car.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			// obj.nhap(file);
			ArrayList<Car> list = obj.readData(file);
			for (Car car : list) {
				System.out.println(car);
			}
			// obj.search(list);
			obj.deleteCar(file, list);
			obj.addCar(file, list);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
