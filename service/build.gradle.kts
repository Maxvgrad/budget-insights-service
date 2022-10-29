import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
    id("java-library")
    id("war")
}

group = "com.ploter"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.springframework/spring-web
    //    implementation("org.springframework:spring-web:5.3.22")
    // https://mvnrepository.com/artifact/org.springframework/spring-webmvc
    implementation("org.springframework:spring-webmvc:5.3.23")
    // https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api
    compileOnly("javax.servlet:javax.servlet-api:4.0.1")

//    implementation("javax.servlet:jstl:1.2")

//    compileOnly("org.projectlombok:lombok")
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
