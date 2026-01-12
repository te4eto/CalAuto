package calsuite.utils;

import java.lang.reflect.Field;
import java.util.*;

public class ModelValidator {

    public static void validateModels(Object expected, Object actual) throws IllegalAccessException {
        Class<?> expectedClass = expected.getClass();
        Class<?> actualClass   = actual.getClass();

        Field[] expectedFields = expectedClass.getDeclaredFields();

        for (Field expectedField : expectedFields) {
            expectedField.setAccessible(true);
            String fieldName = expectedField.getName();

            try {
                Field actualField = actualClass.getDeclaredField(fieldName);
                actualField.setAccessible(true);

                Object expectedValue = expectedField.get(expected);
                Object actualValue   = actualField.get(actual);

                validateFieldValues(fieldName, expectedValue, actualValue);

            } catch (NoSuchFieldException e) {
                System.out.println("Field " + fieldName + " not found in actual object, skipping.");
            }
        }
    }

    private static void validateFieldValues(String fieldName, Object expected, Object actual) {
        if (bothAreNull(expected, actual)) return;

        if (oneIsNull(expected, actual)) {
            throw new AssertionError(formatErrorMessage(fieldName, expected, actual));
        }

        if (bothAreArrays(expected, actual)) {
            validateArrayValues(fieldName, expected, actual);
            return;
        }

        if (bothAreCollections(expected, actual)) {
            validateCollectionValues(fieldName, (Collection<?>) expected, (Collection<?>) actual);
            return;
        }

        validateGeneralValues(fieldName, expected, actual);
    }

    private static boolean bothAreNull(Object expected, Object actual) {
        return expected == null && actual == null;
    }

    private static boolean oneIsNull(Object expected, Object actual) {
        return expected == null || actual == null;
    }

    private static boolean bothAreArrays(Object expected, Object actual) {
        return expected.getClass().isArray() && actual.getClass().isArray();
    }

    private static boolean bothAreCollections(Object expected, Object actual) {
        return expected instanceof Collection && actual instanceof Collection;
    }

    private static void validateCollectionValues(String fieldName, Collection<?> expected, Collection<?> actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionError(formatErrorMessage(fieldName, expected, actual));
        }
    }

    private static void validateGeneralValues(String fieldName, Object expected, Object actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionError(formatErrorMessage(fieldName, expected, actual));
        }
    }

    private static void validateArrayValues(String fieldName, Object expected, Object actual) {
        // deepEquals handles Object[] and primitive arrays
        boolean match = Arrays.deepEquals(toObjectArray(expected), toObjectArray(actual));
        if (!match) {
            throw new AssertionError(formatErrorMessage(
                    fieldName,
                    Arrays.toString(toObjectArray(expected)),
                    Arrays.toString(toObjectArray(actual))
            ));
        }
    }

    // safely turn any array (primitive or Object) into Object[]
    private static Object[] toObjectArray(Object array) {
        if (array instanceof Object[]) return (Object[]) array;
        int length = java.lang.reflect.Array.getLength(array);
        Object[] output = new Object[length];
        for (int i = 0; i < length; i++) {
            output[i] = java.lang.reflect.Array.get(array, i);
        }
        return output;
    }

    private static String formatErrorMessage(String fieldName, Object expected, Object actual) {
        return String.format("Field %s does not match: expected=%s, actual=%s", fieldName, expected, actual);
    }
}
