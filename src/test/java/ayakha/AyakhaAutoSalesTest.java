package ayakha;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.junit.jupiter.api.Test;
import static ayakha.AyakhaAutoSales.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AyakhaAutoSalesTest {

    private static ArrayList<Car> carList() throws IOException, ParseException, FileNotFoundException {
        JSONParser parser = new JSONParser();

        Path carsPath = Paths.get("cars.json");
        Object obj = parser.parse(new FileReader(carsPath.toFile()));
        JSONArray objects = (JSONArray) obj;

        Iterator<JSONObject> itr = objects.iterator();

        ArrayList<Car> cars = new ArrayList<>();

        while(itr.hasNext()) {
            JSONObject carObj = itr.next();

            Car car = new Car(
                (String)carObj.get("color"),
                (String)carObj.get("make"),
                (String)carObj.get("model"),
                (String)carObj.get("reg_number"));
            cars.add(car);

        }
        return cars;
    }

	@Test
    public void shouldFindMostPopularCarModel() throws Exception {
        assertEquals("", mostPopularCarModel(carList()));
    }

}