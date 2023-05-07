package br.com.cvc.evaluation.exceptions

open class CustomException(message: String, open val statusCode: Int) : Exception(message) {

}