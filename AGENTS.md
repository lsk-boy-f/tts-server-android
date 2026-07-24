# Repository Guidelines

## Project Structure & Module Organization

This is a multi-module Android application. `app/` contains the application, UI, resources, and product flavors (`app` and `dev`). Shared functionality is split across `lib-common/`, `lib-compose/`, `lib-database/`, `lib-script/`, `lib-server/`, and `lib-tts/`. Convention plugins live in `build-logic/`, while dependency versions are centralized in `libs.versions.toml`. Room schema snapshots are stored under `lib-database/schemas/`; update and commit them with database migrations. Screenshots used by the README are in `images/`.

Each module follows Android source-set conventions: production Kotlin and resources belong in `src/main/`, JVM tests in `src/test/`, and device/emulator tests in `src/androidTest/`.

## Build, Test, and Development Commands

- `./gradlew assembleAppDebug` builds the standard debug APK.
- `./gradlew assembleDevDebug` builds the side-by-side development flavor.
- `./gradlew test` runs all local JVM unit tests.
- `./gradlew connectedAndroidTest` runs instrumentation and Compose UI tests on a connected device or emulator.
- `./gradlew lint` runs Android lint across modules.
- `./gradlew clean` removes generated build output.

Use JDK 17. The app build reads signing values from root `local.properties` (`KEY_PATH`, `KEY_PASSWORD`, `ALIAS_NAME`, and `ALIAS_PASSWORD`); never commit this file or keystores.

## Coding Style & Naming Conventions

Follow standard Kotlin/Android formatting with four-space indentation and trailing commas where they improve diffs. Use `PascalCase` for classes and composables, `camelCase` for functions and properties, and `UPPER_SNAKE_CASE` for constants. Keep package names lowercase under `com.github.jing332`. Prefer focused module boundaries and place reusable Compose UI in `lib-compose` rather than `app`.

## Testing Guidelines

Tests use JUnit 4; instrumentation tests also use AndroidX Test, Espresso, and Compose test APIs. Name test classes after the subject with a `Test` suffix and use descriptive test method names. Add JVM tests for pure logic and instrumentation tests only for Android framework, database, or UI behavior. Run the relevant module test task during development, then `./gradlew test lint` before submitting.

## Commit & Pull Request Guidelines

Use Conventional Commits, matching repository history: `feat: ...`, `fix(tts): ...`, or `refactor(server): ...`. Keep each commit scoped to one logical change. Pull requests should explain the behavior change, identify affected modules, link related issues, and list verification performed. Include screenshots or recordings for visible UI changes and note schema, configuration, or migration impacts explicitly.
