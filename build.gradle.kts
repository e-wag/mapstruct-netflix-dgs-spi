import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    `maven-publish`
}

group = "com.ewag.mapstruct.netflix.dgs.spi"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.mapstruct:mapstruct-processor:1.5.2.Final")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

publishing {

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/e-wag/mapstruct-netflix-dgs-spi")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.token") as String? ?: System.getenv("TOKEN")
            }
        }
    }

    publications {
        create<MavenPublication>("maven") { // For local publication
            from(components["java"])
        }

        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }

}
