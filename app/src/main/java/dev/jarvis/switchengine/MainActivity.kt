package dev.jarvis.switchengine

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

/**
 * JARVIS Switch Engine - bootstrap shell.
 * This app shell is not yet an emulator; it is the Android front-end foundation.
 */
class MainActivity : Activity() {
    private val pickLibrary = 4101
    private lateinit var status: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val page = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(28, 42, 28, 28)
            setBackgroundColor(0xFF0B1020.toInt())
        }
        val scroll = ScrollView(this)
        val title = TextView(this).apply {
            text = "JARVIS SWITCH ENGINE"
            textSize = 24f
            setTextColor(0xFFE8F0FF.toInt())
            gravity = Gravity.CENTER_VERTICAL
        }
        val subtitle = TextView(this).apply {
            text = "Multi-system emulator platform • Android prototype 0.1.0"
            textSize = 13f
            setTextColor(0xFF9FB0D0.toInt())
            setPadding(0, 10, 0, 28)
        }
        status = TextView(this).apply {
            text = "Núcleo de emulação: ainda não integrado\nGPU: ${DeviceProfile.gpuSummary()}\nVulkan: ${DeviceProfile.vulkanSummary(this@MainActivity)}"
            textSize = 14f
            setTextColor(0xFFD6E1F5.toInt())
            setPadding(0, 12, 0, 24)
        }
        page.addView(title)
        page.addView(subtitle)
        page.addView(actionButton("Selecionar pasta de jogos") { openGameFolderPicker() })
        page.addView(actionButton("Diagnóstico do dispositivo") { refreshDiagnostics() })
        page.addView(actionButton("Biblioteca de sistemas") { showSystems() })
        page.addView(status)
        page.addView(TextView(this).apply {
            text = "Aviso: esta versão é a estrutura inicial do aplicativo. Ainda não executa jogos. Firmware, chaves e jogos não são fornecidos; use somente arquivos obtidos legalmente por você."
            textSize = 12f
            setTextColor(0xFFFFC978.toInt())
            setPadding(0, 20, 0, 0)
        })
        scroll.addView(page)
        setContentView(scroll)
    }

    private fun actionButton(label: String, action: () -> Unit): Button =
        Button(this).apply {
            text = label
            isAllCaps = false
            setOnClickListener { action() }
        }

    private fun openGameFolderPicker() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
        startActivityForResult(intent, pickLibrary)
    }

    @Deprecated("Use Activity Result API in production implementation")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == pickLibrary && resultCode == RESULT_OK) {
            val uri: Uri? = data?.data
            uri?.let {
                contentResolver.takePersistableUriPermission(
                    it, Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                )
                status.text = "Pasta selecionada:\n$it\n\nNúcleo de emulação: ainda não integrado"
            }
        }
    }

    private fun refreshDiagnostics() {
        status.text = "Diagnóstico\nModelo: ${android.os.Build.MODEL}\nAndroid: ${android.os.Build.VERSION.RELEASE}\nABI: ${android.os.Build.SUPPORTED_ABIS.joinToString()}\nGPU: ${DeviceProfile.gpuSummary()}\nVulkan: ${DeviceProfile.vulkanSummary(this)}\n\nA leitura detalhada de extensões Vulkan será implementada no módulo nativo."
    }

    private fun showSystems() {
        status.text = "Sistemas planejados\n• Nintendo Switch (núcleo separado)\n• PlayStation 1 (libretro)\n• PSP (libretro)\n• Game Boy / GBA (libretro)\n• Nintendo DS (libretro)\n\nCada núcleo terá licença, versão e configuração próprias. Nenhum núcleo está integrado nesta versão."
    }
}
