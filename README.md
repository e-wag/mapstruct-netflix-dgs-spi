# Mapstruct SPI implementation for [Netflix DGS Codegen](https://github.com/Netflix/dgs-codegen)

This implementation helps [mapstruct](http://mapstruct.org/) generate working mapping code between your entity classes
and DGS classes.

## AccessorNamingStrategy

Implements a naming strategy to support property-like method names like `is` and `has` 
as well as methods prefixed with `set`, `get` and `with`.

## BuilderProvider

Implements a BuilderProvider to be able to use generated `Builder` classes.

# Version Support

At least the following versions should be supported:

- [Mapstruct 1.5.2.Final](https://github.com/mapstruct/mapstruct/releases/tag/1.5.2.Final)
- [DGS-Codegen 5.2.5](https://github.com/Netflix/dgs-codegen/releases/tag/v5.2.5)

# How to use it

For the different instructions to work, you simply have to add them to your project.
You can add the library to your `build.gradle.kts` for example like this:

```kotlin
dependencies {
    kapt("com.ewag.mapstruct.netflix.dgs.spi:mapstruct-netflix-dgs-spi:1.0.0")
}
```
