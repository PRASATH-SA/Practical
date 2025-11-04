package seventh;
import java.util.Scanner;

public class CRC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input data bits and generator polynomial
        System.out.print("Enter data bits: ");
        String data = sc.next();
        System.out.print("Enter generator polynomial: ");
        String generator = sc.next();

        // Calculate CRC and display transmitted data
        String transmittedData = calculateCRC(data, generator);
        System.out.println("Transmitted Data: " + transmittedData);

        // Input received data and check for errors
        System.out.print("Enter received data: ");
        String receivedData = sc.next();
        if (checkError(receivedData, generator)) {
            System.out.println("No error detected.");
        } else {
            System.out.println("Error detected in received data!");
        }

        sc.close();
    }

    // Method to calculate CRC and append to data
    public static String calculateCRC(String data, String generator) {
        int genLength = generator.length();
        StringBuilder paddedData = new StringBuilder(data);

        // Append zeros to match generator length
        for (int i = 0; i < genLength - 1; i++) {
            paddedData.append('0');
        }

        // Perform XOR division
        for (int i = 0; i <= paddedData.length() - genLength;) {
            for (int j = 0; j < genLength; j++) {
                paddedData.setCharAt(i + j, paddedData.charAt(i + j) == generator.charAt(j) ? '0' : '1');
            }
            while (i < paddedData.length() && paddedData.charAt(i) == '0') {
                i++;
            }
        }

        // Extract remainder and append to original data
        String crc = paddedData.substring(paddedData.length() - genLength + 1);
        return data + crc;
    }

    // Method to check for errors in received data
    public static boolean checkError(String receivedData, String generator) {
        int genLength = generator.length();
        StringBuilder temp = new StringBuilder(receivedData);

        // Perform XOR division
        for (int i = 0; i <= temp.length() - genLength;) {
            for (int j = 0; j < genLength; j++) {
                temp.setCharAt(i + j, temp.charAt(i + j) == generator.charAt(j) ? '0' : '1');
            }
            while (i < temp.length() && temp.charAt(i) == '0') {
                i++;
            }
        }

        // Check if remainder is all zeros
        for (int i = temp.length() - genLength + 1; i < temp.length(); i++) {
            if (temp.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
}
