# BagStash

BagStash is a small Android application built with Jetpack Compose. This project uses the Gradle wrapper so you don't need a local Gradle installation.

## Prerequisites

- **JDK 11** or higher on your `PATH`
- **Android SDK**. Copy `local.properties.example` to `local.properties` and set `sdk.dir` to your SDK path. Android Studio normally generates this file for you.
- A sample `local.properties.example` file is provided at the repository root.

## Building

To build the app from the command line, use the Gradle wrapper provided in the repository:

```bash
./gradlew assembleDebug
```

This downloads the required Gradle version (see `gradle/wrapper/gradle-wrapper.properties`) and compiles the project. You can also open the project in Android Studio and use the standard Run/Build tasks.


## License

This project is licensed under the [MIT License](LICENSE).

