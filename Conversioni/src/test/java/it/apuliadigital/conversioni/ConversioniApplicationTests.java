package it.apuliadigital.conversioni;

import it.apuliadigital.conversioni.repository.ConversionLogRepository;
import it.apuliadigital.conversioni.service.impl.ConversionServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@SpringBootTest
class ConversioniApplicationTests {

    @InjectMocks
    private ConversionServiceImpl conversionService;

    @Mock
    private ConversionLogRepository conversionLogRepository;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testingConvertIntegerToRoman() {
        int number = 3549;
        String expectedRoman = "MMMDXLIX";
        String result = conversionService.convertIntegerToRoman(number);
        assertEquals(expectedRoman, result);
        verify(conversionLogRepository).save(any());
    }

    @Test
    public void testingConvertRomanToInteger() {
        String roman = "MMMDXLIX";
        int expectedInteger = 3549;
        int result = conversionService.convertRomanToInteger(roman);
        assertEquals(expectedInteger, result);
        verify(conversionLogRepository).save(any());
    }

    @Test
    public void testingConvertIntegerToHex() {
        int number = 1234;
        String expectedHex = "4D2";
        String result = conversionService.convertIntegerToHex(number);
        assertEquals(expectedHex, result);
        verify(conversionLogRepository).save(any());
    }

    @Test
    public void testingConvertHexToInteger() {
        String hex = "4D2";
        int expectedInteger = 1234;
        int result = conversionService.convertHexToInteger(hex);
        assertEquals(expectedInteger, result);
        verify(conversionLogRepository).save(any());
    }

    @Test
    public void testingConvertIntegerToBinary() {
        int number = 42;
        String expectedBinary = "101010";
        String result = conversionService.convertIntegerToBinary(number);
        assertEquals(expectedBinary, result);
        verify(conversionLogRepository).save(any());
    }

    @Test
    public void testingConvertBinaryToInteger() {
        String binary = "101010";
        int expectedInteger = 42;
        int result = conversionService.convertBinaryToInteger(binary);
        assertEquals(expectedInteger, result);
        verify(conversionLogRepository).save(any());
    }

    @Test
    void testConvertToRoman() {
        assertEquals("I", conversionService.convertIntegerToRoman(1));
        assertNotEquals("I", conversionService.convertIntegerToRoman(2));
    }



}
