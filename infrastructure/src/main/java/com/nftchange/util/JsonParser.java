package com.nftchange.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonParser {

    private static final Gson gson = new GsonBuilder().create();

    public static <T> T fromJsonToEntity(String json, Class<T> entity) {
        return gson.fromJson(json, entity);
    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

}