package cn.yusite.shop.business;

import cn.yusite.shop.common.utils.MapperUtils;
import cn.yusite.shop.common.utils.OkHttpClientUtil;
import com.google.common.collect.Maps;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OKHttp3Tests {

    @Test
    public void testGet() {
        String url = "https://www.baidu.com";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost() {
        String url = "http://localhost:9001/oauth/token";
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("username", "admin")
                .add("password", "123456")
                .add("grant_type", "password")
                .add("client_id", "client")
                .add("client_secret", "secret")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOkHttpClient() throws Exception {
        
        String url = "http://localhost:9001/oauth/token";
        Map<String, String> params = Maps.newHashMap();
        params.put("username", "admin");
        params.put("password", "123456");
        params.put("grant_type", "password");
        params.put("client_id", "client");
        params.put("client_secret", "secret");
        Response response = OkHttpClientUtil.getInstance().postData(url, params);
        String string = response.body().string();
        Map<String, Object> jsonMap = MapperUtils.json2map(string);
        System.out.println(String.valueOf(jsonMap.get("access_token")));
    }
}
