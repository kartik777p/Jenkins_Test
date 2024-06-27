package com.nit.utils;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

public class RandomIdGenerator {

    private static final AtomicInteger counter = new AtomicInteger(new SecureRandom().nextInt());

    public static String generateRandomId() {
        int machineIdentifier = generateMachineIdentifier();
        int processIdentifier = generateProcessIdentifier();

        // 4-byte timestamp (seconds since epoch)
        int timestamp = (int) Instant.now().getEpochSecond();

        // 5-byte random value
        int randomValue = new SecureRandom().nextInt();

        // 3-byte incrementing counter
        int counterValue = counter.getAndIncrement() & 0x00ffffff;

        // Combine all parts into a 12-byte hexadecimal string
        return String.format("%08x%04x%04x%06x", timestamp, machineIdentifier, processIdentifier, counterValue);
    }

    private static int generateMachineIdentifier() {
        // Simulate a machine identifier, replace with actual logic if needed
        return new SecureRandom().nextInt(0x10000);
    }

    private static int generateProcessIdentifier() {
        // Simulate a process identifier, replace with actual logic if needed
        return new SecureRandom().nextInt(0x10000);
    }

	/*
	 * public static void main(String[] args) { // Example usage String randomId =
	 * generateRandomId(); System.out.println("Generated Random ID: " + randomId); }
	 */
}
