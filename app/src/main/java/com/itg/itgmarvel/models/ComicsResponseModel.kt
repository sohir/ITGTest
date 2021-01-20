package com.itg.itgmarvel.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ComicsResponseModel(
    @Json(name = "attributionHTML")
    val attributionHTML: String = "",
    @Json(name = "attributionText")
    val attributionText: String = "",
    @Json(name = "code")
    val code: Int = 0,
    @Json(name = "copyright")
    val copyright: String = "",
    @Json(name = "data")
    val `data`: Data = Data(),
    @Json(name = "etag")
    val etag: String = "",
    @Json(name = "status")
    val status: String = ""
) {
    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "count")
        val count: Int = 0,
        @Json(name = "limit")
        val limit: Int = 0,
        @Json(name = "offset")
        val offset: Int = 0,
        @Json(name = "results")
        val results: List<Result> = listOf(),
        @Json(name = "total")
        val total: Int = 0
    ) {
        @JsonClass(generateAdapter = true)
        data class Result(
            @Json(name = "characters")
            val characters: Characters = Characters(),
            @Json(name = "collectedIssues")
            val collectedIssues: List<Any> = listOf(),
            @Json(name = "collections")
            val collections: List<Any> = listOf(),
            @Json(name = "creators")
            val creators: Creators = Creators(),
            @Json(name = "dates")
            val dates: List<Date> = listOf(),
            @Json(name = "description")
            val description: String? = null,
            @Json(name = "diamondCode")
            val diamondCode: String = "",
            @Json(name = "digitalId")
            val digitalId: Int = 0,
            @Json(name = "ean")
            val ean: String = "",
            @Json(name = "events")
            val events: Events = Events(),
            @Json(name = "format")
            val format: String = "",
            @Json(name = "id")
            val id: Int = 0,
            @Json(name = "images")
            val images: List<Image> = listOf(),
            @Json(name = "isbn")
            val isbn: String = "",
            @Json(name = "issn")
            val issn: String = "",
            @Json(name = "issueNumber")
            val issueNumber: Int = 0,
            @Json(name = "modified")
            val modified: String = "",
            @Json(name = "pageCount")
            val pageCount: Int = 0,
            @Json(name = "prices")
            val prices: List<Price> = listOf(),
            @Json(name = "resourceURI")
            val resourceURI: String = "",
            @Json(name = "series")
            val series: Series = Series(),
            @Json(name = "stories")
            val stories: Stories = Stories(),
            @Json(name = "textObjects")
            val textObjects: List<TextObject> = listOf(),
            @Json(name = "thumbnail")
            val thumbnail: Thumbnail = Thumbnail(),
            @Json(name = "title")
            val title: String = "",
            @Json(name = "upc")
            val upc: String = "",
            @Json(name = "urls")
            val urls: List<Url> = listOf(),
            @Json(name = "variantDescription")
            val variantDescription: String = "",
            @Json(name = "variants")
            val variants: List<Variant> = listOf()
        ) {
            @JsonClass(generateAdapter = true)
            data class Characters(
                @Json(name = "available")
                val available: Int = 0,
                @Json(name = "collectionURI")
                val collectionURI: String = "",
                @Json(name = "items")
                val items: List<Item> = listOf(),
                @Json(name = "returned")
                val returned: Int = 0
            ) {
                @JsonClass(generateAdapter = true)
                data class Item(
                    @Json(name = "name")
                    val name: String = "",
                    @Json(name = "resourceURI")
                    val resourceURI: String = ""
                )
            }

            @JsonClass(generateAdapter = true)
            data class Creators(
                @Json(name = "available")
                val available: Int = 0,
                @Json(name = "collectionURI")
                val collectionURI: String = "",
                @Json(name = "items")
                val items: List<Item> = listOf(),
                @Json(name = "returned")
                val returned: Int = 0
            ) {
                @JsonClass(generateAdapter = true)
                data class Item(
                    @Json(name = "name")
                    val name: String = "",
                    @Json(name = "resourceURI")
                    val resourceURI: String = "",
                    @Json(name = "role")
                    val role: String = ""
                )
            }

            @JsonClass(generateAdapter = true)
            data class Date(
                @Json(name = "date")
                val date: String = "",
                @Json(name = "type")
                val type: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Events(
                @Json(name = "available")
                val available: Int = 0,
                @Json(name = "collectionURI")
                val collectionURI: String = "",
                @Json(name = "items")
                val items: List<Item> = listOf(),
                @Json(name = "returned")
                val returned: Int = 0
            ) {
                @JsonClass(generateAdapter = true)
                data class Item(
                    @Json(name = "name")
                    val name: String = "",
                    @Json(name = "resourceURI")
                    val resourceURI: String = ""
                )
            }

            @JsonClass(generateAdapter = true)
            data class Image(
                @Json(name = "extension")
                val extension: String = "",
                @Json(name = "path")
                val path: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Price(
                @Json(name = "price")
                val price: Double = 0.0,
                @Json(name = "type")
                val type: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Series(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "resourceURI")
                val resourceURI: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Stories(
                @Json(name = "available")
                val available: Int = 0,
                @Json(name = "collectionURI")
                val collectionURI: String = "",
                @Json(name = "items")
                val items: List<Item> = listOf(),
                @Json(name = "returned")
                val returned: Int = 0
            ) {
                @JsonClass(generateAdapter = true)
                data class Item(
                    @Json(name = "name")
                    val name: String = "",
                    @Json(name = "resourceURI")
                    val resourceURI: String = "",
                    @Json(name = "type")
                    val type: String = ""
                )
            }

            @JsonClass(generateAdapter = true)
            data class TextObject(
                @Json(name = "language")
                val language: String = "",
                @Json(name = "text")
                val text: String = "",
                @Json(name = "type")
                val type: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Thumbnail(
                @Json(name = "extension")
                val extension: String = "",
                @Json(name = "path")
                val path: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Url(
                @Json(name = "type")
                val type: String = "",
                @Json(name = "url")
                val url: String = ""
            )

            @JsonClass(generateAdapter = true)
            data class Variant(
                @Json(name = "name")
                val name: String = "",
                @Json(name = "resourceURI")
                val resourceURI: String = ""
            )
        }
    }
}