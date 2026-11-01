#include <jni.h>
#include <string>

// Placeholder JNI boundary. A real emulator core must be integrated here
// only after its upstream license, source obligations and Android build are audited.
extern "C" JNIEXPORT jstring JNICALL
Java_dev_jarvis_switchengine_NativeBridge_coreStatus(JNIEnv* env, jobject) {
    return env->NewStringUTF("Emulation core not integrated");
}
