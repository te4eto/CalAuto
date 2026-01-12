plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("io.rest-assured:rest-assured:5.5.1")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")

    implementation("org.projectlombok:lombok:1.18.36")

    compileOnly("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")

    testCompileOnly("org.projectlombok:lombok:1.18.36")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.36")

    testImplementation("org.testng:testng:7.11.0")

}

tasks.test {
    useTestNG()
}