/*
 * This file is generated by jOOQ.
 */
package com.ploter.budgetinsights.infrastracture.persistence.jooq.model.tables.records;


import com.ploter.budgetinsights.infrastracture.persistence.jooq.model.tables.BankTransaction;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;

import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BankTransactionRecord extends UpdatableRecordImpl<BankTransactionRecord> implements Record9<Long, Long, LocalDate, BigDecimal, String, String, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.bank_transaction.id</code>.
     */
    public BankTransactionRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.bank_transaction.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.bank_transaction.import_group_id</code>.
     */
    public BankTransactionRecord setImportGroupId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.bank_transaction.import_group_id</code>.
     */
    public Long getImportGroupId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.bank_transaction.date</code>.
     */
    public BankTransactionRecord setDate(LocalDate value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.bank_transaction.date</code>.
     */
    public LocalDate getDate() {
        return (LocalDate) get(2);
    }

    /**
     * Setter for <code>public.bank_transaction.amount</code>.
     */
    public BankTransactionRecord setAmount(BigDecimal value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.bank_transaction.amount</code>.
     */
    public BigDecimal getAmount() {
        return (BigDecimal) get(3);
    }

    /**
     * Setter for <code>public.bank_transaction.currency</code>.
     */
    public BankTransactionRecord setCurrency(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.bank_transaction.currency</code>.
     */
    public String getCurrency() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.bank_transaction.description</code>.
     */
    public BankTransactionRecord setDescription(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.bank_transaction.description</code>.
     */
    public String getDescription() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.bank_transaction.merchant</code>.
     */
    public BankTransactionRecord setMerchant(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.bank_transaction.merchant</code>.
     */
    public String getMerchant() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.bank_transaction.reference</code>.
     */
    public BankTransactionRecord setReference(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.bank_transaction.reference</code>.
     */
    public String getReference() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.bank_transaction.account</code>.
     */
    public BankTransactionRecord setAccount(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.bank_transaction.account</code>.
     */
    public String getAccount() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, Long, LocalDate, BigDecimal, String, String, String, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Long, Long, LocalDate, BigDecimal, String, String, String, String, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return BankTransaction.BANK_TRANSACTION.ID;
    }

    @Override
    public Field<Long> field2() {
        return BankTransaction.BANK_TRANSACTION.IMPORT_GROUP_ID;
    }

    @Override
    public Field<LocalDate> field3() {
        return BankTransaction.BANK_TRANSACTION.DATE;
    }

    @Override
    public Field<BigDecimal> field4() {
        return BankTransaction.BANK_TRANSACTION.AMOUNT;
    }

    @Override
    public Field<String> field5() {
        return BankTransaction.BANK_TRANSACTION.CURRENCY;
    }

    @Override
    public Field<String> field6() {
        return BankTransaction.BANK_TRANSACTION.DESCRIPTION;
    }

    @Override
    public Field<String> field7() {
        return BankTransaction.BANK_TRANSACTION.MERCHANT;
    }

    @Override
    public Field<String> field8() {
        return BankTransaction.BANK_TRANSACTION.REFERENCE;
    }

    @Override
    public Field<String> field9() {
        return BankTransaction.BANK_TRANSACTION.ACCOUNT;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getImportGroupId();
    }

    @Override
    public LocalDate component3() {
        return getDate();
    }

    @Override
    public BigDecimal component4() {
        return getAmount();
    }

    @Override
    public String component5() {
        return getCurrency();
    }

    @Override
    public String component6() {
        return getDescription();
    }

    @Override
    public String component7() {
        return getMerchant();
    }

    @Override
    public String component8() {
        return getReference();
    }

    @Override
    public String component9() {
        return getAccount();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getImportGroupId();
    }

    @Override
    public LocalDate value3() {
        return getDate();
    }

    @Override
    public BigDecimal value4() {
        return getAmount();
    }

    @Override
    public String value5() {
        return getCurrency();
    }

    @Override
    public String value6() {
        return getDescription();
    }

    @Override
    public String value7() {
        return getMerchant();
    }

    @Override
    public String value8() {
        return getReference();
    }

    @Override
    public String value9() {
        return getAccount();
    }

    @Override
    public BankTransactionRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public BankTransactionRecord value2(Long value) {
        setImportGroupId(value);
        return this;
    }

    @Override
    public BankTransactionRecord value3(LocalDate value) {
        setDate(value);
        return this;
    }

    @Override
    public BankTransactionRecord value4(BigDecimal value) {
        setAmount(value);
        return this;
    }

    @Override
    public BankTransactionRecord value5(String value) {
        setCurrency(value);
        return this;
    }

    @Override
    public BankTransactionRecord value6(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public BankTransactionRecord value7(String value) {
        setMerchant(value);
        return this;
    }

    @Override
    public BankTransactionRecord value8(String value) {
        setReference(value);
        return this;
    }

    @Override
    public BankTransactionRecord value9(String value) {
        setAccount(value);
        return this;
    }

    @Override
    public BankTransactionRecord values(Long value1, Long value2, LocalDate value3, BigDecimal value4, String value5, String value6, String value7, String value8, String value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BankTransactionRecord
     */
    public BankTransactionRecord() {
        super(BankTransaction.BANK_TRANSACTION);
    }

    /**
     * Create a detached, initialised BankTransactionRecord
     */
    public BankTransactionRecord(Long id, Long importGroupId, LocalDate date, BigDecimal amount, String currency, String description, String merchant, String reference, String account) {
        super(BankTransaction.BANK_TRANSACTION);

        setId(id);
        setImportGroupId(importGroupId);
        setDate(date);
        setAmount(amount);
        setCurrency(currency);
        setDescription(description);
        setMerchant(merchant);
        setReference(reference);
        setAccount(account);
    }

    /**
     * Create a detached, initialised BankTransactionRecord
     */
    public BankTransactionRecord(com.ploter.budgetinsights.infrastracture.persistence.jooq.model.tables.pojos.BankTransaction value) {
        super(BankTransaction.BANK_TRANSACTION);

        if (value != null) {
            setId(value.getId());
            setImportGroupId(value.getImportGroupId());
            setDate(value.getDate());
            setAmount(value.getAmount());
            setCurrency(value.getCurrency());
            setDescription(value.getDescription());
            setMerchant(value.getMerchant());
            setReference(value.getReference());
            setAccount(value.getAccount());
        }
    }
}
