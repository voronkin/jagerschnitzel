package com.voronkin.jagerschnitzel



import android.os.Bundle

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
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
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)

        // эмуляция долгой загрзуки для демонстрации сплэш-скрина
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
        }
        setContentView(R.layout.activity_main)

        val jsonURL = "https://jsonplaceholder.typicode.com/users"

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
        myWebView.loadUrl(jsonURL)


    }
}
