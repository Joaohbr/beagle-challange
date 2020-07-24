package br.com.zup.gps.api;

import br.com.zup.gps.application.BusinessException
import br.com.zup.gps.application.ErrorMessageResponse
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GPSExceptionHandler {

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    fun handleUnknownException(ex: Exception) : ErrorMessageResponse {
        ex.printStackTrace()
        return ErrorMessageResponse("Unknown error", ex.message)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleInvalidArgumentException(ex: IllegalArgumentException) : ErrorMessageResponse {
        ex.printStackTrace()
        return ErrorMessageResponse("Invalid request", ex.message)
    }

    @ExceptionHandler(BusinessException::class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    fun handleBusinessException(ex: BusinessException) : ErrorMessageResponse {
        ex.printStackTrace()
        return ErrorMessageResponse("Business error", ex.message)
    }
}
