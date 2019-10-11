package ayakha;

import java.util.Objects;

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

	@Override
	public String toString() {
		return "Car{" +
				"color='" + color + '\'' +
				", make='" + make + '\'' +
				", model='" + model + '\'' +
				", regNumber='" + regNumber + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return color.equals(car.color) &&
				make.equals(car.make) &&
				model.equals(car.model) &&
				regNumber.equals(car.regNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, make, model, regNumber);
	}
}