import nebula.plugin.contacts.Contact


plugins {
    // Apply the Java Gradle plugin development plugin to add support for developing Gradle plugins
    `java-gradle-plugin`

    // Apply the Kotlin JVM plugin to add support for Kotlin.
    alias(libs.plugins.jvm)

    id("nebula.maven-nebula-publish")
    id("nebula.contacts")
    id("com.github.ben-manes.versions")
}

dependencies {

    implementation("com.netflix.nebula:nebula-publishing-plugin:${findProperty("nebulaMavenPublish")}")

    // Use the Kotlin JUnit 5 integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

gradlePlugin {
    // Define the plugin
    val greeting by plugins.creating {
        id = "beaver.publishing"
        implementationClass = "org.beaver.publishing.BeaverPublishingPlugin"
    }
}

// Add a source set for the functional test suite
val functionalTestSourceSet = sourceSets.create("functionalTest") {
}

configurations["functionalTestImplementation"].extendsFrom(configurations["testImplementation"])
configurations["functionalTestRuntimeOnly"].extendsFrom(configurations["testRuntimeOnly"])

// Add a task to run the functional tests
val functionalTest by tasks.registering(Test::class) {
    testClassesDirs = functionalTestSourceSet.output.classesDirs
    classpath = functionalTestSourceSet.runtimeClasspath
    useJUnitPlatform()
}

gradlePlugin.testSourceSets.add(functionalTestSourceSet)

tasks.named<Task>("check") {
    // Run the functional tests as part of `check`
    dependsOn(functionalTest)
}

tasks.named<Test>("test") {
    // Use JUnit Jupiter for unit tests.
    useJUnitPlatform()
}

contacts{
    addPerson("cunha@marcosalves.dev", delegateClosureOf<Contact>{
        slack = "Marcos Alves Cunha"
        moniker = "Marcos Alves Cunha"
        github = "alvesfc"
        roles = setOf("owner", "notify")
    })
}