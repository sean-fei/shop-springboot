package com.sean.shop.rest.template;

import com.sean.shop.rest.template.config.RestClientConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: sean
 * @Date: 2018/8/13 11:30
 */
public class RestTemplateUtil implements Serializable {

    /**
     * 通过config 获取api geteway 请求path
     */
    @Value("${api.gateway.path}")
    public String apiGatewayPath;

    /**
     * 通过config 获取 api geteway key
     */
    @Value("${api.gateway.key:access_token}")
    public String apiGatewayKey;

    /**
     * 通过config 获取 api geteway taken
     */
    @Value("${api.gateway.token}")
    public String apiGatewayToken;

    public RestTemplate getRestTemplate() {
        return new RestClientConfig().restTemplate();
    }

    /**
     * path 添加 token
     * @param path
     * @return
     */
    public String addAccessToken(String path) {
//        log.info("ApiGatewayUtil.addAccessToken, path = {}", path);
        if(!StringUtils.isBlank(path)) {
            if(path.indexOf("?") == -1) {
                path += "?";
            } else {
                path += "&";
            }
            path += "access_token=" + apiGatewayToken;
        }
//        log.info("ApiGatewayUtil.addAccessToken, after the production path = {}", path);
        return path;
    }

    /**
     * 查询参数模式
     */
    private static Pattern QUERY_PARAM_PATTERN = Pattern.compile("([^&=]+)(=?)([^&]+)?");

    /**
     *
     * @param url
     * @param keys
     * @return
     */
    @SuppressWarnings("unused")
    private String expandURL(String url, Set<?> keys) {
        Matcher mc = QUERY_PARAM_PATTERN.matcher(url);
        StringBuilder sb = new StringBuilder();
        if(mc.find()) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        for(Object key : keys) {
            sb.append(key).append("=").append("{").append(key).append("}").append("&");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    /**
     * @param url		绝对地址
     * @param method	请求方式
     * @param bodyType	返回类型
     * @return
     */
    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, Class<T> bodyType) {
        return this.exchange(url, method, MediaType.APPLICATION_JSON_UTF8, bodyType);
    }

    /**
     * @param url			绝对地址
     * @param method		请求方式
     * @param mediaType		MediaType
     * @param bodyType		返回类型
     * @return
     */
    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, MediaType mediaType, Class<T> bodyType) {
        return this.exchange(url, method, mediaType, bodyType, null);
    }

    /**
     * @param url		绝对地址
     * @param method	请求方式
     * @param bodyType	返回类型
     * @param params	参数(json类型)
     * @return
     */
    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, Class<T> bodyType, String params) {
        return this.exchange(url, method, MediaType.APPLICATION_JSON_UTF8, bodyType, params);
    }

    /**
     * 发送/获取 服务端数据(可以解决发送put,delete方法无返回值问题).
     * @param url			绝对地址
     * @param method		请求方式
     * @param mediaType		MediaType
     * @param bodyType		返回类型
     * @param params		参数(json类型)
     * @return
     */
    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, MediaType mediaType, Class<T> bodyType, String params) {
        // 请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        /**
         * token 以 headers 形式请求
         */
        if(!StringUtils.isBlank(apiGatewayKey) && !StringUtils.isBlank(apiGatewayToken)) {
            headers.set(apiGatewayKey, apiGatewayToken);
        }
        // 发送请求
        HttpEntity<String> entity = new HttpEntity<String>(params, headers);
        RestTemplate restTemplate = this.getRestTemplate();
        return restTemplate.exchange(url, method, entity, bodyType);
    }

}
