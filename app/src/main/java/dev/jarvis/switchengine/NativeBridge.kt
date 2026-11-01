package dev.jarvis.switchengine

object NativeBridge {
    private val loaded: Boolean = try {
        System.loadLibrary("jarvis_native")
        true
    } catch (_: UnsatisfiedLinkError) {
        false
    }

    fun status(): String = if (loaded) coreStatus() else "Biblioteca JNI ainda não carregada"
    private external fun coreStatus(): String
}
