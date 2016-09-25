package davidokhttputils.qq986945193.com.davidokhttputils;

import android.app.Application;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import davidokhttputils.qq986945193.com.davidokhttputils.utils.OkHttpUtils;

/**
 * @author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @交流Qq ：986945193
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initOkHttpUtils();
    }

    /**
     * 初始化构造okhttpClient对象
     */
    private void initOkHttpUtils() {
        OkHttpUtils okHttpClient = OkHttpUtils.getInstance();
    }
}
