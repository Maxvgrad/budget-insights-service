/*
 * This file is generated by jOOQ.
 */
package com.ploter.budgetinsights.infrastracture.persistence.jooq.model.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BankTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long id;
    private final Long importGroupId;
    private final LocalDate date;
    private final BigDecimal amount;
    private final String currency;
    private final String description;
    private final String merchant;
    private final String reference;
    private final String account;

    public BankTransaction(BankTransaction value) {
        this.id = value.id;
        this.importGroupId = value.importGroupId;
        this.date = value.date;
        this.amount = value.amount;
        this.currency = value.currency;
        this.description = value.description;
        this.merchant = value.merchant;
        this.reference = value.reference;
        this.account = value.account;
    }

    public BankTransaction(
        Long id,
        Long importGroupId,
        LocalDate date,
        BigDecimal amount,
        String currency,
        String description,
        String merchant,
        String reference,
        String account
    ) {
        this.id = id;
        this.importGroupId = importGroupId;
        this.date = date;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
        this.merchant = merchant;
        this.reference = reference;
        this.account = account;
    }

    /**
     * Getter for <code>public.bank_transaction.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Getter for <code>public.bank_transaction.import_group_id</code>.
     */
    public Long getImportGroupId() {
        return this.importGroupId;
    }

    /**
     * Getter for <code>public.bank_transaction.date</code>.
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * Getter for <code>public.bank_transaction.amount</code>.
     */
    public BigDecimal getAmount() {
        return this.amount;
    }

    /**
     * Getter for <code>public.bank_transaction.currency</code>.
     */
    public String getCurrency() {
        return this.currency;
    }

    /**
     * Getter for <code>public.bank_transaction.description</code>.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Getter for <code>public.bank_transaction.merchant</code>.
     */
    public String getMerchant() {
        return this.merchant;
    }

    /**
     * Getter for <code>public.bank_transaction.reference</code>.
     */
    public String getReference() {
        return this.reference;
    }

    /**
     * Getter for <code>public.bank_transaction.account</code>.
     */
    public String getAccount() {
        return this.account;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final BankTransaction other = (BankTransaction) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        }
        else if (!this.id.equals(other.id))
            return false;
        if (this.importGroupId == null) {
            if (other.importGroupId != null)
                return false;
        }
        else if (!this.importGroupId.equals(other.importGroupId))
            return false;
        if (this.date == null) {
            if (other.date != null)
                return false;
        }
        else if (!this.date.equals(other.date))
            return false;
        if (this.amount == null) {
            if (other.amount != null)
                return false;
        }
        else if (!this.amount.equals(other.amount))
            return false;
        if (this.currency == null) {
            if (other.currency != null)
                return false;
        }
        else if (!this.currency.equals(other.currency))
            return false;
        if (this.description == null) {
            if (other.description != null)
                return false;
        }
        else if (!this.description.equals(other.description))
            return false;
        if (this.merchant == null) {
            if (other.merchant != null)
                return false;
        }
        else if (!this.merchant.equals(other.merchant))
            return false;
        if (this.reference == null) {
            if (other.reference != null)
                return false;
        }
        else if (!this.reference.equals(other.reference))
            return false;
        if (this.account == null) {
            if (other.account != null)
                return false;
        }
        else if (!this.account.equals(other.account))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.importGroupId == null) ? 0 : this.importGroupId.hashCode());
        result = prime * result + ((this.date == null) ? 0 : this.date.hashCode());
        result = prime * result + ((this.amount == null) ? 0 : this.amount.hashCode());
        result = prime * result + ((this.currency == null) ? 0 : this.currency.hashCode());
        result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
        result = prime * result + ((this.merchant == null) ? 0 : this.merchant.hashCode());
        result = prime * result + ((this.reference == null) ? 0 : this.reference.hashCode());
        result = prime * result + ((this.account == null) ? 0 : this.account.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("BankTransaction (");

        sb.append(id);
        sb.append(", ").append(importGroupId);
        sb.append(", ").append(date);
        sb.append(", ").append(amount);
        sb.append(", ").append(currency);
        sb.append(", ").append(description);
        sb.append(", ").append(merchant);
        sb.append(", ").append(reference);
        sb.append(", ").append(account);

        sb.append(")");
        return sb.toString();
    }
}
