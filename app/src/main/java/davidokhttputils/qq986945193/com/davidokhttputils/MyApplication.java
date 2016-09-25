package davidokhttputils.qq986945193.com.davidokhttputils;

import android.app.Application;

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


    private void initOkHttpUtils() {
        OkHttpUtils okHttpClient = OkHttpUtils.getInstance();
//        okHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);
//        okHttpClient.setReadTimeout(15, TimeUnit.SECONDS);
//        okHttpClient.setWriteTimeout(15, TimeUnit.SECONDS);
//
//        //ignore HTTPS Authentication
//        okHttpClient.setHostnameVerifier(new MyHostnameVerifier());
//        try {
//            SSLContext sc = SSLContext.getInstance("TLS");
//            sc.init(null, new TrustManager[]{new MyTrustManager()}, new SecureRandom());
//            okHttpClient.setSslSocketFactory(sc.getSocketFactory());
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (KeyManagementException e) {
//            e.printStackTrace();
//        }

    }
}
