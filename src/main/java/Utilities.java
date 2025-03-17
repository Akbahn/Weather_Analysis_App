import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for reading weather data from a CSV file.
 */
public class Utilities {
    /**
     * Reads the weather data from a CSV file and converts it into a list of WeatherData records.
     *
     *
     * @return A list of WeatherData records.
     * @throws IOException If file reading fails.
     */
    public static List<WeatherData> readWeatherData(String resourceName) throws IOException {
        InputStream inputStream = Utilities.class.getClassLoader().getResourceAsStream(resourceName);
        if (inputStream == null) {
            throw new IOException("Resource file not found: " + resourceName);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines()
                    .skip(1) // Skip header
                    .map(line -> line.split(","))
                    .map(parts -> new WeatherData(parts[0],
                            Double.parseDouble(parts[1]),
                            Integer.parseInt(parts[2]),
                            Double.parseDouble(parts[3])))
                    .collect(Collectors.toList());
        }
    }

    /**
     * Categorizes temperature into predefined weather conditions.
     *
     * @param temperature The temperature in Celsius.
     * @return The weather category.
     */
    public static String categorizeTemperature(double temperature) {
        return switch ((int) temperature / 10) {
            case 3, 4, 5 -> "Hot";
            case 2 -> "Warm";
            case 0, 1 -> "Cold";
            default -> "Extreme";
        };
    }

    /**
     * Converts a two-digit month number (e.g., "01") into its full name (e.g., "January").
     *
     * @param monthNumber Two-digit string representing the month ("01" to "12").
     * @return Full month name, or "Unknown" for invalid input.
     */

    public static String getMonthName(String monthNumber) {
        return switch (monthNumber) {
            case "01" -> "January";
            case "02" -> "February";
            case "03" -> "March";
            case "04" -> "April";
            case "05" -> "May";
            case "06" -> "June";
            case "07" -> "July";
            case "08" -> "August";
            case "09" -> "September";
            case "10" -> "October";
            case "11" -> "November";
            case "12" -> "December";
            default -> "Unknown";
        };
    }

}
