package com.xinjingjie.restudy.component;


import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    public MyErrorAttributes(){
        super(true);
    }
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> originMap=super.getErrorAttributes(webRequest, includeStackTrace);
        originMap.put("company","xinjingjie");
        System.out.println(originMap.get("exception"));
        Map<String,Object> myErrorInfo= (Map<String, Object>) webRequest.getAttribute("ext", RequestAttributes.SCOPE_REQUEST);
        originMap.put("ext",myErrorInfo);
        return originMap;
    }
}
