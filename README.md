# Beaver Publishing Plugin

This is a Gradle plugin developed in Kotlin and Java. It is designed to help with publishing artifacts.

## Features

- Configurable publishing URL
- Option to publish as a fat jar

## Requirements

- Gradle 8.0 or higher

## Usage

Apply the plugin in your `build.gradle.kts` file:

```kotlin
plugins {
    id("org.beaver.publishing")
}
```

Configure the plugin in your build.gradle.kts file:

```kotlin
beaverPublish {
    publishingURL.set("your-publishing-url")
    isFatJar.set(true)
}
```

## Building

To build the project, run the following command:

```shell
./gradlew build
```

## Testing

To run the tests, use the following command:

```shell
./gradlew test
```

