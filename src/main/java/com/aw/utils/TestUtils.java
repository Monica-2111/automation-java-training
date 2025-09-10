package com.aw.utils;

/**
 * Utility class for common test operations
 * This demonstrates the proper Maven src/main/java structure
 */
public class TestUtils {

    /**
     * Wait for a specified number of seconds
     * @param seconds number of seconds to wait
     */
    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Wait interrupted", e);
        }
    }

    /**
     * Generate a random string of specified length
     * @param length the length of the random string
     * @return random string
     */
    public static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    /**
     * Check if a string is not null and not empty
     * @param str the string to check
     * @return true if string is not null and not empty
     */
    public static boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }
}
