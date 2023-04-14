package com.schmeisky.apikata.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherObservationServiceTest {
    @Mock
    private WeatherDataFetcher weatherDataFetcher;
    @Mock
    private WeatherDataExporter weatherDataExporter;

    @InjectMocks
    private WeatherObservationService weatherObservationService;

    @Test
    void export() throws IOException {
        WeatherObservation expected = new WeatherObservation("id123",
                "funny",
                "2023-04-14",
                "09:00:00",
                "4.1",
                "1009",
                "E");

        var result= Map.of("id", expected.getId(),
                "name", expected.getName(),
                "time", "2023-04-14 09:00:00",
                "T", expected.getTemperature(),
                "P", expected.getPressure(),
                "D", expected.getWindDirection());

        when(weatherDataFetcher.fetch()).thenReturn(new Result(Collections.singletonList(result)));

        weatherObservationService.export();

        verify(weatherDataExporter).export(Collections.singletonList(expected));
    }
}