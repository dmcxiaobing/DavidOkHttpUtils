package davidokhttputils.qq986945193.com.davidokhttputils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import davidokhttputils.qq986945193.com.davidokhttputils.bean.IdCardBean;
import davidokhttputils.qq986945193.com.davidokhttputils.utils.OkHttpStopCallback;
import davidokhttputils.qq986945193.com.davidokhttputils.utils.OkHttpUtils;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @交流Qq ：986945193
 */

/**
 * 首页进入的请求类
 */
public class MainActivity extends AppCompatActivity {

    private String GetUrl = "http://apis.baidu.com/apistore/idservice/id";
    private String PostUrl = "http://apis.baidu.com/apistore/idservice/id";

    private OkHttpUtils mOkHttpUtils = OkHttpUtils.getInstance();
    private IdCardBean mIdCardBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 请求放回的是json对象
         */
//        OkHttpUtils.asyncJsonObjectByURL(GetUrl, new OkHttpUtils.OnGetJsonObjectListener() {
//            @Override
//            public void onResponse(JSONObject jsonObject) {
//                Log.e("dada", "onResponse: " + jsonObject.toString());
//
//                try {
//                    Log.e("dada", "onResponse: " + jsonObject.getString("errNum").toString());
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        /**
         * get请求返回Gson对象
         */
        OkHttpUtils.get(GetUrl, IdCardBean.class, new OkHttpStopCallback<IdCardBean>() {

            @Override
            public void onSuccess(Response response, IdCardBean idCardBean) {
                Log.e("qq986945193", "555");

                if (idCardBean != null) {
                    mIdCardBean = idCardBean;
                    Log.e("mm", idCardBean.getRetMsg());
                } else {
                    Log.e("mm", "为空了");
                }
            }

            @Override
            public void onBeforeRequest(Request request) {
                super.onBeforeRequest(request);
                Log.e("mm", "111");

            }

            @Override
            public void onError(Response response, int code, Exception e) {
                super.onError(response, code, e);
                Log.e("mm", "222" + code);

            }

            @Override
            public void onFailure(Request request, Exception e) {
                super.onFailure(request, e);
                Log.e("mm", "333");

            }

            @Override
            public void onResponse(Response response) {
                super.onResponse(response);
                Log.e("mm", "444");

            }


        });

        OkHttpUtils.get(GetUrl, String.class, new OkHttpStopCallback<String>() {
            @Override
            public void onSuccess(Response response, String s) {
                Log.e("mm", "string.class" + s);

            }

        });
        Map<String, String> params = new HashMap<>();
        params.put("id", "642226199303107806");
        OkHttpUtils.post(PostUrl, params, null, new OkHttpStopCallback<IdCardBean>() {
            @Override
            public void onSuccess(Response response, IdCardBean idCardBean) {
                Log.e("mm", "post" + idCardBean.getRetMsg());

            }
        });
    }
}
