package com.dao;

import java.util.List;

import com.model.Invoice;

public interface InvoiceDAOInterface {
	public int createInvoice(Invoice i);

	public List<Invoice> getInvoicesByUsername(String username);
}
