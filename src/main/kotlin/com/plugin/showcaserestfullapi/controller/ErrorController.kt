package com.plugin.showcaserestfullapi.controller

import com.plugin.showcaserestfullapi.helper.BaseResponse
import com.plugin.showcaserestfullapi.helper.NotFoundException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException) : BaseResponse<String> {
        return BaseResponse(
            code = 400,
            status = "Bad Request",
            data = constraintViolationException.message!!
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFoundHandler(notFoundException: NotFoundException) : BaseResponse<String> {
        return BaseResponse(
            code = 404,
            status = "Not Found",
            data = "Data Not Found"
        )
    }
}
