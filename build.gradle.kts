import com.adarshr.gradle.testlogger.theme.ThemeType

plugins {
    java
    id("org.springframework.boot") version "4.1.0"
    id("io.spring.dependency-management") version "1.1.7"
    id("com.diffplug.spotless") version "8.9.0"
    id("com.adarshr.test-logger") version "4.0.0"
}

group = "com.emelgoza"
version = "0.0.1-SNAPSHOT"
description = "springboot-4-framework-7-course"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

spotless.java {
    targetExclude("build/**")
    target("src/**/*.java")
    googleJavaFormat("1.36.1")
    removeUnusedImports()
    trimTrailingWhitespace()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-h2console")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("com.h2database:h2")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-data-jpa-test")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testCompileOnly("org.projectlombok:lombok")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testAnnotationProcessor("org.projectlombok:lombok")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

testlogger {
    theme = ThemeType.STANDARD
    logLevel = LogLevel.LIFECYCLE
    // Failures show full exceptions and causes
    showExceptions = true
    showStackTraces = true
    showFullStackTraces = true
    showCauses = true
    // Highlight slow tests over 2 seconds
    slowThreshold = 2000
    // Generates the table summary with total counts (passed, skipped, failed)
    showSummary = true
    // Hides individual test names that passed or skipped to keep output clean
    showPassed = false
    showSkipped = false
    showFailed = true
    // Additional visibility preferences
    showSimpleNames = false
    showOnlySlow = false
    showStandardStreams = false
    showPassedStandardStreams = false
    showSkippedStandardStreams = false
    showFailedStandardStreams = true
}