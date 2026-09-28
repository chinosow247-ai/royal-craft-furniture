plugins { id("com.android.application") }

android {
    namespace = "com.royalcraftfurniture.app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.royalcraftfurniture.app"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    signingConfigs {
        create("release") {
            val keystorePath = System.getenv("ROYAL_CRAFT_KEYSTORE")
            if (keystorePath != null) {
                storeFile = file(keystorePath)
                storePassword = System.getenv("ROYAL_CRAFT_STORE_PASSWORD")
                keyAlias = System.getenv("ROYAL_CRAFT_KEY_ALIAS")
                keyPassword = System.getenv("ROYAL_CRAFT_KEY_PASSWORD")
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
        }
    }
}
