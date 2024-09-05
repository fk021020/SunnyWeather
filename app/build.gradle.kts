
plugins {
//    id ("kotlin-android")
//    id ("kotlin-parcelize")
//    id ("kotlin-kapt")
//    id ("kotlin-android-extensions")
//    id ("androidx.databinding.experimental")



    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.sunnyweather.android"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sunnyweather.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures.dataBinding = true
}






dependencies {
//    implementation ("com.android.databinding:compiler:7.4.2")
    implementation ("androidx.core:core-ktx:1.3.2")
    implementation ("androidx.appcompat:appcompat:1.2.0")
    implementation ("com.google.android.material:material:1.3.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.0.4")
    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.3.0")

    implementation ("androidx.recyclerview:recyclerview:1.0.0")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.1.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")

    implementation ("com.squareup.retrofit2:retrofit:2.6.1")
    implementation ("com.squareup.retrofit2:converter-gson:2.6.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.1.1")

    implementation ("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.appcompat)
//    implementation(libs.material)
//    implementation(libs.androidx.activity)
//    implementation(libs.androidx.constraintlayout)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//    implementation("androidx.recyclerview:recyclerview:1.3.2")
//    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")
//    implementation("com.google.android.material:material:1.9.0")
////    implementation("?androidx.swiperefreshlayout:swiperefreshlayout:1.0.0")
//    implementation("com.squareup.retrofit2:retrofit:2.6.1")
//    implementation("com.squareup.retrofit2:converter-gson:2.6.1")
//    implementation("org.jetbrains.kotlinx:kotlinx:kotlinx-coroutines-core:1.3.0")
//    implementation("org.jetbrains.kotlinx:kotlinx:kotlinx-coroutines-android:1.1.0")

}