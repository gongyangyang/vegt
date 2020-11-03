package com.vegt.controller;
import com.vegt.service.exception.*;
import com.vegt.util.JsonResult;
import org.springframework.web.bind.annotation.*;
import sun.plugin2.message.Message;

/*对控制器中的
  异常进行统一处理
 */
public abstract class BaseController {
    protected  static final Integer SUCCESS = 20;
    protected  static final Integer ERROR_USER = 30;
    protected  static final Integer ERROR_INSERT = 40;
    @ExceptionHandler({ServiceException.class})
    @ResponseBody
    public JsonResult<Void> HandleException(Throwable e){
        JsonResult<Void> jr = new JsonResult<Void>(e.getMessage());
        if(e instanceof UserNotFoundException){
            jr.setState(ERROR_USER);
        }else if ( e instanceof PasswordNotMatchException){
            jr.setState(31);
        }else if (e instanceof UserDuplicateException) {
            jr.setState(41);
        }else if (e instanceof InsertException){
            jr.setState(42);
        }else if(e instanceof VegtDuplicateException){
            jr.setState(51);
        }
        return  jr;
    }

}
