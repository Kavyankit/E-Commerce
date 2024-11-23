package capstone.ecommerce.advices;

import capstone.ecommerce.dtos.ErrorDto;
import capstone.ecommerce.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice

public class ControllerAdvice {
    /*@ExceptionHandler
    public ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(ProductNotFoundException.getMessage());
        ResponseEntity<ErrorDto> errorDtoResponseEntity = new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
        return errorDtoResponseEntity;
    }*/
}
