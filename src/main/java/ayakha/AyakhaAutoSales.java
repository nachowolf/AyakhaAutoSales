package ayakha;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ayakha.Car;

public class AyakhaAutoSales {

    enum Town{
        CJ("Paarl"),
        CY("Bellville"),
        CL("Stellenbosch"),
        CK("Malmesbury"),
        CA("Cape Town"),
        CF("Kuilsriver");

        private String town;

        Town(String town){
            this.town = town;
        }

        public String getTown() {
            return town;
        }
    }

    
    public static int carCountForTown(String town, List<Car> cars) {
        String code = Stream.of(Town.values())
                .filter(loc -> loc.getTown().equalsIgnoreCase(town))
                .findFirst().get().toString();

        return (int) cars.stream()
                .filter(car -> car.getRegNumber().contains(code))
                .count();
    }

    public static String mostPopularCarModel(List<Car> cars) {

        String mostCommonModel = cars

                // create stream of cars
                .stream()

                // can be used to run methods on an object passed in
                .map(Car::getModel)

                // filter to make sure stream doesn't contain null pointers
//                .filter(Objects::nonNull)

                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))

                //entryset method on map
                .entrySet()

                //stream map entryset
                .stream()

                //
                .max(Map.Entry.comparingByValue())

                .map(Map.Entry::getKey)

                .orElse(null);


        return mostCommonModel;
    }

    public static int howManyNissansFromMalmesbury(List<Car> cars) {
        String code = "CK";
        return (int) cars.stream()
                .filter(car -> car.getMake().equalsIgnoreCase("nissan"))
                .filter(car -> car.getRegNumber().contains(code))
                .count();
    }

    public static String townWithMostBlueCars(List<Car> cars) {

        String code = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("blue"))
                .collect(Collectors.groupingBy(car -> car.getRegNumber().split(" ")[0], Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        return Town.valueOf(code).getTown();
    }

    public static String townWithFewestOrangeCars(List<Car> cars) {

        String code = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("orange"))
                .collect(Collectors.groupingBy(car -> car.getRegNumber().split(" ")[0], Collectors.counting()))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        return Town.valueOf(code).getTown();
    }

    public static String mostPopularModel(List<Car> cars) {

        return cars.stream()
                .collect(Collectors.groupingBy(car -> car.getModel(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

    }

    public static String mostPopularModelFromStellenbosch(List<Car> cars) {

        String codeForStellenbosch = "CL";
        return cars.stream()
                .filter(car -> car.getRegNumber().contains(codeForStellenbosch))
                .collect(Collectors.groupingBy(car -> car.getModel(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey)
                .orElse(null);
    }

    public static String leastPopularModelCarInKuilsrivier(List<Car> cars) {
        String codeForKuilsriver = "CF";
        return cars.stream()
                .filter(car -> car.getRegNumber().contains(codeForKuilsriver))
                .collect(Collectors.groupingBy(car -> car.getModel(), Collectors.counting()))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public static List<Car> carsForTown(String townName, List<Car> cars) {
        String townCode = Stream.of(Town.values())
                .filter(code -> code.getTown().equalsIgnoreCase(townName))
                .findFirst()
                .get()
                .toString();

        return cars.stream()
                .filter(car -> car.getRegNumber().contains(townCode))
                .collect(Collectors.toList());
    }
    
    public static List<Car> numberOfCars(String color, String townName,List<Car> cars) {

        String code = Stream.of(Town.values())
                .filter(town -> town.getTown().equalsIgnoreCase(townName))
                .findFirst()
                .get()
                .toString();

        return cars.stream()
                .filter(car -> car.getRegNumber().contains(code))
                .filter(car -> car.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }

    public static int numberOfCarsPerModel(String model, String color,  List<Car> cars) {
        return (int)cars.stream()
                .filter(car -> car.getModel()
                        .equalsIgnoreCase(model)
                        &&
                        car.getColor()
                                .equalsIgnoreCase(color))
                .count();
    }

    public static int numberOfCarsPerModel(String model, String color, String townname,  List<Car> cars) {

        String code = Stream.of(Town.values())
                .filter(town -> town.getTown().equalsIgnoreCase(townname))
                .findFirst()
                .get()
                .toString();

        return (int)cars.stream()
                .filter(car -> car.getModel()
                        .equalsIgnoreCase(model)
                        &&
                        car.getColor()
                                .equalsIgnoreCase(color))
                .count();

    }

    public static String mostPopularColorForTown(String town, List<Car> cars) {
        String code = Stream.of(Town.values())
                .filter(towncode -> towncode.getTown().equalsIgnoreCase(town))
                .findFirst()
                .get()
                .toString();

        return  cars.stream()
                .collect(Collectors.groupingBy(car -> car.getColor(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }



}
