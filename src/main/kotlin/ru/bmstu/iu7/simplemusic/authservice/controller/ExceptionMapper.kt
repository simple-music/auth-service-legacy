package ru.bmstu.iu7.simplemusic.authservice.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.bmstu.iu7.simplemusic.authservice.exception.NotFoundException
import ru.bmstu.iu7.simplemusic.authservice.model.Error

@RestControllerAdvice
class ExceptionMapper {
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(exception: NotFoundException): ResponseEntity<Error> {
        val error = Error(exception.message!!)
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error)
    }
}
