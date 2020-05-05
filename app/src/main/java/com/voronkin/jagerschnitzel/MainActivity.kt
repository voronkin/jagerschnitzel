package com.voronkin.jagerschnitzel



import android.content.Context
import android.net.wifi.WifiManager
import android.os.Bundle
import android.util.Log

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import android.provider.Settings


/*
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

 */

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)

        // эмуляция долгой загрзуки для демонстрации сплэш-скрина
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
        }
        setContentView(R.layout.activity_main)

        val jsonURL = "http://89.108.103.75/users/mrtrickster/2BFeVpcH/testapi.php"
        // TODO: объединить GET-параметры в класс
        val install_id = "00001"
        val device_id =  Settings.Secure.getString(contentResolver,Settings.Secure.ANDROID_ID)
        val wifi_mac = getWiFiMac()
        val app_version = "0.001a"
        val timezone = "GMT+0003"
        val geo = "+7"

    val bldr = StringBuilder()
    bldr.append(jsonURL)
        .append("?")
        .append(install_id)
        .append("&")
        .append(device_id)
        .append("&")
        .append(wifi_mac)
        .append("&")
        .append(app_version)
        .append("&")
        .append(timezone)
        .append("&")
        .append(geo)

    Log.d("GETURL",bldr.toString())


        // получение JSON через корутины в текст
        /*
        lifecycleScope.launch {
            val result = httpGet(jsonURL)
            Log.d("GETRESULT",result)
        }

         */



        // получение JSON в WebView
        val myWebView: WebView = findViewById(R.id.webview)
        myWebView.settings.javaScriptEnabled = true
        myWebView.webViewClient = WebViewClient()
        myWebView.loadUrl(bldr.toString())


    }

    /*
    private suspend fun httpGet(myURL: String?): String {
        val result = withContext(Dispatchers.IO) {
            val inputStream: InputStream
            val url: URL = URL(myURL)
            val conn: HttpURLConnection = url.openConnection() as HttpURLConnection
            conn.connect()

            inputStream = conn.inputStream

            inputStream?.bufferedReader()?.use(BufferedReader::readText) ?: "Did not work!"
        }

        return result
    }
    */

    private fun getWiFiMac(): String {
        val manager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        val info = manager.connectionInfo
        return info.macAddress.toUpperCase()
    }
}
