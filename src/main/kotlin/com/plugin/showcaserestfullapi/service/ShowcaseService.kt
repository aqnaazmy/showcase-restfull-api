package com.plugin.showcaserestfullapi.service

import com.plugin.showcaserestfullapi.model.CreateShowcaseRequest
import com.plugin.showcaserestfullapi.model.ListShowcaseRequest
import com.plugin.showcaserestfullapi.model.ShowcaseResponse
import com.plugin.showcaserestfullapi.model.UpdateShowcaseRequest

interface ShowcaseService {
    fun create(createShowcaseRequest: CreateShowcaseRequest) : ShowcaseResponse
    fun get(id : Int) : ShowcaseResponse
    fun list(listShowcaseRequest: ListShowcaseRequest) : List<ShowcaseResponse>
    fun delete(id : Int)
    fun update(id : Int, updateShowcaseRequest: UpdateShowcaseRequest) : ShowcaseResponse
}