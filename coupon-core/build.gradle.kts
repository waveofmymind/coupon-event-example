import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val jar: Jar by tasks
val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks

bootJar.enabled = false
jar.enabled = true

plugins {
    kotlin("kapt")
    id("org.flywaydb.flyway") version "7.8.2"
}

noArg {
    annotation("javax.persistence.Entity")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.redisson:redisson-spring-boot-starter:3.16.4")
    implementation("org.springframework.boot:spring-boot-configuration-processor")
    api("com.querydsl:querydsl-jpa")
    //querydsl
    implementation("com.querydsl:querydsl-core:5.0.0")
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    annotationProcessor ("com.querydsl:querydsl-apt:5.0.0:jakarta")
    implementation("com.amazonaws:aws-java-sdk-ssm")
    implementation(platform("com.amazonaws:aws-java-sdk-bom:1.11.1034"))

    kapt(group = "com.querydsl", name = "querydsl-apt", classifier = "jpa") // 2)

    sourceSets.main {
        withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
            kotlin.srcDir("$buildDir/generated/source/kapt/main")
        }
    }
    testImplementation("org.springframework.boot:spring-boot-starter-test")
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