package com.springboot.serviceImpl;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.springboot.model.ExchangeValue;
import com.springboot.service.ExchangeService;

@Service
@PropertySource("classpath:application.properties")
public class ExchangeServiceImpl implements ExchangeService {
	
	final static Logger LOGGER = LogManager.getLogger(ExchangeServiceImpl.class);
	
	@Autowired
	private Environment environment;
	
	public ExchangeValue retrieveExchangeValue( String from,  String to,  Integer quantity) {
		LOGGER.info("*****ExchangeServiceImpl.retrieveExchangeValue with parameters - from:{}  to:{} with quantity{}", from, to, quantity);
		ExchangeValue exchangeValue = new ExchangeValue(1l,from,to,new BigDecimal(environment.getProperty("conversionFactor1")),quantity); 
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		exchangeValue.setConvertedValue(exchangeValue.getConversionMultiple().multiply(new BigDecimal(quantity)));
		return exchangeValue;		
	}
	
	public ExchangeValue retrieveExchangeValue( String from,  String to) {
		LOGGER.info("*****ExchangeServiceImpl.retrieveExchangeValue with with parameters - from:{}  to:{} ", from, to);
		ExchangeValue exchangeValue = new ExchangeValue(1l,from,to,new BigDecimal(environment.getProperty("conversionFactor1"))); 
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		exchangeValue.setConvertedValue(exchangeValue.getConversionMultiple().multiply(new BigDecimal(1)));
		exchangeValue.setQuantity(1);
		return exchangeValue;		
	}
}
