package br.com.zup.gps.application

import java.lang.RuntimeException

data class BusinessException(override val message: String?): RuntimeException() {

}