package br.com.guru.domain.builders;

import br.com.guru.domain.BankTransaction;

import java.util.Date;

public class BankTransactionBuilder {
    private int id;
    private double value;
    private BankTransaction.Type type;
    private Date datetime;

    public BankTransactionBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public BankTransactionBuilder setValue(double value) {
        this.value = value;
        return this;
    }

    public BankTransactionBuilder setType(BankTransaction.Type type) {
        this.type = type;
        return this;
    }

    public BankTransactionBuilder setDatetime(Date datetime) {
        this.datetime = datetime;
        return this;
    }

    public BankTransaction createBankTransaction() {
        return new BankTransaction(id, value, type, datetime);
    }
}