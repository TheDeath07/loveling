package com.loveling.controller;

import com.loveling.beans.exception.CollectionNotFoundException;
import com.loveling.beans.exception.ProductNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class RestErrorController
{
    protected final Log logger = LogFactory.getLog(getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void notValidException(Exception e) {
        logger.error("+++ Not valid argument " + e);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void movieNotFound(Exception e) {
        logger.error("+++ Movie Not Found " + e);
    }

    @ExceptionHandler(CollectionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void collectionNotFound(Exception e) {
        logger.error("+++ Collection Not Found " + e);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void otherException(Exception e) {
        logger.error("+++ Other Exception " + e);
    }
}
