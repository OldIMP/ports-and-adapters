package com.schmeisky.apikata;

import com.schmeisky.apikata.application.WeatherObservationService;
import com.schmeisky.apikata.infrastructure.CsvWeatherDataExporter;
import com.schmeisky.apikata.infrastructure.RestWeatherDataFetcher;

import java.io.IOException;

public class WeatherObservationMain {
    public static void main(final String[] args) throws IOException {
        new WeatherObservationService(new RestWeatherDataFetcher(), new CsvWeatherDataExporter()).export();
    }
}
