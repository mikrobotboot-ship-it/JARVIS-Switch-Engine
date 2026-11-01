# JARVIS Switch Engine — architecture bootstrap

## Current state
This is an Android application shell (0.1.0-prototype), not a functioning emulator.
It provides a launcher UI, a Storage Access Framework folder picker, and diagnostic placeholders.

## Target architecture
- `app`: Kotlin Android UI, library permissions, per-game profiles, settings and logs.
- `native/host`: JNI boundary, lifecycle, input/audio/video surfaces.
- `cores/switch`: isolated Switch core integration (GPL-3.0-or-later compatible source).
- `cores/libretro`: optional independently licensed cores for older systems.
- `graphics/vulkan`: capability detection, device profile, shader/pipeline cache policy.
- `profiles`: device/game configuration, thermal and frame pacing policies.
- `compliance`: notices, source offer, third-party license inventory and build provenance.

## Hardware strategy
The target phone class includes ARM64 and a Mali GPU. Do not bundle Adreno-only Turnip drivers.
First query Vulkan device name, API version, extensions, memory budget and format support at runtime.
Do not force Vulkan 1.3 or unsupported extensions. Select a conservative renderer path when required.

## Candidate upstreams to evaluate
- Lemon / Eden family: GPL-3.0-or-later; Android Switch core lineage; verify current Mali support and exact upstream revision before integration.
- Strato: GPL-3.0-or-later; experimental ARM64 Android Switch emulator.
- libretro cores: evaluate each core's license independently before inclusion.

No firmware, encryption keys, copyrighted game files, BIOS or system dumps are included or distributed.
Users must provide their own legally obtained content. Do not bypass console security or DRM.

## Required engineering gates
1. Pin upstream commit hashes and archive license notices.
2. Build reproducibly for `arm64-v8a`.
3. Add JNI lifecycle tests and native crash reporting.
4. Add Vulkan capability tests on the actual Moto G86.
5. Add game compatibility tests using user-provided legal test content.
6. Measure frame pacing, thermal throttling, memory pressure and battery draw.
7. Only publish APK after release build, signing, install and smoke tests pass.

## Build
Open this folder in Android Studio with JDK 17 and Android SDK 35.
Run `:app:assembleDebug` to build the prototype shell.
This does not produce Switch emulation until a compatible core is integrated.
