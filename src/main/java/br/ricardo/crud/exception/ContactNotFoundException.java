package br.ricardo.crud.exception;

import java.text.MessageFormat; 

public class ContactNotFoundException extends RuntimeException {

    public ContactNotFoundException(final Long id) {
        super(MessageFormat.format("Could not find contact with id: {0}", id));
    }
}
