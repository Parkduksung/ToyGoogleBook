import com.example.toygooglebook.configureKotlinAndroid

plugins{
    id("com.android.library")
    kotlin("android")
}

android {

    configureKotlinAndroid(this)

    defaultConfig {
        targetSdk = 32
    }

}