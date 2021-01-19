package com.demo.demo.controlleradvice;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 编写全局异常处理类,也就是ControllerAdvice(Controller增强,自spring3.2的时候推出)
 * 用于处理当数据库事务业务和预期不同的时候抛出封装后的异常，进行数据库事务回滚，并将异常的显示给用户
 *
 * @author ：zhengrong.liu@taotu-partner.com
 * @since ：Created in 2019/9/30 16:48
 */
@RestControllerAdvice
public class MyExceptionHandler {
    /**
     * 如果全部异常处理返回json格式，那么可以使用 @RestControllerAdvice 代替 @ControllerAdvice ，
     * 这样在方法上就可以不需要添加 @ResponseBody.
     * 而@ResponseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后,
     * 写入到response对象的body区，通常用来返回JSON数据或者是XML数据。
     */

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     *
     * @param binder binder
     */
    @InitBinder
    public void initWebBinder(WebDataBinder binder) {
        //对日期的统一处理
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
        //添加对数据的校验
        //binder.setValidator();
    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     *
     * @param model model
     */
    @ModelAttribute
    public void addAttribute(Model model) {
        model.addAttribute("attribute", "The Attribute");
    }

    /**
     * 捕获CustomException
     *
     * @param e e
     * @return json格式类型
     */
    @ExceptionHandler(CustomException.class) //指定拦截异常的类型
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //自定义浏览器返回状态码
    public Map<String, Object> handlerMethod(CustomException e) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("code", e.getCode());
        map.put("msg", e.getMsg());
        return map;
    }
}
