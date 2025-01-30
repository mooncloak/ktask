plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(Kotlin.stdlib)
    implementation(Kotlin.gradlePlugin)

    implementation("com.mooncloak.kodetools.kenv:kenv-core:_")
}

gradlePlugin {
    plugins.register("ktask.variables") {
        id = "ktask.variables"
        implementationClass = "BuildVariablesPlugin"
    }
}
