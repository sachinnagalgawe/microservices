package com.poc.invoiceservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.invoiceservice.config.Producer;

/**
 * Invoice controller for all rest operations related to Invoice
 */
@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

	private Producer producer;

	/**
	 * Create product
	 * 
	 * @param product
	 * @return
	 */
	@PostMapping(value = "/{cartId}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void createProduct(@PathVariable Integer cartId) {
		logger.info("Api call received to post cartId :" + cartId);
		producer.getMysource().output().send(MessageBuilder.withPayload(cartId).setHeader("type", "cartId").build());
	}
}