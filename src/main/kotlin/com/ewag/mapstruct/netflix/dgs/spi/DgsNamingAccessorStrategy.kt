package com.ewag.mapstruct.netflix.dgs.spi

import org.mapstruct.ap.spi.DefaultAccessorNamingStrategy
import java.util.Locale
import javax.lang.model.element.ExecutableElement

class DgsNamingAccessorStrategy : DefaultAccessorNamingStrategy() {

    /**
     * Get property names based on getter/setter/with methods.
     * Otherwise, provide unchanged method name.
     * This is especially useful for property-like method names like `is` and `has`.
     */
    override fun getPropertyName(getterOrSetterMethod: ExecutableElement): String {
        val methodName = getterOrSetterMethod.simpleName.toString()

        return when {
            methodName.startsWith("get") || methodName.startsWith("set") ->
                methodName.substring(3).replaceFirstChar { it.lowercase(Locale.getDefault()) }

            methodName.startsWith("with") ->
                methodName.substring(4).replaceFirstChar { it.lowercase(Locale.getDefault()) }

            else -> methodName
        }
    }
}
