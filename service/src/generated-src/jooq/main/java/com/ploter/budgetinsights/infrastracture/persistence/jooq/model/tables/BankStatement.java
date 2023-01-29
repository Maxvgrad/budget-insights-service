/*
 * This file is generated by jOOQ.
 */
package com.ploter.budgetinsights.infrastracture.persistence.jooq.model.tables;


import com.ploter.budgetinsights.infrastracture.persistence.jooq.model.Keys;
import com.ploter.budgetinsights.infrastracture.persistence.jooq.model.Public;
import com.ploter.budgetinsights.infrastracture.persistence.jooq.model.tables.records.BankStatementRecord;
import org.jooq.Record;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import java.util.function.Function;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BankStatement extends TableImpl<BankStatementRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.bank_statement</code>
     */
    public static final BankStatement BANK_STATEMENT = new BankStatement();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BankStatementRecord> getRecordType() {
        return BankStatementRecord.class;
    }

    /**
     * The column <code>public.bank_statement.id</code>.
     */
    public final TableField<BankStatementRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.bank_statement.name</code>.
     */
    public final TableField<BankStatementRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    private BankStatement(Name alias, Table<BankStatementRecord> aliased) {
        this(alias, aliased, null);
    }

    private BankStatement(Name alias, Table<BankStatementRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.bank_statement</code> table reference
     */
    public BankStatement(String alias) {
        this(DSL.name(alias), BANK_STATEMENT);
    }

    /**
     * Create an aliased <code>public.bank_statement</code> table reference
     */
    public BankStatement(Name alias) {
        this(alias, BANK_STATEMENT);
    }

    /**
     * Create a <code>public.bank_statement</code> table reference
     */
    public BankStatement() {
        this(DSL.name("bank_statement"), null);
    }

    public <O extends Record> BankStatement(Table<O> child, ForeignKey<O, BankStatementRecord> key) {
        super(child, key, BANK_STATEMENT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<BankStatementRecord> getPrimaryKey() {
        return Keys.BANK_STATEMENT_PKEY;
    }

    @Override
    public BankStatement as(String alias) {
        return new BankStatement(DSL.name(alias), this);
    }

    @Override
    public BankStatement as(Name alias) {
        return new BankStatement(alias, this);
    }

    @Override
    public BankStatement as(Table<?> alias) {
        return new BankStatement(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public BankStatement rename(String name) {
        return new BankStatement(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BankStatement rename(Name name) {
        return new BankStatement(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public BankStatement rename(Table<?> name) {
        return new BankStatement(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Long, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super Long, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super Long, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
