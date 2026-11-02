package dev.jarvis.switchengine

import android.content.Context
import android.opengl.GLES20

object DeviceProfile {
    fun gpuSummary(): String = try {
        val renderer = GLES20.glGetString(GLES20.GL_RENDERER)
        val vendor = GLES20.glGetString(GLES20.GL_VENDOR)
        if (renderer.isNullOrBlank()) "Renderer indisponível fora de um contexto GL"
        else "$renderer ($vendor)"
    } catch (_: Exception) {
        "detecção GL será feita na superfície de renderização"
    }

    fun vulkanSummary(context: Context): String =
        if (android.os.Build.VERSION.SDK_INT >= 24)
            "API Vulkan disponível no Android; capacidades reais serão consultadas via Vulkan NDK"
        else "Android sem suporte à API Vulkan"
}
