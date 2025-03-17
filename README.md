# Weather Analysis App

## Overview
This project is a tool that reads weather data from a CSV file, analyzes it, and creates a weather report. It is built in Java and uses modern features for clear and efficient processing.
## Features
- **Data Parsing:** Read weather data from a CSV file and process it into usable records.
- **Weather Analysis:**
  - Calculate the average temperature for a specific month.
  - Identify days with temperatures above a threshold.
  - Count the number of rainy days in a month.
- **Interactive User Input:** Accept a month input from the user and generate a detailed weather report.
- **Report Generation:** Create a clean and readable weather report using Java text blocks.

## Classes Overview
### `Demo`
Demonstrates how the application works by:
- Loads weather data from a CSV file.
- Accepts a user-inputted month.
- Uses `Analysis` for analysis.
- Generates and prints the weather report.

### `Utilities`
A utility class that:
- `readWeatherData`: Parses weather data from a CSV file into a list of `WeatherData` records.
- `categorizeTemperature`: Categorizes temperatures into "Hot," "Warm," "Cold," or "Extreme."
- `getMonthName`: Converts a numeric month (e.g., "01") into its full name (e.g., "January").

### `Analysis`
Handles weather data analysis with:
- `averageTemperatureForMonth`: Computes the average temperature for a given month.
- `daysAboveTemperature`: Finds days where the temperature exceeds a threshold.
- `countRainyDaysForMonth`: Counts rainy days in a specified month.
- `generateReport`: Formats the analysis into a detailed weather report.

### `WeatherData`
A record class representing weather data with:
- `date`: The date (in YYYY-MM-DD format).
- `temperature`: Temperature in Celsius.
- `humidity`: Humidity percentage.
- `precipitation`: Precipitation in millimeters.

## How to Use
1. Place your weather data file (`weatherdata.csv`) in the project’s `resources` folder.
2. Compile and run the `Demo` class.
3. Enter a month when prompted (e.g., "01" for January).
4. View the generated weather report in the console.

## Requirements
- **Java Version:** Java 18+ (for enhanced switch and text blocks).
- **Dependencies:** None (uses standard Java libraries).

## Example Output
```
Weather data loaded successfully!

Enter the month (ex: 01 for January, 07 for July): 03
====== Weather Report for March ======
====== Weather Report ======
Average Temperature: 25.75°C
Days Above Threshold: [2024-03-05, 2024-03-15]
Rainy Days: 12
============================
```

## File Structure
```
src/
├── Demo.java              # Entry point
├── Utilities.java         # Utility functions (parsing CSV, categorization Hot, Mild, Cold)
├── Analysis.java          # Data analysis methods
└── WeatherData.java       # Record class for weather data
resources/
└── weatherdata.csv        # Sample weather data (CSV file)
```

