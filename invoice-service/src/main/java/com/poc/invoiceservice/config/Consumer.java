package com.poc.invoiceservice.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

import com.poc.commonlib.entity.Cart;
import com.poc.commonlib.entity.InvoiceDetails;
import com.poc.commonlib.entity.Product;
import com.poc.commonlib.repository.CartRepository;
import com.poc.commonlib.service.InvoiceDetailsService;

@EnableBinding(Sink.class)
public class Consumer {

	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@Autowired
	private InvoiceDetailsService invoiceService;

	@Autowired
	private CartRepository cartRepository;

	@StreamListener(target = Sink.INPUT, condition = "headers['type']=='cartId'")
	public void handle(@Payload String cartId) {
		logger.info("recieved cartId : [{}]: {}", cartId);
		Cart cart = cartRepository.findOneById(Integer.parseInt(cartId));
		if (cart != null) {
			InvoiceDetails invoiceDetails = new InvoiceDetails();
			invoiceDetails.setCart(cart);

			List<Product> products = cart.getProducts();
			double totalAmount = 0;
			for (Product product : products) {
				totalAmount = totalAmount + (product.getPrice() * product.getQuantity());
			}
			invoiceDetails.setTotalAmount(Double.toString(totalAmount));
			invoiceService.create(invoiceDetails);
		}
	}
}
