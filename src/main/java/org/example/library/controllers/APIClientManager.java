package org.example.library.controllers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class APIClientManager {

    private static final Map<Class<?>, ApiClient> clientCache = new ConcurrentHashMap<>();

    public static <T extends ApiClient> T getClient(Class<T> clientClass) {
        ApiClient clientInstance = clientCache.computeIfAbsent(clientClass, key -> createClientInstance(clientClass));

        return clientClass.cast(clientInstance);
    }

    private static <T extends ApiClient> T createClientInstance(Class<T> clientClass) {
        try {
            return clientClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create client: " + clientClass.getSimpleName(), e);
        }
    }
}
