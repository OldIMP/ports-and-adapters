package com.schmeisky.apikata.application;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherObservationService {
    private final WeatherDataFetcher weatherDataFetcher;
    private final WeatherDataExporter weatherDataExporter;

    public WeatherObservationService(WeatherDataFetcher weatherDataFetcher, WeatherDataExporter weatherDataExporter) {
        this.weatherDataFetcher = weatherDataFetcher;
        this.weatherDataExporter = weatherDataExporter;
    }

    public void export() throws IOException {
        Result result = weatherDataFetcher.fetch();
        List<WeatherObservation> weatherObservations = map(result);
        weatherDataExporter.export(weatherObservations);
    }

    private List<WeatherObservation> map(Result result) {
        return result.getResults()
                .stream()
                .map(r->{
                    String[] dateTime = parseDateTime(r.get("time"));
                    return new WeatherObservation(r.get("id"),
                            r.get("name"),
                            dateTime[0],
                            dateTime[1],
                            r.get("T"),
                            r.get("P"),
                            r.get("D"));
                }).collect(Collectors.toList());
    }

    private static String[] parseDateTime(String dateTime) {
        return dateTime.split(" ");
    }
}
