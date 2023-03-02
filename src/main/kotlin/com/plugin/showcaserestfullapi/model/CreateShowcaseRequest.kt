package com.plugin.showcaserestfullapi.model

import org.springframework.web.multipart.MultipartFile
import javax.validation.constraints.NotBlank

data class CreateShowcaseRequest (
    @field:NotBlank
    val title : String?,
    @field:NotBlank
    val image : MultipartFile,
    @field:NotBlank
    val description: String?,
    val idCategory : Int
)