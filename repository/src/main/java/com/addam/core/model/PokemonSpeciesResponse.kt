package com.addam.core.model

import com.google.gson.annotations.SerializedName

/**
 * Created by addam on 12/3/20
 */
data class PokemonSpeciesResponse (
    @SerializedName("flavor_text_entries")
    val flavor_text_entries: List<FlavorTextEntry>
        )

data class FlavorTextEntry(
    @SerializedName("flavor_text")
    val flavor_text: String,
    
    @SerializedName("language")
    val language: Language
)

data class Language(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)