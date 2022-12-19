## Modifying DB schema

Service uses jOOQ to generate bindings to DB schema and use those bindings to compile SQL queries.

In order to alter DB schema and update the code one would need to:
1. Add new DB migration to `service/src/main/resources/db/migration/` folder.
1. Bring up DB docker image: `docker-compose -f service/src/test/resources/docker-compose.yml up -d -- postgres`
1. Generate jOOQ bindings for updated schema: `./gradlew generateJooq`
1. Commit DB migration and generated jOOQ classes in one go.