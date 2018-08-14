package com.sean.shop.rest.template.handler;

import com.sean.shop.commons.exception.BusinessRuntimeException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: sean
 * @Date: 2018/8/13 11:32
 */
public class CustomErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().value() != HttpServletResponse.SC_OK;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(response.getBody()));
        StringBuilder sb = new StringBuilder();
        String str = null;
        while((str = br.readLine()) != null) {
            sb.append(str);
        }
        try {
            throw new BusinessRuntimeException(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
