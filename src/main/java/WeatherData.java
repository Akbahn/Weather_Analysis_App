/**
 * Represents a single day's weather data.
 *
 * @param date          The date of the weather data (YYYY-MM-DD).
 * @param temperature   The temperature in Celsius.
 * @param humidity      The humidity percentage.
 * @param precipitation The precipitation in mm.
 */
public record WeatherData(String date, double temperature, int humidity, double precipitation) {}
