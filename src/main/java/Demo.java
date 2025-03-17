import java.io.IOException;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        try {
            List<WeatherData> weatherData = Utilities.readWeatherData("weatherdata.csv"); // Load weather data
            System.out.println("Weather data loaded successfully!\n");

            // Ask user for a month input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the month (ex: 01 for January, 07 for July): ");
            String monthInput = scanner.nextLine().trim();

            // Validate input check
            if (!monthInput.matches("^(0[1-9]|1[0-2])$")) {
                System.out.println("Invalid month format! Please enter a value between 01 and 12.");
                return;
            }

            // Builds String for the selected month code and name
            String monthCode = "2024-" + monthInput;
            String monthName = Utilities.getMonthName(monthInput);

            // Get weather data for the selected month
            OptionalDouble avgTemp = Analysis.averageTemperatureForMonth(weatherData, monthCode);
            List<String> hotDays = Analysis.daysAboveTemperature(weatherData, 85); // Threshold: 85°C
            long rainyDays = Analysis.countRainyDaysForMonth(weatherData, monthCode);


            // Generate and print the weather report
            String report = Analysis.generateReport(
                    avgTemp.orElse(Double.NaN), // Handle case where no data is found
                    hotDays,
                    rainyDays
            );

            System.out.println("====== Weather Report for " + monthName + " ======");
            System.out.println(report);

        } catch (IOException e) {
            System.err.println("Error reading weather data: " + e.getMessage());
        }
    }
}
