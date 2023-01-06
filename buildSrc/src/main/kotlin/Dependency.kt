object Dependency {

    const val appcompat = "androidx.appcompat:appcompat:${Version.appcompat}"
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val androidKtx = "androidx.activity:activity-ktx:${Version.androidKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Version.fragmentKtx}"

    object UI {
        const val material = "com.google.android.material:material:${Version.UI.material}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Version.UI.constraintLayout}"
        const val compose = "androidx.compose.ui:ui:${Version.UI.jetpackCompose}"
        const val composeTooling = "androidx.compose.ui:ui-tooling:${Version.UI.jetpackCompose}"
        const val composePreview =
            "androidx.compose.ui:ui-tooling-preview:${Version.UI.jetpackCompose}"
        const val composeMaterial =
            "androidx.compose.material:material:${Version.UI.jetpackCompose}"
        const val composeCompiler =
            "androidx.compose.compiler:compiler:${Version.UI.jetpackCompose}"
        const val activityCompose =
            "androidx.activity:activity-compose:${Version.UI.activityCompose}"
        const val coilCompose =
            "io.coil-kt:coil-compose:${Version.UI.coilCompose}"
    }

    object GradlePlugin {
        const val android = "com.android.tools.build:gradle:${Version.GradlePlugin.gradle}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.GradlePlugin.kotlin}"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Version.DI.hilt}"
    }

    object Test {
        const val junit = "junit:junit:${Version.Test.junit}"
        const val mockito = "org.mockito:mockito-core:${Version.Test.mockito}"
        const val androidJunit = "androidx.test.ext:junit:${Version.Test.androidJunit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Version.Test.espresso}"
        const val mockitoKotlin =
            "com.nhaarman.mockitokotlin2:mockito-kotlin:${Version.Test.mockitoKotlin}"
        const val mockitoInline = "org.mockito:mockito-inline:${Version.Test.mockitoInline}"
        const val threeTenAbp = "org.threeten:threetenbp:${Version.Test.threeTenAbp}"
    }

    object Coroutine {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.Coroutine.coroutine}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.Coroutine.coroutine}"
    }

    object DI {
        const val hiltAndroid = "com.google.dagger:hilt-android:${Version.DI.hilt}"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Version.DI.hilt}"
        const val inject = "javax.inject:javax.inject:1"
        const val hiltCompose = "androidx.hilt:hilt-navigation-compose:${Version.DI.hiltCompose}"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.Network.retrofit}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Version.Network.retrofit}"
        const val okhttp = "com.squareup.okhttp3:okhttp:${Version.Network.okhttp}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.Network.okhttp}"
    }

    object LocalStorage {
        const val room = "androidx.room:room-ktx:${Version.LocalStorage.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Version.LocalStorage.room}"
        const val sharedPreference =
            "androidx.preference:preference-ktx:${Version.LocalStorage.sharedPreference}"
    }

    object Lifecycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.Lifecycle.lifecycle}"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.Lifecycle.lifecycle}"
        const val runTime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.Lifecycle.lifecycle}"
    }

    object ThreeTenAndroidBackport {
        const val threeTenAbp = "com.jakewharton.threetenabp:threetenabp:${Version.Test.threeTenAbp}"
    }

    object Moshi {
        const val moshi = "com.squareup.moshi:moshi:${Version.Moshi.moshi}"
        const val moshiCompiler = "com.squareup.moshi:moshi-kotlin-codegen:${Version.Moshi.moshi}"
        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Version.Moshi.moshiKotlin}"
    }

    object Navigation {
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Version.Navigation.navigation}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.Navigation.navigation}"
    }

    object WorkManager {
        const val ktx = "androidx.work:work-runtime-ktx:${Version.WorkManager.workManager}"
        const val hiltExtension = "androidx.hilt:hilt-work:${Version.WorkManager.workManagerHiltExtension}"
    }

    object Permission {
        const val tedPermission =
            "io.github.ParkSangGwon:tedpermission-normal:${Version.Permission.tedPermission}"
    }

    object CircleImageView {
        const val circleImage = "de.hdodenhof:circleimageview:${Version.CircleImageView.circleImage}"
    }

    object Glide {
        const val glideCore = "com.github.bumptech.glide:glide:${Version.Glide.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Version.Glide.glide}"
    }

    object Socket {
        const val socketIo = "io.socket:socket.io-client:${Version.Socket.socket}"
    }
}