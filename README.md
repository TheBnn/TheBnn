# BagStash

BagStash is a small Android application built with Jetpack Compose. This project uses the Gradle wrapper so you don't need a local Gradle installation.

## Prerequisites

- **JDK 11** or higher on your `PATH`
- **Android SDK**. Set the path to your SDK in `local.properties` using the `sdk.dir` property. Android Studio normally generates this file for you.

## Building

To build the app from the command line, use the Gradle wrapper provided in the repository:

```bash
./gradlew assembleDebug
```

This downloads the required Gradle version (see `gradle/wrapper/gradle-wrapper.properties`) and compiles the project. You can also open the project in Android Studio and use the standard Run/Build tasks.

