package com.accenture.desafio.interactor.remote

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.accenture.desafio.R
import org.apache.commons.codec.digest.DigestUtils

abstract class Service(private val context: Context) {

    companion object {
        private val PUBLIC_KEY = "4a2a39e0402d82bbd107f62ff8fd20ad"
        private val PRIVATE_KEY = "6e5b32f1b0036dd1a119c6b781ed94ef7798ac30"
        val URL_SERVICE = "http://gateway.marvel.com/"
        val URL_PICPAY = "http://careers.picpay.com/tests/mobdev/"
    }

    fun getApiKey(): String {
        return "$PUBLIC_KEY"
    }

    fun getHash(ts: Long): String {
        return DigestUtils.md5Hex("$ts$PRIVATE_KEY$PUBLIC_KEY")
    }

    fun verifyConnection(): Boolean {
        try {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val nw = connectivityManager.activeNetwork ?: return false
                val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
                return when {
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    else -> false
                }
            } else {
                val nwInfo = connectivityManager.activeNetworkInfo ?: return false
                return nwInfo.isConnected
            }
        } catch (e: Exception) {
            return false
        }
    }

    fun messageError(code: String): String {
        when (code){
            "401" -> return context.getString(R.string.referente_hash_invalid)
            "409" -> return context.getString(R.string.apikey_date_hash_invalid)
            "405" -> return context.getString(R.string.action_not_permissiont)
            "403" -> return context.getString(R.string.action_proib)
            "connect" -> return context.getString(R.string.not_connection)
            "error" -> return context.getString(R.string.error_connection)
        }
        return context.getString(R.string.cred_invalid)
    }
}