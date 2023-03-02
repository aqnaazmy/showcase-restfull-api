package com.plugin.showcaserestfullapi.repository

import com.plugin.showcaserestfullapi.entity.Showcase
import org.springframework.data.jpa.repository.JpaRepository

interface ShowcaseRepository : JpaRepository<Showcase, Int> {
}