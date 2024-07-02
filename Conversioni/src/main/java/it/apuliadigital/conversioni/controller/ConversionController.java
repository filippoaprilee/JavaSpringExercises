package it.apuliadigital.conversioni.controller;

import it.apuliadigital.conversioni.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/conversion")
public class ConversionController {

    @Autowired
    private ConversionService conversionService;

    @GetMapping("/integer-to-roman/{number}")
    public String integerToRoman(@PathVariable int number) {
        return conversionService.convertIntegerToRoman(number);
    }

    @GetMapping("/roman-to-integer/{roman}")
    public int romanToInteger(@PathVariable String roman) {
        return conversionService.convertRomanToInteger(roman);
    }

    @GetMapping("/integer-to-hex/{number}")
    public String integerToHex(@PathVariable int number) {
        return conversionService.convertIntegerToHex(number);
    }

    @GetMapping("/hex-to-integer/{hex}")
    public int hexToInteger(@PathVariable String hex) {
        return conversionService.convertHexToInteger(hex);
    }

    @GetMapping("/integer-to-binary/{number}")
    public String integerToBinary(@PathVariable int number) {
        return conversionService.convertIntegerToBinary(number);
    }

    @GetMapping("/binary-to-integer/{binary}")
    public int binaryToInteger(@PathVariable String binary) {
        return conversionService.convertBinaryToInteger(binary);
    }
}