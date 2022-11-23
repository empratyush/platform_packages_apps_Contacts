plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 33
    buildToolsVersion = "33.0.0"

    namespace = "com.android.contacts"

    defaultConfig {
        applicationId = "com.android.contacts"
        minSdk = 26
        targetSdk = 33
        versionCode = 64
        versionName = versionCode.toString()
        resourceConfigurations.add("en")
    }

    buildTypes {
        getByName("release") {
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    sourceSets {
        getByName("main") {
            res {
                srcDirs(
                    "./../res"
                )
            }
            java {
                srcDirs("./../src","./../src-bind")
            }
            assets {
                srcDirs( "../assets")
            }
            manifest {
                srcFile("./../AndroidManifest.xml")
            }
        }
    }
    configurations {
        all {
            exclude(
                group = "androidx.lifecycle",
                module = "lifecycle-viewmodel-ktx"
            )
        }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("androidx.biometric:biometric:1.1.0")
    implementation("androidx.preference:preference:1.2.0")
    implementation("androidx.palette:palette:1.0.0")
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("com.google.guava:guava:31.1-android")
    implementation("com.googlecode.libphonenumber:libphonenumber:8.13.0")
    implementation("com.googlecode.libphonenumber:geocoder:2.194")

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

}
