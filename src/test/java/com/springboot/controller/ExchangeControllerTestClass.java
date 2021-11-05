package com.springboot.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.springboot.model.ExchangeValue;
import com.springboot.service.ExchangeService;

class ExchangeControllerTestClass {
	
	@InjectMocks 
	private static ExchangeController mockExchangeController = new ExchangeController();
	
	 @Mock
	 private ExchangeService exchangeService;
	
	private static ExchangeValue exchangeValue1;
	private static ExchangeValue exchangeValue2;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this); //without this you will get NPE
		exchangeValue1 = new ExchangeValue(1l, "eur", "inr", new BigDecimal(120));
		exchangeValue2 = new ExchangeValue(1l, "eur", "inr", new BigDecimal(120), 10);
		
	}

	@Test
	void testRetrieveExchangeValue_With_Two_Args() {

		when(exchangeService.retrieveExchangeValue("eur", "inr")).thenReturn(exchangeValue1);

		ExchangeValue exchangeValue=mockExchangeController.retrieveExchangeValue("eur", "inr");
		assertNotNull(exchangeValue);
		
        assertEquals("eur", exchangeValue.getFrom());
        assertEquals("inr", exchangeValue.getTo());
        assertEquals(new BigDecimal(120), exchangeValue.getConversionMultiple());
		}
	
	@Test
	void testRetrieveExchangeValue_With_Three_Args() {
		
		when(exchangeService.retrieveExchangeValue("eur", "inr")).thenReturn(exchangeValue1);
		when(exchangeService.retrieveExchangeValue("eur", "inr", 10)).thenReturn(exchangeValue2);

		ExchangeValue exchangeValue=mockExchangeController.retrieveExchangeValue("eur", "inr",10);
		assertNotNull(exchangeValue);
		
        assertEquals("eur", exchangeValue.getFrom());
        assertEquals("inr", exchangeValue.getTo());
        assertEquals(new BigDecimal(120), exchangeValue.getConversionMultiple());
        assertEquals(new Integer(10), exchangeValue.getQuantity());
       // assertNull(new BigDecimal(120), exchangeValue.getConvertedValue());		
		}

}
