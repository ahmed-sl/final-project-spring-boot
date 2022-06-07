package com.example.springfinalproject.advisor;
import com.example.springfinalproject.DTO.API;
import com.example.springfinalproject.exception.InvalidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisorHandler {

    Logger logger = LoggerFactory.getLogger(ControllerAdvisorHandler.class);

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<API> handlerMethodArgument(MethodArgumentNotValidException methodArgument){
        String message = methodArgument.getFieldError().getDefaultMessage();
        logger.error("use handlerMethodArgument");
        return ResponseEntity.status(400).body(new API(message,400));
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<API> handlerDataIntegrity(DataIntegrityViolationException dataIntegrity){
        String message = dataIntegrity.getCause().getMessage();
        logger.error("use handlerDataIntegrity");
        return ResponseEntity.status(400).body(new API(message,400));
    }

    @ExceptionHandler(value = InvalidException.class)
    public ResponseEntity<API> handlerInvalidException(InvalidException invalidException){
        String message = invalidException.getMessage();
        logger.error("use handlerInvalidException");
        return ResponseEntity.status(400).body(new API(message,400));
    }
    @ExceptionHandler(value = JpaSystemException.class)
    public ResponseEntity<API> handlerJpaSystemException(JpaSystemException jpaSystemException){
        String message = jpaSystemException.getMessage();
        logger.error("use handlerJpaSystemException");
        return ResponseEntity.status(400).body(new API(message,400));
    }


}
