package com.schmeisky.apikata.infrastructure;

import com.schmeisky.apikata.application.WeatherDataExporter;
import com.schmeisky.apikata.application.WeatherObservation;

import java.util.List;

public class ConsoleWeatherDataExporter implements WeatherDataExporter {
    @Override
    public void export(List<WeatherObservation> weatherObservations) {
        System.out.println(weatherObservations);
    }
}
