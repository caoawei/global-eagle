package com.eagle.common.spring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.util.UrlPathHelper;

public class UriHandlerMapping implements HandlerMapping {

    private Map<String,HandlerExecutionChain> uriHandlerChainMap = new ConcurrentHashMap<>();

    private UrlPathHelper urlPathHelper = new UrlPathHelper();
    @Override
    public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
        String requestURI = request.getRequestURI();
        return uriHandlerChainMap.get(requestURI);
    }
}
