package com.schmeisky.apikata.application;

import java.util.Objects;

public final class WeatherObservation {
    private final String id;
    private final String name;
    private final String date;
    private final String time;
    private final String temperature;
    private final String pressure;
    private final String windDirection;

    public WeatherObservation(String id, String name, String date, String time, String temperature, String pressure, String windDirection) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.temperature = temperature;
        this.pressure = pressure;
        this.windDirection = windDirection;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public String getWindDirection() {
        return windDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherObservation that = (WeatherObservation) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(date, that.date) && Objects.equals(time, that.time) && Objects.equals(temperature, that.temperature) && Objects.equals(pressure, that.pressure) && Objects.equals(windDirection, that.windDirection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, time, temperature, pressure, windDirection);
    }
}
