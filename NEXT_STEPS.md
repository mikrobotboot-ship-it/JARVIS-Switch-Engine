# Next engineering actions

1. Connect the GitHub integration so the exact upstream Eden source can be inspected and forked.
2. Match the uploaded APK to a release/source revision; the embedded VCS metadata does not identify a commit.
3. Benchmark the supplied Legacy APK against current Standard and Optimized APKs on the Moto G86.
4. Query Vulkan device/driver properties on-device (device name, API version, extensions, formats, memory heaps).
5. Build the Eden core for `arm64-v8a` with documented GPL-3.0-or-later notices and publish corresponding source for modifications.
6. Add game-specific regression tests and collect frame-time, thermal, memory and crash metrics.
7. Only then produce a signed installable APK.

No zero-stutter guarantee is technically credible: emulation performance is constrained by game code, CPU/GPU throughput, driver behavior, thermal limits and Android scheduling.
