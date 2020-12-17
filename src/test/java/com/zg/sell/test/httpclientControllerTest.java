package com.zg.sell.test;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class httpclientControllerTest {

    //https://blog.csdn.net/justry_deng/article/details/81042379
    @Test
    public void dohttpclienttest(){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://localhost:8080/dohttpclienttest");
        CloseableHttpResponse response = null;
        try {
            response=httpClient.execute(httpGet);
            //从响应模型中获取响应实体
            HttpEntity responseEntity= response.getEntity();
            System.out.println("响应状态为："+response.getStatusLine());
            if (responseEntity!=null){
                System.out.println("响应内容长度为："+responseEntity.getContentLength());
                System.out.println("响应内容为："+ EntityUtils.toString(responseEntity));
            }
        }
        catch (ClientProtocolException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (httpClient !=null)
                    httpClient.close();
                if (response!=null)
                    response.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}