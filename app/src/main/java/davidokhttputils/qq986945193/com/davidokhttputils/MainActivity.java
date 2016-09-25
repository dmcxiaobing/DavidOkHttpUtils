package davidokhttputils.qq986945193.com.davidokhttputils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import org.json.JSONException;
import org.json.JSONObject;

import davidokhttputils.qq986945193.com.davidokhttputils.utils.OkHttpUtils;

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

    private String GetUrl = "http://apis.baidu.com/apistore/idservice/id?id=420984198704207896";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpUtils.asyncJsonObjectByURL(GetUrl, new OkHttpUtils.OnGetJsonObjectListener() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.e("dada", "onResponse: " + jsonObject.toString());

                try {
                    Log.e("dada", "onResponse: " + jsonObject.getString("errNum").toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
