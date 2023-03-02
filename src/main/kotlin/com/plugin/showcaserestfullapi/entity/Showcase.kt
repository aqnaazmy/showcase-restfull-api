package com.plugin.showcaserestfullapi.entity

import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "showcase")
data class Showcase(
    @Id
    @GeneratedValue
    val id : Int = 0,
    @Column(name = "title")
    var title : String,
    @Column(name = "image")
    var image : String,
    @Column(name = "description")
    var description : String,
    @Column(name = "category_id")
    var createdAt : Date,
    @Column(name = "updated_at")
    var updatedAt : Date
){
    @ManyToOne
    @JoinColumn(name = "id_category")
    lateinit var category : Category
}