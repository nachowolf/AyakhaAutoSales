package ayakha;

public class Car {
	private String color;
	private String make;
	private String model;
	private String regNumber;

	public Car(String color, String make, String model, String regNumber) {
		this.color = color;
		this.make = make;
		this.model = model;
		this.regNumber = regNumber;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return the regNumber
	 */
	public String getRegNumber() {
		return regNumber;
	}
}