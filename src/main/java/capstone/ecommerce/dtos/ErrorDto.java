package capstone.ecommerce.dtos;

import lombok.Getter;
import lombok.Setter;


public class ErrorDto {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
