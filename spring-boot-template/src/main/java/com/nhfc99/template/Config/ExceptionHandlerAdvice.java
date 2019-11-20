package com.nhfc99.template.Config;

import com.nhfc99.template.Utils.JSONUtils;
import com.nhfc99.template.Utils.PR;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
	private static Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    //自定义http status，数据校验异常
    private final int STATUS_VALIDATE = 480;

    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    public String runtimeExceptionHandler(RuntimeException ex) {
        return resultFormat(500, ex);
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException ex) {
        return resultFormat(500, ex);
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    public String classCastExceptionHandler(ClassCastException ex) {
        return resultFormat(500, ex);
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    public String iOExceptionHandler(IOException ex) {
        return resultFormat(500, ex);
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    public String noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return resultFormat(500, ex);
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public String indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return resultFormat(500, ex);
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public String requestNotReadable(HttpMessageNotReadableException ex) {
        System.out.println("400..requestNotReadable");
        return resultFormat(400, ex);
    }

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    public String requestTypeMismatch(TypeMismatchException ex) {
        System.out.println("400..TypeMismatchException");
        return resultFormat(400, ex);
    }

    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public String requestMissingServletRequest(MissingServletRequestParameterException ex) {
        System.out.println("400..MissingServletRequest");
        return resultFormat(400, ex);
    }

    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public String request405(HttpRequestMethodNotSupportedException ex) {
        return resultFormat(405, ex);
    }

    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public String request406(HttpMediaTypeNotAcceptableException ex) {
        return resultFormat(406, ex);
    }

    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public String server500(RuntimeException ex) {
        return resultFormat(500, ex);
    }

    //栈溢出
    @ExceptionHandler({StackOverflowError.class})
    public String requestStackOverflow(StackOverflowError ex) {
        return resultFormat(500, ex);
    }

    //除数不能为0
    @ExceptionHandler({ArithmeticException.class})
    public String arithmeticException(ArithmeticException ex) {
        return resultFormat(500, ex);
    }

    //其他错误
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Object handleControllerException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        PR result;
        int code = response.getStatus();
        response.setStatus(480);
        if (404 == code) {
            result = PR.error(404, ex.getMessage());
        } else if (403 == code) {
            result = PR.error(403, ex.getMessage());
        } else if (401 == code) {
            result = PR.error(403, ex.getMessage());
        } else {
            result = PR.error(500, ex.getMessage());
        }
        return JSONUtils.beanToJson(result);
    }

    private <T extends Throwable> String resultFormat(int code, T ex) {
        ex.printStackTrace();
        logger.error(ex.getMessage());
        return JSONUtils.beanToJson(PR.error(code, ex.getMessage()));
    }
}