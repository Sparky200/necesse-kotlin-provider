import dev.sparky200.necesse.gradle.build_dsl.mod
import dev.sparky200.necesse.gradle.build_dsl.necesse
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("dev.sparky200.necesse-build-dsl") version "1.1.3"
}

group = "dev.sparky200"
version = "1.7.10"

repositories {
    mavenCentral()
}

dependencies {
    necesse(project, "D:/Programs/Steam/steamapps/common/Necesse")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.10")

    testImplementation(kotlin("test"))
}

mod {
    gamePath.set("D:/Programs/Steam/steamapps/common/Necesse")

    id.set("kotlin-provider-mod")
    name.set("Kotlin Provider Mod")
    version.set("1.7.10")
    description.set("Provides the Kotlin STDLib. Used to allow for minimizing jars and avoid conflicts.")
    gameVersion.set("0.21.25")
    author.set("Sparky")
}

tasks {
    jar {
        destinationDirectory.set(file("build/staging"))
        archiveFileName.set("${project.name}-${project.version}-pre_shadow.jar")
    }

    shadowJar {
        destinationDirectory.set(file("build/libs"))
        archiveFileName.set("${project.name}-${project.version}.jar")

        exclude("META-INF/**")
    }

    build {
        dependsOn(shadowJar)
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}