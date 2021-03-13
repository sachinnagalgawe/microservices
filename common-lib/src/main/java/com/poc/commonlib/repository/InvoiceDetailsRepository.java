package com.poc.commonlib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.poc.commonlib.entity.InvoiceDetails;

@Repository
public interface InvoiceDetailsRepository extends CrudRepository<InvoiceDetails, Integer> {

	public InvoiceDetails findOneByCartId(Integer cartId);
}
