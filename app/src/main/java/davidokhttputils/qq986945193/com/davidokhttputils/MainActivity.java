package davidokhttputils.qq986945193.com.davidokhttputils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import davidokhttputils.qq986945193.com.davidokhttputils.bean.IdCardBean;
import davidokhttputils.qq986945193.com.davidokhttputils.callback.OkHttpStopCallback;
import davidokhttputils.qq986945193.com.davidokhttputils.callback.OnGetByteArrayListener;
import davidokhttputils.qq986945193.com.davidokhttputils.callback.OnGetJsonObjectListener;
import davidokhttputils.qq986945193.com.davidokhttputils.callback.OnGetOkhttpStringListener;
import davidokhttputils.qq986945193.com.davidokhttputils.constants.Constant;
import davidokhttputils.qq986945193.com.davidokhttputils.utils.OkHttpUtils;
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

    private OkHttpUtils mOkHttpUtils;
    private IdCardBean mIdCardBean;
    private Button btn_get_one;
    private Button btn_get_two;
    private Button btn_get_three;
    private Button btn_get_five;
    private Button btn_get_six;
    private Button btn_get_seven;
    private Map<String, String> params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setOnclickListener();
    }

    /**
     * 设置监听事件
     */
    private void setOnclickListener() {
        /**
         * 请求指定的url返回的结果是json字符串
         */
        btn_get_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOkHttpUtils.asyncJsonStringByURL(GetUrl, new OnGetOkhttpStringListener() {
                    @Override
                    public void onResponse(String result) {
                        if (result != null && !result.equals("")) {
                            Log.e(Constant.TAG, "asyncJsonObjectByURL" + result);
                        }
                    }
                });
            }
        });

        /**
         *请求返回的是jsonOject对象
         */
        btn_get_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOkHttpUtils.asyncJsonObjectByURL(GetUrl, new OnGetJsonObjectListener() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Log.e(Constant.TAG, "asyncJsonObjectByURL: " + jsonObject.toString());
                        try {
                            Log.e(Constant.TAG, "onResponse: " + jsonObject.getString("errNum").toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }


        });

        /**
         * 请求返回的是byte字节数组
         */
        btn_get_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOkHttpUtils.asyncGetByteByURL(GetUrl, new OnGetByteArrayListener() {
                    @Override
                    public void onResponse(byte[] result) {
                        if (result != null) {
                            Log.e(Constant.TAG, "onResponse: " + result);

                        }
                    }
                });
            }
        });

        /**
         * 表单提交，post请求，返回jsonobject对象
         */
        btn_get_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOkHttpUtils.sendComplexForm(PostUrl, params, new OnGetJsonObjectListener() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Log.e(Constant.TAG, "asyncJsonObjectByURL: " + jsonObject.toString());
                        try {
                            Log.e(Constant.TAG, "onResponse: " + jsonObject.getString("errNum").toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        /**
         *GET请求返回结果是 实体类对象 类型
         */
        btn_get_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 返回String类型
                 */
//                mOkHttpUtils.get(GetUrl, String.class, new OkHttpStopCallback<String>() {
//                    @Override
//                    public void onSuccess(Response response, String s) {
//                        Log.e(Constant.TAG, "string.class" + s);
//                    }
//
//                });

                /**
                 * get请求返回Bean对象
                 */
                mOkHttpUtils.get(GetUrl, IdCardBean.class, new OkHttpStopCallback<IdCardBean>() {

                    @Override
                    public void onSuccess(Response response, IdCardBean idCardBean) {
                        if (idCardBean != null) {
                            mIdCardBean = idCardBean;
                            if (mIdCardBean.getRetMsg() != null) {
                                Log.e(Constant.TAG, mIdCardBean.getRetMsg());
                            }
                        } else {
                            Log.e(Constant.TAG, "idCardBean为空了");
                        }
                    }
                });
            }
        });
        /**
         * POST请求返回结果是 实体类对象 类型
         */
        btn_get_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOkHttpUtils.post(PostUrl, params, null, new OkHttpStopCallback<IdCardBean>() {
                    @Override
                    public void onSuccess(Response response, IdCardBean idCardBean) {
                        Log.e(Constant.TAG, "post" + idCardBean.getRetMsg());

                    }
                });
            }
        });


    }

    private void initView() {
        btn_get_one = (Button) findViewById(R.id.btn_get_one);
        btn_get_two = (Button) findViewById(R.id.btn_get_two);
        btn_get_three = (Button) findViewById(R.id.btn_get_three);
        btn_get_five = (Button) findViewById(R.id.btn_get_five);
        btn_get_six = (Button) findViewById(R.id.btn_get_six);
        btn_get_seven = (Button) findViewById(R.id.btn_get_seven);
        mOkHttpUtils = MyApplication.getApp().getOkHttpUtils();
        params = new HashMap<>();
        params.put("id", "642226199303107806");

        mOkHttpUtils.post(PostUrl, params, null, new OkHttpStopCallback<IdCardBean>() {
            @Override
            public void onSuccess(Response response, IdCardBean idCardBean) {
                Log.e(Constant.TAG, "post" + idCardBean.getRetMsg());

            }
        });
    }


}
