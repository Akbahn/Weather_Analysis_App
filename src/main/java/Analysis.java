import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * Provides weather analysis functionalities using Java Streams.
 */
public class Analysis {

    /**
     * Computes the average temperature for a given month.
     *
     * @param weatherData List of weather records.
     * @param month       The target month ( "YYYY-MM").
     * @return The average temperature.
     */
    public static OptionalDouble averageTemperatureForMonth(List<WeatherData> weatherData, String month) {
        return weatherData.stream()
                .filter(w -> w.date().startsWith(month))
                .mapToDouble(WeatherData::temperature)
                .average();
    }

    /**
     * Finds days when temperature exceeded a given threshold.
     *
     * @param weatherData List of weather records.
     * @param threshold   The temperature threshold.
     * @return List of matching dates.
     */
    public static List<String> daysAboveTemperature(List<WeatherData> weatherData, double threshold) {
        return weatherData.stream()
                .filter(w -> w.temperature() > threshold)
                .map(WeatherData::date)
                .collect(Collectors.toList());
    }

    /**
     * Counts the number of rainy days (precipitation > 0) for the specific month.
     *
     * @param weatherData List of weather records.
     * @param month       The target month ("YYYY-MM" format).
     * @return The number of rainy days in the given month.
     */
    public static long countRainyDaysForMonth(List<WeatherData> weatherData, String month) {
        return weatherData.stream()
                .filter(w -> w.date().startsWith(month))
                .filter(w -> w.precipitation() > 0)
                .count();
    }


    /**
     * Generates a weather report using Java text blocks.
     *
     * @param avgTemp  The average temperature.
     * @param hotDays  List of hot days.
     * @param rainDays Count of rainy days.
     * @return Formatted report string.
     */
    public static String generateReport(double avgTemp, List<String> hotDays, long rainDays) {
        return """
           ====== Weather Report ======
           Average Temperature: %.2f°C
           Days Above Threshold: %s
           Rainy Days: %d
           ===========================
           """.formatted(avgTemp, hotDays, rainDays);
    }

}
