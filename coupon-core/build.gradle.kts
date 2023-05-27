import org.gradle.api.internal.artifacts.dsl.dependencies.DependencyAdderExtensionModule
import org.gradle.api.internal.artifacts.dsl.dependencies.DependencyAdderExtensionModule.module
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val jar: Jar by tasks
val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks

bootJar.enabled = false
jar.enabled = true

plugins {
    kotlin("kapt")
    id("org.flywaydb.flyway") version "7.8.2"
    id ("com.ewerk.gradle.plugins.querydsl") version "1.0.10"

}

noArg {
    annotation("javax.persistence.Entity")
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}


group = "org.example"
version = "0.0.1-SNAPSHOT"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.redisson:redisson-spring-boot-starter:3.16.4")
    implementation("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.0")
    implementation("com.vladmihalcea:hibernate-types-60:2.20.0")
    implementation("com.infobip:infobip-spring-data-jpa-querydsl-boot-starter:8.0.0")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")

}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

flyway {
    url = "jdbc:mysql://localhost:3306/coupon?useUnicode=yes&characterEncoding=UTF-8&rewriteBatchedStatements=true"
    user = "wave"
    password = "0913"
}