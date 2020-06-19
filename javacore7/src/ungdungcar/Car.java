package ungdungcar;

public class Car {
	private int serial;
	private String model;
	
	public Car() {
		
	}

	public Car(int serial, String model) {
		super();
		this.serial = serial;
		this.model = model;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String toString() {
		return "Serial: " + this.serial + " - Model: " + this.model;
	}
	
}
