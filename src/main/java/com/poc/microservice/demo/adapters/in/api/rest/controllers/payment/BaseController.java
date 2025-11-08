package com.poc.microservice.demo.adapters.in.api.rest.controllers.payment;

import com.poc.microservice.demo.adapters.in.api.rest.commons.CustomResponse;
import com.poc.microservice.demo.application.exceptions.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static java.util.Objects.isNull;

public abstract class BaseController {
	
	protected ResponseEntity<CustomResponse> noContent(){
		return ResponseEntity.noContent().build();
	}
	
	protected ResponseEntity<CustomResponse> internalError(String api, String method){
		//return ResponseEntity.internalServerError().build();
		
		CustomResponse customResponse= new CustomResponse();
		customResponse.setApi(api);
		customResponse.setMethod(method);
		customResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.name());
		customResponse.setMessage("Internal Runtime Error");
		customResponse.setResponse(null);		
		return ResponseEntity.internalServerError().body((customResponse));
		//
	}
	
	protected ResponseEntity<CustomResponse> ok(String api, String method, Object object) {
		CustomResponse customResponse= new CustomResponse();
		customResponse.setApi(api);
		customResponse.setMethod(method);
		customResponse.setCode(HttpStatus.OK.name());
		customResponse.setMessage("Operation Executed Successfully");
		customResponse.setResponse(object);		
		return ResponseEntity.ok(customResponse);
	}
	

	
}
