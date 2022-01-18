plugins {
    `java-library`
    `maven-publish`
    signing
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"
}

group = "com.jamesward"
version = "0.0.5"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            pom {
                name.set("gha-central-test")
                description.set("GitHub Actions Maven Central Test")
                url.set("https://github.com/jamesward/gha-central-test")

                scm {
                    connection.set("scm:git:https://github.com/jamesward/gha-central-test.git")
                    developerConnection.set("scm:git:git@github.com:jamesward/gha-central-test.git")
                    url.set("https://github.com/jamesward/gha-central-test")
                }

                licenses {
                    license {
                        name.set("Apache 2.0")
                        url.set("https://opensource.org/licenses/Apache-2.0")
                    }
                }

                developers {
                    developer {
                        id.set("jamesward")
                        name.set("James Ward")
                        email.set("james@jamesward.com")
                        url.set("https://jamesward.com")
                    }
                }
            }

            from(components["java"])
        }
    }
}

nexusPublishing {
    repositories {
        sonatype {
            username.set(System.getenv("SONATYPE_USERNAME"))
            password.set(System.getenv("SONATYPE_PASSWORD"))
        }
    }
}

signing {
    sign(publishing.publications["mavenJava"])
    useInMemoryPgpKeys(System.getenv("GPG_PRIVATE_KEY"), System.getenv("GPG_PASSPHRASE"))
}
