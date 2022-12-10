import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    id("war")
    id("java-library")
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
    // https://mvnrepository.com/artifact/org.springframework/spring-web
    //    implementation("org.springframework:spring-web:5.3.22")
    // https://mvnrepository.com/artifact/org.springframework/spring-webmvc
    implementation("org.springframework:spring-webmvc:5.3.23")
//     https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api
    implementation("javax.servlet:javax.servlet-api:4.0.1")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.1")


//    implementation("javax.servlet:jstl:1.2")
//    compileOnly("org.projectlombok:lombok")
    testImplementation("org.springframework:spring-test:5.3.23")
    testImplementation(kotlin("test-common"))
    testImplementation(kotlin("test-junit5"))
}
tasks.test {
    useJUnitPlatform()
}
//kotlin {
//    jvmToolchain {
//        languageVersion.set(JavaLanguageVersion.of(17)) // "8"
//    }
//}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict") // https://kotlinlang.org/docs/java-interop.html#jsr-305-support
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
