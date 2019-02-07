import com.lightningkite.konvenience.gradle.*
import java.util.Properties

plugins {
    kotlin("multiplatform") version "1.3.21"
    `maven-publish`
    id("com.lightningkite.konvenience") version "0.0.2"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://dl.bintray.com/lightningkite/com.lightningkite.krosslin")
}

val versions = Properties().apply {
    load(project.file("versions.properties").inputStream())
}

group = "com.lightningkite"
version = versions.getProperty(project.name)

kotlin {
    all()

    sources {
        main {
            mpp(standardLibrary)
        }
        test {
            mpp(testing)
            mpp(testingAnnotations)
//            mpp(mavenDashPlatform("com.lightningkite", "kommon", "0.0.2"))
        }
        isNonNative.sources {
            isJvm.sources {}
            isJs.sources {}
        }
        isNative.sources {}
        isMacosX64.sources {
            main {
                kotlin.srcDir("src/nativeMain/kotlin")
            }
        }
    }
}

publishing {
    repositories {
        bintray(
                project = project,
                organization = "lightningkite",
                repository = "com.lightningkite.krosslin"
        )
    }

    appendToPoms {
        github("lightningkite", project.name)
        licenseMIT()
        developers {
            developer {
                id.set("UnknownJoe796")
                name.set("Joseph Ivie")
                email.set("joseph@lightningkite.com")
                timezone.set("America/Denver")
                roles.set(listOf("architect", "developer"))
                organization.set("Lightning Kite")
                organizationUrl.set("http://www.lightningkite.com")
            }
        }
    }
}
