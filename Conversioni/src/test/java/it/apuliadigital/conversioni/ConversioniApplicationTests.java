package it.apuliadigital.conversioni;

import it.apuliadigital.conversioni.repository.ConversionLogRepository;
import it.apuliadigital.conversioni.service.impl.ConversionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
        assertEquals("I", conversionService.convertIntegerToRoman(1));
        assertNotEquals("I", conversionService.convertIntegerToRoman(2));
    }

    @Test
    public void testingConvertRomanToInteger() {
        assertEquals(1, conversionService.convertRomanToInteger("I"));
        assertNotEquals(1, conversionService.convertRomanToInteger("II"));
    }

    @Test
    public void testingConvertIntegerToHex() {
        assertEquals("4D2", conversionService.convertIntegerToHex(1234));
        assertNotEquals("4D2", conversionService.convertIntegerToHex(1235));
    }

    @Test
    public void testingConvertHexToInteger() {
        assertEquals(1234, conversionService.convertHexToInteger("4D2"));
        assertNotEquals(1234, conversionService.convertHexToInteger("4D3"));
    }

    @Test
    public void testingConvertIntegerToBinary() {
        assertEquals("101010", conversionService.convertIntegerToBinary(42));
        assertNotEquals("101010", conversionService.convertIntegerToBinary(43));
    }

    @Test
    public void testingConvertBinaryToInteger() {
        assertEquals(42, conversionService.convertBinaryToInteger("101010"));
        assertNotEquals(42, conversionService.convertBinaryToInteger("101011"));
    }

    @Test
    void testConvertToRoman() {
        assertEquals("I", conversionService.convertIntegerToRoman(1));
        assertNotEquals("I", conversionService.convertIntegerToRoman(2));
    }



}
