package br.ricardo.crud.exception;

import java.text.MessageFormat;

public class CustomerIsAlreadyAssignedException extends RuntimeException {
    
    public CustomerIsAlreadyAssignedException(final Long id) {
        super(MessageFormat.format("Customer: {0} is already assigned in the customers table", id));
    }

}
