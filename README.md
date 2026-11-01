# JARVIS Switch Engine — Android bootstrap

Version 0.1.1-prototype. This is a launcher/JNI bootstrap, **not yet a Nintendo Switch emulator**.

It contains:
- Android ARM64 app shell;
- Storage Access Framework folder picker;
- JNI/CMake native stub wired into the build;
- device diagnostics placeholders;
- APK audit and integration plan.

## Build requirements
- Android Studio
- JDK 17
- Android SDK Platform 35
- Android NDK and CMake installed via SDK Manager

Open the project in Android Studio and run `:app:assembleDebug`.

The resulting APK will only be the bootstrap shell. The Eden emulator core is not included yet because the matching upstream source revision and its GPL notices must be audited before integration.

Use only game/system files you lawfully obtained. This project does not include firmware, encryption keys, BIOS, or games.
