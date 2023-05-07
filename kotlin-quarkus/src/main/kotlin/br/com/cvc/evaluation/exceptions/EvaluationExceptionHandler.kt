package br.com.cvc.evaluation.exceptions

import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider

@Provider
class EvaluationExceptionHandler : ExceptionMapper<CustomException> {
    override fun toResponse(e: CustomException): Response {
        return Response
            .status(e.statusCode)
            .entity(e.message)
            .build()
    }
}
