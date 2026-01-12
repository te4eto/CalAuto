package calsuite.utils;

import com.github.javafaker.Faker;

public class RandomGenerator {

    public static com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();

    public static String generateRandomBeer() {
        Faker generateName = new Faker();
        return generateName.beer().name();
    }
}
