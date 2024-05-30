package org.beaver.publishing

import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import javax.inject.Inject

open class BeaverPublishingExtension @Inject constructor(objects: ObjectFactory) {

    companion object {
        const val PUBLISHING_URL = "https://gitea.home.marcosalves.dev.br"
    }

    val publishingURL: Property<String> = objects.property(String::class.java).convention(PUBLISHING_URL)

    val isFatJar: Property<Boolean> = objects.property(Boolean::class.java).convention(false)
}