package com.poc.commonlib.service;

import java.util.List;

import com.poc.commonlib.entity.InvoiceDetails;

public interface InvoiceDetailsService {

	public void create(InvoiceDetails invoiceDetails);

	public List<InvoiceDetails> fetchAll();

	public InvoiceDetails fetchByCartId(Integer cartId);

}
