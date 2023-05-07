package br.com.cvc.evaluation.exceptions

import jakarta.ws.rs.core.Response

class HotelNotFoundException(message: String): CustomException(message, Response.Status.NOT_FOUND.statusCode) {
}