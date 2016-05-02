package com.cadastrocaelum.utils.support;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;

/**
 * Created by Victor on 01/05/2016.
 * talvez aparecça que nao existe essa classe, caso isso aconteca
 * va no gradle e coloque a seguinte linha
 * useLibrary  'org.apache.http.legacy'
 * logo abaixo da versao do build
 */
public class WebClient {
    private String url;

    public WebClient(String url) {
        this.url = url;
    }

    public String post(String json){
        try {
            HttpPost post = new HttpPost(url);
            post.setEntity(new StringEntity(json));
            post.setHeader("Content-type", "application/json");
            post.setHeader("Accept", "application/json");

            HttpClient client = new DefaultHttpClient();
            HttpResponse resposta = client.execute(post);

            return EntityUtils.toString(resposta.getEntity());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
