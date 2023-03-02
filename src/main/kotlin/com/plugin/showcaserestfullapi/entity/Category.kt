package com.plugin.showcaserestfullapi.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "category")
data class Category(
    @Id
    @GeneratedValue
    val idCategory : Int = 0,
    @Column(name = "category_name")
    val categoryName : String
)
