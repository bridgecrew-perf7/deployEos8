package primeton.eos8.deploy.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@ControllerAdvice
public class GlobalControllerExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    @ExceptionHandler(value = IllegalArgumentException.class)
    @ResponseBody
    public ResponseEntity<String> parameterErrorHandler(HttpServletRequest req, IllegalArgumentException e) {
        ResponseEntity responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(value = IOException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> IOErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ResponseEntity responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        return responseEntity;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void othersErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        String url = req.getRequestURI();
        logger.error("request error at " + url, e);
    }
}
