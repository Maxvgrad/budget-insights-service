import nu.studer.gradle.jooq.JooqGenerate
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jooq.meta.jaxb.Logging

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    id("war")
    id("java-library")
    id("org.flywaydb.flyway") version "9.8.1"
    id("nu.studer.jooq") version "8.0" // https://github.com/etiennestuder/gradle-jooq-plugin
}

group = "com.ploter"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    implementation("org.springframework:spring-webmvc:5.3.23")
    implementation("commons-fileupload:commons-fileupload:1.4")

    implementation("javax.servlet:javax.servlet-api:4.0.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.1")

    implementation("org.apache.commons:commons-csv:1.9.0")
    implementation("org.jooq:jooq:3.18.0-SNAPSHOT")

    implementation("com.zaxxer:HikariCP:5.0.1")
    implementation("org.flywaydb:flyway-core:9.10.1")
    jooqGenerator("org.postgresql:postgresql:42.5.0")

    // [TEST]
//    implementation("javax.servlet:jstl:1.2")
//    compileOnly("org.projectlombok:lombok")
    testImplementation("org.springframework:spring-test:5.3.23")
    testImplementation(kotlin("test-common"))
    testImplementation(kotlin("test-junit5"))
}
tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict") // https://kotlinlang.org/docs/java-interop.html#jsr-305-support
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

jooq {
    configurations {
        create("main") {  // name of the jOOQ configuration
            generateSchemaSourceOnCompilation
            jooqConfiguration.apply {
                logging = Logging.WARN
                jdbc.apply {
                    driver = "org.postgresql.Driver"
                    url = "jdbc:postgresql://localhost:5432/budget-insights"
                    user = "test"
                    password = "test"
                }
                generator.apply {
                    name = "org.jooq.codegen.DefaultGenerator"
                    database.apply {
                        name = "org.jooq.meta.postgres.PostgresDatabase"
                        inputSchema = "public"
                    }
                    generate.apply {
                        isDeprecated = false
                        isRecords = true
                        isImmutablePojos = true
                        isFluentSetters = true
                    }
                    target.apply {
                        packageName = "com.ploter.budgetinsights.infrastracture.persistence.jooq.model"
                        directory = "src/generated-src/jooq/main/java"
                    }
                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
                }
            }
        }
    }
}

gradle.taskGraph.whenReady {
    tasks.withType<JooqGenerate> {
        enabled = false
    }
}