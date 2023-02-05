## Modifying DB schema

Service uses jOOQ to generate bindings to DB schema and use those bindings to compile SQL queries.

In order to alter DB schema and update the code one would need to:
1. Add new DB migration to `service/src/main/resources/db/migration/` folder.
1. Bring up DB docker image: `docker-compose -f service/src/test/resources/docker-compose.yml up -d -- postgres`
1. Generate jOOQ bindings for updated schema: `./gradlew generateJooq`
1. Commit DB migration and generated jOOQ classes in one go.

## Local development with Docker

```bash
docker exec -it <containerId> psql -U test -d postgres -c 'DROP DATABASE "budget-insights";'
docker exec -it <containerId> psql -U test -d postgres -c 'CREATE DATABASE "budget-insights";'
```

## Truncate tables

```sql
truncate bank_transaction, bank_transaction_classification;
```

## Upload multiple files

```bash
./scripts/file_upload.py ~/Downloads/statements
```

```bash
curl --location --request POST 'http://localhost:8080/budget-insights/transactions' \
--header 'Accept: text/csv;charset=UTF-8' \
--header 'Content-Type: application/json' \
>> ~/Downloads/bank-transactions_$(date +'%m-%d-%Y_%H:%M').csv
```