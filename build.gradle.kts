plugins {
    id ("org.springframework.boot") version "3.1.4"
    id ("io.spring.dependency-management") version "1.0.15.RELEASE"
    id("java")
}

group = "ru.iagodka15"
version = "1.0-SNAPSHOT"
var sourceCompatibility = "23"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}