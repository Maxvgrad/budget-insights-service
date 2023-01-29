/*
 * This file is generated by jOOQ.
 */
package com.ploter.budgetinsights.infrastracture.persistence.jooq.model.tables.records;


import com.ploter.budgetinsights.infrastracture.persistence.jooq.model.tables.BankStatement;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BankStatementRecord extends UpdatableRecordImpl<BankStatementRecord> implements Record2<Long, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.bank_statement.id</code>.
     */
    public BankStatementRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.bank_statement.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.bank_statement.name</code>.
     */
    public BankStatementRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.bank_statement.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Long, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return BankStatement.BANK_STATEMENT.ID;
    }

    @Override
    public Field<String> field2() {
        return BankStatement.BANK_STATEMENT.NAME;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public BankStatementRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public BankStatementRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public BankStatementRecord values(Long value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BankStatementRecord
     */
    public BankStatementRecord() {
        super(BankStatement.BANK_STATEMENT);
    }

    /**
     * Create a detached, initialised BankStatementRecord
     */
    public BankStatementRecord(Long id, String name) {
        super(BankStatement.BANK_STATEMENT);

        setId(id);
        setName(name);
    }

    /**
     * Create a detached, initialised BankStatementRecord
     */
    public BankStatementRecord(com.ploter.budgetinsights.infrastracture.persistence.jooq.model.tables.pojos.BankStatement value) {
        super(BankStatement.BANK_STATEMENT);

        if (value != null) {
            setId(value.getId());
            setName(value.getName());
        }
    }
}
