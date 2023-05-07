package br.com.cvc.evaluation.exceptions

import jakarta.ws.rs.core.Response

class BookingPeriodInvalidException(message: String): CustomException(message, Response.Status.BAD_REQUEST.statusCode) {
}