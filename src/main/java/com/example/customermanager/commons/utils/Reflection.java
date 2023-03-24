package com.example.customermanager.commons.utils;

import com.example.customermanager.commons.annotation.AnnotationExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Objects;

public class Reflection {
    private static Reflection instance;

    private Reflection() {}

    public static synchronized Reflection instance() {
        if (Objects.isNull(instance)) {
            instance = new Reflection();
        }

        return instance;
    }

    public <T> T convert(final Object payload, final Class<T> tClass) {
        Gson gson = createGson();

        final String json = gson.toJson(payload);
        return gson.fromJson(json, tClass);
    }

    public String json(final Object payload) {
        return createGson().toJson(payload);
    }

    private Gson createGson() {
        return new GsonBuilder()
                .setExclusionStrategies(new AnnotationExclusionStrategy())
                .setDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ")
                .create();
    }
}
