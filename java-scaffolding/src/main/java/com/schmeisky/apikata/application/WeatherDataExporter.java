package com.schmeisky.apikata.application;

import java.io.IOException;
import java.util.List;

public interface WeatherDataExporter {
    void export(List<WeatherObservation> weatherObservations) throws IOException;
}
