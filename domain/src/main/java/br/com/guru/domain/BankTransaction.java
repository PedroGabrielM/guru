package br.com.guru.domain;

import java.util.Date;

public class BankTransaction {

    private int id;
    private double value;
    private Type type;
    private Date datetime;

    public enum Type{
        DEPOSIT,
        WITHDRAW
    }

    public BankTransaction(int id, double value, Type type, Date datetime) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.datetime = datetime;
    }

    public BankTransaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}


