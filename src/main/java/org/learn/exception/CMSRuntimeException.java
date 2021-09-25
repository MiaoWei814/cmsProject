package org.learn.exception;

/**
 * 自定义异常
 *
 * @author MiaoDaWei
 * @date 2021/09/23
 */
public class CMSRuntimeException extends RuntimeException{
    /**
     * 序列化id
     */
    private static final long serialVersionUID = 1L;

    public CMSRuntimeException() {
        super();

    }
    public CMSRuntimeException(String message) {
        super(message);
    }
    public CMSRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }


    public CMSRuntimeException(Throwable cause) {
        super(cause);
    }
}