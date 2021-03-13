package com.poc.invoiceservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.commonlib.entity.InvoiceDetails;
import com.poc.commonlib.service.InvoiceDetailsService;
import com.poc.invoiceservice.config.Producer;

/**
 * Invoice controller for all rest operations related to Invoice
 */
@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

	@Autowired
	private Producer producer;

	@Autowired
	private InvoiceDetailsService invoiceService;

	/**
	 * Create product
	 * 
	 * @param product
	 * @return
	 */
	@PostMapping(value = "/{cartId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void createInvoice(@PathVariable Integer cartId) {
		logger.info("Api call received to post cartId :" + cartId);
		producer.getMysource().output().send(MessageBuilder.withPayload(cartId).setHeader("type", "cartId").build());
	}

	/**
	 * Get invoice for cartId
	 * 
	 * @param cartId
	 */
	@GetMapping(value = "/{cartId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public InvoiceDetails fetchInvoice(@PathVariable Integer cartId) {
		logger.info("Api call received to get invoice details for cartId :" + cartId);
		return invoiceService.fetchByCartId(cartId);
	}
}