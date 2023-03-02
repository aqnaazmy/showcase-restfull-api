package com.plugin.showcaserestfullapi.service.impl

import com.cloudinary.utils.ObjectUtils
import com.plugin.showcaserestfullapi.config.CloudinaryConfig
import com.plugin.showcaserestfullapi.entity.Showcase
import com.plugin.showcaserestfullapi.helper.NotFoundException
import com.plugin.showcaserestfullapi.helper.ValidationUtil
import com.plugin.showcaserestfullapi.model.CreateShowcaseRequest
import com.plugin.showcaserestfullapi.model.ListShowcaseRequest
import com.plugin.showcaserestfullapi.model.ShowcaseResponse
import com.plugin.showcaserestfullapi.model.UpdateShowcaseRequest
import com.plugin.showcaserestfullapi.repository.CategoryRepository
import com.plugin.showcaserestfullapi.repository.ShowcaseRepository
import com.plugin.showcaserestfullapi.service.ShowcaseService
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class ShowcaseServiceImpl(val showcaseRepository: ShowcaseRepository,val categoryRepository: CategoryRepository , val validationUtil: ValidationUtil) :
    ShowcaseService {
    override fun create(createShowcaseRequest: CreateShowcaseRequest): ShowcaseResponse {
        //       validationUtil.validate(createShowcaseRequest)
        val kategori = categoryRepository.findCategoryByIdCategory(createShowcaseRequest.idCategory)
        val cloudinary = CloudinaryConfig()
        val uploadResponse =
            cloudinary.cloudinaryAccount().uploader().upload(createShowcaseRequest.image.bytes, ObjectUtils.asMap())

        val showcase = Showcase(
            title = createShowcaseRequest.title!!,
            image = uploadResponse.get("url").toString()!!,
            description = createShowcaseRequest.description!!,
            createdAt = Date(),
            updatedAt = Date()
        )
        showcase.category = kategori

        showcaseRepository.save(showcase)
        return convertShowcaseToShowcaseResponse(showcase)
    }


    override fun get(id: Int): ShowcaseResponse {
        val showcase = showcaseRepository.findByIdOrNull(id)
        if (showcase === null) {
            throw NotFoundException()
        } else {
            return convertShowcaseToShowcaseResponse(showcase)
        }
    }

    override fun list(listShowcaseRequest: ListShowcaseRequest): List<ShowcaseResponse> {
        val page = showcaseRepository.findAll(
            PageRequest.of(
                listShowcaseRequest.page,
                listShowcaseRequest.size
            )
        )
        val showcases: List<Showcase> = page.get().collect(Collectors.toList())
        return showcases.map { convertShowcaseToShowcaseResponse(it) }
    }

    override fun delete(id: Int) {
        showcaseRepository.deleteById(id)
    }

    override fun update(id : Int, updateShowcaseRequest: UpdateShowcaseRequest): ShowcaseResponse {
        val showcase = showcaseRepository.findByIdOrNull(id)
        if (showcase === null) {
            throw NotFoundException()
        }
        showcase.apply {
            title = updateShowcaseRequest.title!!
            description = updateShowcaseRequest.description!!
            updatedAt = Date()
        }
        showcaseRepository.save(showcase)
        return convertShowcaseToShowcaseResponse(showcase)
        }



    }





    private fun convertShowcaseToShowcaseResponse(showcase: Showcase): ShowcaseResponse {
        return ShowcaseResponse(
            id = showcase.id,
            title = showcase.title,
            image = showcase.image,
            categoryName = showcase.category.categoryName,
            description = showcase.description,
            createdAt = showcase.createdAt,
            updatedAt = showcase.updatedAt
        )
    }
