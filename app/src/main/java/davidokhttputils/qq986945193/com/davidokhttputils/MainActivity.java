package davidokhttputils.qq986945193.com.davidokhttputils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private String GetUrl = "http://apis.baidu.com/apistore/idservice/id?id=420984198704207896";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpUtils.asyncJsonObjectByURL(GetUrl, new OkHttpUtils.Func4() {
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
