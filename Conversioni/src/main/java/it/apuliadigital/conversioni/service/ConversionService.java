package it.apuliadigital.conversioni.service;

public interface ConversionService {
    String convertIntegerToRoman(int number);
    int convertRomanToInteger(String roman);
    String convertIntegerToHex(int number);
    int convertHexToInteger(String hex);
    String convertIntegerToBinary(int number);
    int convertBinaryToInteger(String binary);
}
