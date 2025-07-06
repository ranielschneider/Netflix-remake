package co.tiagoaguiar.netflixremake.util

import android.util.Log
import java.io.IOException
import java.lang.Exception
import java.net.URL
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection

class CategoryTask {

    fun execute(url: String){
        val executor = Executors.newSingleThreadExecutor()

        executor.execute{
            try {


                val requestURL = URL(url)
                val urlConnection = requestURL.openConnection() as HttpsURLConnection
                urlConnection.readTimeout = 2000
                urlConnection.connectTimeout = 2000

                val statusCode: Int = urlConnection.responseCode
                if (statusCode > 400) {
                    throw IOException("Erro na comunicação com o servidor!")
                }

                val stream = urlConnection.inputStream
                val jsonAsString = stream.bufferedReader().use { it.readText() }
                Log.i("Teste", jsonAsString)

            }catch (e: Exception){
                Log.e("Teste", e.message ?: "erro desconhecido", e)
            }

        }
    }
}