package com.springboot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.ExchangeValue;
import com.springboot.service.ExchangeService;

@RestController
@RequestMapping("/currency-exchange")
public class ExchangeController {

	@Autowired
	private ExchangeService exchangeService;
	
	final static Logger LOGGER = LogManager.getLogger(ExchangeController.class);
	
	@GetMapping("/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		LOGGER.info("*****ExchangeController.retrieveExchangeValue with from to");
		ExchangeValue exchangeValue = exchangeService.retrieveExchangeValue(from, to);		
		return exchangeValue;
	}

	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to, @PathVariable Integer quantity) {
		LOGGER.info("*****ExchangeController.retrieveExchangeValue with from to with quantity");
		ExchangeValue exchangeValue = exchangeService.retrieveExchangeValue(from, to, quantity);		
		return exchangeValue;
	}
}
