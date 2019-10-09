package ayakha;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static ayakha.AyakhaAutoSales.mostPopularCarModel;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AyakhaAutoSalesTest {

    private static ArrayList<Car> carList() throws Exception {

        Path carsPath = Paths.get("cars.csv");
        FileReader fileReader = new FileReader(carsPath.toFile());
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        bufferedReader.readLine();
        ArrayList<Car> cars = new ArrayList<>();

        while (true) {
            String line = bufferedReader.readLine();
            if (line == null){
                break;
            }

            String[] parts = line.split(",");
            Car car = new Car(
                    parts[0],
                    parts[1],
                    parts[2],
                    parts[3]);
            cars.add(car);
        }
        return cars;
    }

	@org.junit.jupiter.api.Test
    public void shouldFindMostPopularCarModel() throws Exception {

        System.out.println(carList().get(0));

        assertEquals("", mostPopularCarModel(carList()));
    }

}