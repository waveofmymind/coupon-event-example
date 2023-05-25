pluginManagement {
    repositories {
        maven { url = uri("https://repo.spring.io/milestone") }
        maven { url = uri("https://repo.spring.io/snapshot") }
        gradlePluginPortal()
    }
}
rootProject.name = "coupon-event"
include("coupon-core", "coupon-api", "coupon-batch")
include("coupon-api")
include("coupon-core")
include("coupon-batch")
