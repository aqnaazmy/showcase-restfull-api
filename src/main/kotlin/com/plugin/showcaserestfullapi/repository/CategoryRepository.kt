package com.plugin.showcaserestfullapi.repository

import com.plugin.showcaserestfullapi.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category,Int> {
    fun findCategoryByIdCategory (id : Int) : Category

}