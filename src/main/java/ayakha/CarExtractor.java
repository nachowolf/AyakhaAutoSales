package ayakha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarExtractor {

    private List<Car> cars = new ArrayList<>();

    public CarExtractor() {
        try {
            File cars = new File("cars.csv");
            BufferedReader carReader = new BufferedReader(new FileReader(cars));
            carReader.readLine();
            while (carReader.ready()){
                String[] car = carReader.readLine().split(",");
                this.cars.add(new Car(car[0], car[1], car[2], car[3]));
            }
            carReader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public List<Car> getListOfCars() {
        return cars;
    }

    public static void main(String[] args) {
        System.out.println( new CarExtractor().getListOfCars().size());
    }

}
