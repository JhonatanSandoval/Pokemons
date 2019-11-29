// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(BuildDependencies.ANDROID_GRADLE_PLUGIN)
        classpath(BuildDependencies.KOTLIN_GRADLE_PLUGIN)
        classpath(BuildDependencies.KOTLIN_ANDROID_EXTENSIONS)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}