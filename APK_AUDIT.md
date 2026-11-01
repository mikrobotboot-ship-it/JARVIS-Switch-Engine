# Audit of the user-provided Eden APK

File: `Eden-Android-2000fdfb7b-legacy.apk`
Size: 28,448,180 bytes
SHA-256: `f078b1e0ed4172c55a555f882b57dffcab72c191fca7576c23e876190c48ca03`

Observed by inspecting the APK ZIP container:
- Native ABI present: `arm64-v8a` only.
- Native library: `lib/arm64-v8a/libyuzu-android.so`.
- Android Gradle Plugin metadata: 8.9.1.
- VCS metadata says `NO_SUPPORTED_VCS_FOUND`; the exact source commit cannot be recovered from this metadata alone.

Important compatibility finding:
- The supplied filename identifies this as an Eden **Legacy** build.
- Eden's published release notes describe Legacy Android builds as intended for Adreno A6xx / older Qualcomm GPUs, not as a Mali-specialized build.
- The Eden release notes separately mention renderer performance improvements on Mali. We should benchmark the current standard/optimized release against this legacy APK before choosing a development base.

Limits:
- ZIP inspection does not reveal the full manifest, package ID, signing certificate, exact Eden version, or full native source.
- No attempt was made to bypass DRM, extract console keys, or redistribute copyrighted game/system files.
- The uploaded APK is a compiled artifact and is not a substitute for the matching source tree.
