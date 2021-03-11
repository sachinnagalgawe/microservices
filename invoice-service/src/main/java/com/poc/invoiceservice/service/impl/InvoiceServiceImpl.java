package com.poc.invoiceservice.service.impl;

import org.springframework.stereotype.Service;

import com.poc.invoiceservice.config.Consumer;
import com.poc.invoiceservice.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	private Consumer consumer;
	
	public void sendInvoiceRequestForCartId(Integer cartId) {
	}
}
