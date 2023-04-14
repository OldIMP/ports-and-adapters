package com.schmeisky.apikata.infrastructure;

import com.schmeisky.apikata.application.WeatherDataExporter;
import com.schmeisky.apikata.application.WeatherObservation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class CsvWeatherDataExporter implements WeatherDataExporter {
    @Override
    public void export(List<WeatherObservation> weatherObservations) throws IOException {
        List<String> lines = weatherObservations.stream().map(wo -> new StringJoiner(",").add(wo.getId())
                        .add(wo.getName())
                        .add(wo.getDate())
                        .add(wo.getTime())
                        .add(wo.getTemperature())
                        .add(wo.getPressure())
                        .add(wo.getWindDirection())
                        .toString())
                .collect(Collectors.toList());

        Path path = Path.of("C:\\Entwicklung\\code\\ports-and-adapters\\java-scaffolding\\target",
                "weather_observation.csv");
        Files.write(path, lines);
    }
}
