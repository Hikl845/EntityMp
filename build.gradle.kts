plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Hibernate ORM
    implementation("org.hibernate.orm:hibernate-core:6.4.4.Final")

    // MySQL драйвер (для продакшн)
    implementation("mysql:mysql-connector-j:8.0.34")

    // H2 база для тестів і швидкого запуску
    implementation("com.h2database:h2:2.2.220")

    // Flyway для міграцій
    implementation("org.flywaydb:flyway-core:9.23.0")

    // JUnit 5 для тестування
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}