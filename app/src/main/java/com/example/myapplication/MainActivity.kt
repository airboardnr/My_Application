package com.example.myapplication

import android.content.Context
import android.content.pm.PackageInfo
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.telephony.TelephonyManager
import android.util.Log
import android.webkit.WebView

class DeviceInfo(val context: Context) {
    fun getDeviceID(): String {
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    }

    fun getDeviceModel(): String {
        return Build.MODEL
    }

    fun getDeviceOS(): String {
        return Build.VERSION.RELEASE.toString()
    }

    fun getAppVersion(): String {
        val info: PackageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
        return info.versionName
    }
}

class MainActivity : AppCompatActivity() {
    private val TAG: String = "휴대폰 정보"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView: WebView = findViewById(R.id.webView1)

        val mySettings = webView.settings
        mySettings.javaScriptEnabled = true
        mySettings.domStorageEnabled = true

//        webView.loadUrl("https://bigsnow.co.kr")
//        webView.loadUrl("https://m.naver.com")
        webView.loadUrl("https://www.daum.net")
//        webView.loadUrl("https://www.danawa.com")
//        webView.loadUrl("https://www.google.com")

        val myDeviceInfo = DeviceInfo(this)
        Log.d(TAG, "Device ID ["+ myDeviceInfo.getDeviceID() +"]")
        Log.d(TAG, "Device Model ["+ myDeviceInfo.getDeviceModel() +"]")
        Log.d(TAG, "Device OS ["+ myDeviceInfo.getDeviceOS() +"]")
        Log.d(TAG, "Device App Ver ["+ myDeviceInfo.getAppVersion() +"]")

//        var tm: TelephonyManager = (TelephonyManager)getSystemService
//        Log.d(T)

    }
}