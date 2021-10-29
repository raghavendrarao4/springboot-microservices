package com.springboot.service;

import com.springboot.model.ExchangeValue;

public interface ExchangeService {
	public ExchangeValue retrieveExchangeValue( String from,  String to);
	public ExchangeValue retrieveExchangeValue( String from,  String to,  Integer quantity);

}
