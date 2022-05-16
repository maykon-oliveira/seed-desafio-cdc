package com.github.maykonoliveira.seeddesafiocdc.api.rest.output

data class ValidationErrorResponse(
    val globalErrors: MutableList<String> = mutableListOf(),
    val fieldErrors: MutableList<ValidationFieldErrorResponse> = mutableListOf()
) {
    fun addError(message: String) {
        globalErrors.add(message)
    }

    fun addFieldError(field: String, message: String) {
        fieldErrors.add(ValidationFieldErrorResponse(field, message))
    }
}

data class ValidationFieldErrorResponse(val field: String, val message: String)