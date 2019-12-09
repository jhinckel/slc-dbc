package br.com.dbc.slc.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.dbc.slc.bcmsg.BcmsgNotFoundException;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler  {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exception(final Exception ex) {
		LOGGER.error("Unexpected Error", ex);

		return buildResponseEntity(new ApiServiceError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex));
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> exception(final RuntimeException ex) {
		LOGGER.error("Unexpected Error", ex);

		return buildResponseEntity(new ApiServiceError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex));
	}

	@ExceptionHandler(ServiceCommunicationException.class)
	public ResponseEntity<?> exception(final ServiceCommunicationException ex) {
		LOGGER.error("Service communication Error", ex);

		return buildResponseEntity(new ApiServiceError(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage(), ex));
	}

	@ExceptionHandler(BcmsgNotFoundException.class)
	public ResponseEntity<?> exception(final BcmsgNotFoundException ex) {
		LOGGER.error("Client not found exception", ex);

		return buildResponseEntity(new ApiServiceError(HttpStatus.NOT_FOUND, "BCMSG not found!", ex));
	}

	@ExceptionHandler(JsonProcessingException.class)
	public ResponseEntity<?> exception(final JsonProcessingException ex) {
		LOGGER.error("JSON process exception", ex);

		return buildResponseEntity(new ApiServiceError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex));
	}

	private ResponseEntity<Object> buildResponseEntity(ApiServiceError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}
