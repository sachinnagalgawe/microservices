package com.poc.commonlib.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.commonlib.entity.InvoiceDetails;
import com.poc.commonlib.repository.InvoiceDetailsRepository;
import com.poc.commonlib.service.InvoiceDetailsService;

@Service
public class InvoiceDetailsServiceImpl implements InvoiceDetailsService {

	@Autowired
	InvoiceDetailsRepository invoiceDetailsRepository;
	
	@Override
	public void create(InvoiceDetails invoiceDetails) {
		invoiceDetailsRepository.save(invoiceDetails);
	}

	@Override
	public List<InvoiceDetails> fetchAll() {
		return (List<InvoiceDetails>) invoiceDetailsRepository.findAll();
	}

	@Override
	public InvoiceDetails fetchByCartId(Integer cartId) {
		return invoiceDetailsRepository.findOneByCartId(cartId);
	}

}
