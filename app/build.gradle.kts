plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}



android {
    namespace = "com.example.helpnow"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.helpnow"
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

    buildFeatures{
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
//    implementation ("com.github.ipfs:java-ipfs-http-client:Tag")

    implementation ("com.squareup.okhttp3:okhttp:4.9.1")
    implementation ("com.google.code.gson:gson:2.8.8")
    implementation ("com.github.tbouron.shakedetector:library:1.0.0@aar")
    implementation ("com.google.android.gms:play-services-maps:17.0.1")
    //fused location provider dependency
    implementation ("com.google.android.gms:play-services-location:18.0.0")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
//    implementation ("com.github.ligi:ipfs-api-kotlin:1.3.3")
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
//    implementation ("org.ipfs:java-ipfs-api:1.0.0")
    implementation(libs.play.services.location)
//    implementation ("group: 'com.github.ipfs', name: 'java-ipfs-http-client', version: 'v1.3.3'")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}