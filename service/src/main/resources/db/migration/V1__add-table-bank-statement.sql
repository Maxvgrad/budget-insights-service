CREATE TABLE IF NOT EXISTS bank_statement
(
  id   BIGINT       NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS bank_statement_id_seq AS BIGINT;

CREATE TABLE IF NOT EXISTS import_group
(
  id                 BIGINT       NOT NULL PRIMARY KEY,
  import_source_id   VARCHAR(255) NOT NULL,
  import_source_type VARCHAR(255) NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS import_group_id_seq AS BIGINT;

CREATE TABLE IF NOT EXISTS bank_transaction
(
  id              BIGINT         NOT NULL PRIMARY KEY,
  import_group_id BIGINT         NOT NULL,
  date            DATE           NOT NULL,
  amount          DECIMAL(19, 8) NOT NULL,
  currency        VARCHAR(3)     NOT NULL,
  description     VARCHAR        NOT NULL DEFAULT '',
  merchant        VARCHAR        NOT NULL DEFAULT '',
  reference       VARCHAR        NOT NULL DEFAULT '',
  account         VARCHAR        NOT NULL DEFAULT ''
);

CREATE SEQUENCE IF NOT EXISTS bank_transaction_id_seq AS BIGINT;

CREATE TABLE IF NOT EXISTS bank_transaction_classification
(
  id                           BIGINT  NOT NULL PRIMARY KEY,
  bank_transaction_id          BIGINT  NOT NULL UNIQUE,
  category_fifty_thirty_twenty VARCHAR NOT NULL DEFAULT '',
  category_detailed            VARCHAR NOT NULL DEFAULT '',
  comment                      VARCHAR NOT NULL DEFAULT ''
);

CREATE SEQUENCE IF NOT EXISTS bank_transaction_classification_id_seq AS BIGINT;