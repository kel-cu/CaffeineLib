package ru.kelcuprum.caffeinelib;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import ru.kelcuprum.caffeinelib.utils.GsonHelper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class WebHelper {
    public static HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofSeconds(10L)).build();
    public static String getString(HttpRequest request) throws IOException, InterruptedException {
        if (httpClient == null) {
            httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).connectTimeout(Duration.ofSeconds(10L)).build();
        }

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return (String)response.body();
    }
    public static String getString(HttpRequest.Builder url) throws IOException, InterruptedException {
        return getString(url.build());
    }
    public static String getString(String url) throws IOException, InterruptedException {
        return getString(HttpRequest.newBuilder().uri(URI.create(url)).build());
    }


    public static JsonElement getJsonElement(HttpRequest url) throws IOException, InterruptedException {
        return GsonHelper.parse(getString(url));
    }
    public static JsonElement getJsonElement(HttpRequest.Builder url) throws IOException, InterruptedException {
        return getJsonObject(url.header("Content-Type", "application/json").build());
    }
    public static JsonElement getJsonElement(String url) throws IOException, InterruptedException {
        return getJsonObject(HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json").build());
    }

    public static JsonObject getJsonObject(HttpRequest url) throws IOException, InterruptedException {
        return GsonHelper.parseObject(getString(url));
    }
    public static JsonObject getJsonObject(HttpRequest.Builder url) throws IOException, InterruptedException {
        return getJsonObject(url.header("Content-Type", "application/json").build());
    }
    public static JsonObject getJsonObject(String url) throws IOException, InterruptedException {
        return getJsonObject(HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json").build());
    }

    public static JsonArray getJsonArray(HttpRequest url) throws IOException, InterruptedException {
        return GsonHelper.parseArray(getString(url));
    }
    public static JsonArray getJsonArray(HttpRequest.Builder url) throws IOException, InterruptedException {
        return getJsonArray(url.header("Content-Type", "application/json").build());
    }
    public static JsonArray getJsonArray(String url) throws IOException, InterruptedException {
        return getJsonArray(HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json").build());
    }
}
