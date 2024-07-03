package it.apuliadigital.conversioni.service.impl;

import it.apuliadigital.conversioni.entity.ConversionLog;
import it.apuliadigital.conversioni.repository.ConversionLogRepository;
import it.apuliadigital.conversioni.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class ConversionServiceImpl implements ConversionService {

    private static final int[] INTEGERS = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private static final String[] ROMANS = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    @Autowired
    private ConversionLogRepository conversionLogRepository;

    @Override
    public String convertIntegerToRoman(int number) {
        if (number <= 0) return "";
        StringBuilder roman = new StringBuilder();
        int originalNumber = number;
        for (int i = INTEGERS.length - 1; i >= 0; i--) {
            while (number >= INTEGERS[i]) {
                roman.append(ROMANS[i]);
                number -= INTEGERS[i];
            }
        }
        saveLog("/integer-to-roman/" + originalNumber, "Converted to Roman: " + roman);
        return roman.toString();
    }

    @Override
    public int convertRomanToInteger(String roman) {
        if (roman == null || roman.isEmpty()) return 0;
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        for (int i = 0; i < roman.length(); i++) {
            int value = romanMap.get(roman.charAt(i));
            if (i < roman.length() - 1 && value < romanMap.get(roman.charAt(i + 1))) {
                total -= value;
            } else {
                total += value;
            }
        }
        saveLog("/roman-to-integer/" + roman, "Converted to Integer: " + total);
        return total;
    }

    @Override
    public String convertIntegerToHex(int number) {
        if (number == 0) {
            return "0";
        }

        StringBuilder hex = new StringBuilder();
        int originalNumber = number;
        int remainder;
        while (number > 0) {
            remainder = number % 16;
            if (remainder < 10) {
                hex.insert(0, remainder);
            } else {
                hex.insert(0, (char) ('A' + remainder - 10));
            }
            number = number / 16;
        }
        saveLog("/integer-to-hex/" + originalNumber, "Converted to Hex: " + hex);
        return hex.toString();
    }

    @Override
    public int convertHexToInteger(String hex) {
        if (hex == null || hex.isEmpty()) {
            throw new IllegalArgumentException("Hexadecimal string is null or empty");
        }

        int decimal = 0;
        for (int i = 0; i < hex.length(); i++) {
            char digit = hex.charAt(i);
            if (digit >= '0' && digit <= '9') {
                decimal = decimal * 16 + (digit - '0');
            } else if (digit >= 'A' && digit <= 'F') {
                decimal = decimal * 16 + (digit - 'A' + 10);
            } else {
                throw new IllegalArgumentException("Invalid hexadecimal character: " + digit);
            }
        }
        saveLog("/hex-to-integer/" + hex, "Converted to Integer: " + decimal);
        return decimal;
    }

    @Override
    public String convertIntegerToBinary(int number) {
        if (number == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();
        int originalNumber = number;
        while (number > 0) {
            binary.insert(0, number % 2);
            number = number / 2;
        }
        saveLog("/integer-to-binary/" + originalNumber, "Converted to Binary: " + binary);
        return binary.toString();
    }

    @Override
    public int convertBinaryToInteger(String binary) {
        if (binary == null || binary.isEmpty()) {
            throw new IllegalArgumentException("Binary string is null or empty");
        }

        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            char digit = binary.charAt(i);
            if (digit != '0' && digit != '1') {
                throw new IllegalArgumentException("Invalid binary character: " + digit);
            }
            decimal = decimal * 2 + (digit - '0');
        }
        saveLog("/binary-to-integer/" + binary, "Converted to Integer: " + decimal);
        return decimal;
    }

    private void saveLog(String path, String message) {
        ConversionLog log = new ConversionLog();
        log.setPath(path);
        log.setMessage(message);
        log.setTimestamp(LocalDateTime.now());
        conversionLogRepository.save(log);
    }
}
