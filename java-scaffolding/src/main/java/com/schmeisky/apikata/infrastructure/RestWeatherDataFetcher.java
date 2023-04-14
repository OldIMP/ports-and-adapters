package com.schmeisky.apikata.infrastructure;

import com.google.gson.Gson;
import com.schmeisky.apikata.application.Result;
import com.schmeisky.apikata.application.WeatherDataFetcher;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class RestWeatherDataFetcher implements WeatherDataFetcher {
    @Override
    public Result fetch() {
        try {
            final URL url = new URL("https://apis.is/weather/observations/en?stations=1");
            try(InputStream inputStream = url.openStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)
            ) {
                return new Gson().fromJson(inputStreamReader, Result.class);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("unable to parse URL", e);
        } catch (IOException e) {
            throw new RuntimeException("unable to readData", e);
        }
    }
}
