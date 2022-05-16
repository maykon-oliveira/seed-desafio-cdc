package com.github.maykonoliveira.seeddesafiocdc.api.rest

import com.github.maykonoliveira.seeddesafiocdc.api.rest.output.ValidationErrorResponse
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.validation.BindException
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestControllerAdvice(val messageSource: MessageSource) {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException::class)
    fun beanValidation(exception: BindException): ValidationErrorResponse {
        val globalErrors = exception.bindingResult.globalErrors
        val fieldErrors = exception.bindingResult.fieldErrors

        return buildErrorResponse(globalErrors, fieldErrors)
    }

    private fun buildErrorResponse(
        globalErrors: List<ObjectError>,
        fieldErrors: List<FieldError>
    ): ValidationErrorResponse {
        val response = ValidationErrorResponse()

        globalErrors.forEach { response.addError(getErrorMessage(it)) }
        fieldErrors.forEach {
            val errorMessage = getErrorMessage(it)
            response.addFieldError(it.field, errorMessage)
        }

        return response
    }

    private fun getErrorMessage(error: ObjectError): String = messageSource.getMessage(error, LocaleContextHolder.getLocale())

}