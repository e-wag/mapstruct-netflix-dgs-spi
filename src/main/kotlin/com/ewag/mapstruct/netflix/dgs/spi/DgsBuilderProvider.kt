package com.ewag.mapstruct.netflix.dgs.spi

import org.mapstruct.ap.spi.BuilderInfo
import org.mapstruct.ap.spi.DefaultBuilderProvider
import javax.lang.model.element.TypeElement
import javax.lang.model.util.ElementFilter

class DgsBuilderProvider: DefaultBuilderProvider() {

    /**
     * Try to find correct Builder for generated DGS classes.
     */
    override fun findBuilderInfo(typeElement: TypeElement): BuilderInfo? {
        if (shouldIgnore(typeElement)) {
            return null
        }

        val builderTypeElement = ElementFilter
            .typesIn(typeElement.enclosedElements)
            .single { it.simpleName.endsWith("Builder") }

        val builderConstructor = builderTypeElement
            .let { ElementFilter.constructorsIn(it.enclosedElements) }
            .single()

        val buildMethods = findBuildMethods(builderTypeElement, typeElement)

        return BuilderInfo.Builder()
            .builderCreationMethod(builderConstructor)
            .buildMethod(buildMethods)
            .build()
    }
}
