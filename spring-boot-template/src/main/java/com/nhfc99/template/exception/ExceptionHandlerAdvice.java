package com.nhfc99.template.exception;

import com.nhfc99.template.utils.JSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    private static Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    //自定义http status，数据校验异常
    private final int STATUS_VALIDATE = 480;

    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    public Object runtimeExceptionHandler(RuntimeException ex) {
        return resultFormat(500, ex);
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public Object nullPointerExceptionHandler(NullPointerException ex) {
        return resultFormat(500, ex);
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    public Object classCastExceptionHandler(ClassCastException ex) {
        return resultFormat(500, ex);
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    public Object iOExceptionHandler(IOException ex) {
        return resultFormat(500, ex);
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    public Object noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return resultFormat(500, ex);
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public Object indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return resultFormat(500, ex);
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})

    public Object requestNotReadable(HttpMessageNotReadableException ex) {
        System.out.println("400..requestNotReadable");
        return resultFormat(400, ex);
    }

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    public Object requestTypeMismatch(TypeMismatchException ex) {
        System.out.println("400..TypeMismatchException");
        return resultFormat(400, ex);
    }

    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public Object requestMissingServletRequest(MissingServletRequestParameterException ex) {
        System.out.println("400..MissingServletRequest");
        return resultFormat(400, ex);
    }

    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Object request405(HttpRequestMethodNotSupportedException ex) {
        return resultFormat(405, ex);
    }

    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public Object request406(HttpMediaTypeNotAcceptableException ex) {
        return resultFormat(406, ex);
    }

    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public Object server500(RuntimeException ex) {
        return resultFormat(500, ex);
    }

    //栈溢出
    @ExceptionHandler({StackOverflowError.class})
    public Object requestStackOverflow(StackOverflowError ex) {
        return resultFormat(500, ex);
    }

    //除数不能为0
    @ExceptionHandler({ArithmeticException.class})
    public Object arithmeticException(ArithmeticException ex) {
        return resultFormat(500, ex);
    }

    //其他错误
    @ResponseBody
    @ExceptionHandler(value = Exception.class)//指定拦截的异常
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) throws Exception {
        JSONResult result;
        int code = response.getStatus();
        response.setStatus(480);

        if (ex instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            result = JSONResult.result(404, ex.getMessage());
        } else if (404 == code) {
            result = JSONResult.result(404, ex.getMessage());
        } else if (403 == code) {//403错误，权限不足
            result = JSONResult.result(403, ex.getMessage());
        } else if (401 == code) {
            result = JSONResult.result(401, ex.getMessage());
        } else {
            result = JSONResult.result(500, ex.getMessage());
        }
        return result;
    }

    private <T extends Throwable> JSONResult resultFormat(int code, T ex) {
        JSONResult json = JSONResult.result(code, ex.getMessage());
        return json;
    }
}