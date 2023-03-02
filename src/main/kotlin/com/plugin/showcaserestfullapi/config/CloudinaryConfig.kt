package com.plugin.showcaserestfullapi.config

import com.cloudinary.Cloudinary
import com.cloudinary.utils.ObjectUtils
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CloudinaryConfig {
    @Bean
    fun cloudinaryAccount() : Cloudinary{
        return Cloudinary(
            ObjectUtils.asMap(
            "cloud_name", "dejyswltx",
            "api_key", "999922982214897",
            "api_secret", "R3lCkLPD5V-_0lz03jJUP1ey5XE"
        ))
    }
}