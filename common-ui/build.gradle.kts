
/*
 * Copyright (c) 2022 NetEase, Inc.  All rights reserved.
 * Use of this source code is governed by a MIT license that can be found in the LICENSE file.
 */

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = 34
    namespace = "com.netease.yunxin.kit.common.ui"
    defaultConfig {
        minSdk = 24
        consumerProguardFiles("consumer-rules.pro")
        buildConfigField("String", "versionName", "\"1.3.8\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api("com.netease.yunxin.kit.common:common:1.3.8")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    api("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.21")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("com.airbnb.android:lottie:5.0.3")
    implementation("com.github.bumptech.glide:glide:4.13.1")

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

}

