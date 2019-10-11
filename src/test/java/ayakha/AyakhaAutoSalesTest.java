package ayakha;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ayakha.AyakhaAutoSales.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

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

	@Test
    public void shouldFindMostPopularCarModel() throws Exception {

        assertEquals("Corolla", mostPopularCarModel(carList()));
    }

    @Test
    public void shouldReturnAmountOfCarsFromTown() throws Exception{
        assertEquals(5, carCountForTown("Cape Town", carList()));
    }

    @Test
    public void shouldReturnHowManyNissansFromMalmsbury() throws Exception{
        assertEquals(1, howManyNissansFromMalmesbury(carList()));
    }

    @Test
    public void shouldReturnTheTownWithTheMostBlueCars() throws Exception{
        assertEquals("Stellenbosch", townWithMostBlueCars(carList()));
    }

    @Test
    public void shouldReturnTownWithFewestOrangeCars() throws Exception{
        assertEquals("Paarl", townWithFewestOrangeCars(carList()));
    }

    @Test
    public void shouldReturnMostPopularCarModel() throws Exception{
        assertEquals("Corolla", mostPopularModel(carList()));
    }

    @Test
    public void shouldReturnMostPopularModelFromStellbosch() throws Exception{
        assertEquals("Fiesta", mostPopularModelFromStellenbosch(carList()));
    }

    @Test
    public void shouldReturnLeastPopularCarModelInKuilsrivier() throws Exception{
        assertEquals("Ranger", leastPopularModelCarInKuilsrivier(carList()));
    }

    @Test
    public void shouldReturnAListOfCarsFromASpecifiedTown() throws Exception{

        assertEquals(Arrays.asList(
                new Car("white", "Nissan", "Micra", "CJ 16103"),
                new Car("white", "Toyota", "Hilux", "CJ 16455"),
                new Car("orange", "Ford", "Fiesta", "CJ 67577")), carsForTown("Paarl", carList()));
    }

    @Test
    public void shouldReturnAListOfCarsWithASpecifiedColorAndFromASpecifiedTown() throws Exception{
        assertEquals(Arrays.asList(), numberOfCars("red", "Malmesbury", carList()));
        assertEquals(Arrays.asList(
                new Car("blue", "Volkswagen", "Jetta", "CA 46977"),
                new Car("blue", "Ford", "Ranger", "CA 77852")), numberOfCars("blue", "Cape Town", carList()));
    }

    @Test
    public void shouldReturnTheNumberOfVehiclesThatFitTheSpecifiedModelAndColor() throws Exception{
        assertEquals(0, numberOfCarsPerModel("Ranger", "green", carList()));
    }

    @Test
    public void shouldReturnTheNumberOfVehiclesThatFitTheSpecifiedModelAndColorAndTown() throws Exception{
        assertEquals(0, numberOfCarsPerModel("Tazz", "white", "Cape Town",carList()));
    }

    @Test
    public void shouldReturnMostCommonCarColorInSpecifiedTown() throws Exception{
        assertEquals("orange", mostPopularColorForTown("Bellville", carList()));
    }
}