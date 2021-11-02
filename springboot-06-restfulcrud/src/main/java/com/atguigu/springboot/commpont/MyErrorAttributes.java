package com.atguigu.springboot.commpont;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

// 给容器中加入我们自定义的ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    /**
     * 返回的map 页面和json能获取的所有字段
     *
     * @param webRequest
     * @param options
     * @return
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        errorAttributes.put("ext", ext);
        return errorAttributes;
    }
}
