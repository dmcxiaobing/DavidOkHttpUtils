package davidokhttputils.qq986945193.com.davidokhttputils;

/**
 * @author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @交流Qq ：986945193
 */

/**
 * 身份证查询结果的bean
 *
 */
public class IdCardBean {

    /**
     * errNum : 0
     * retMsg : success
     * retData : {"address":"湖北省孝感市汉川市","sex":"M","birthday":"1987-04-20"}
     */

    private int errNum;
    private String retMsg;
    /**
     * address : 湖北省孝感市汉川市
     * sex : M
     * birthday : 1987-04-20
     */

    private RetDataEntity retData;

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public void setRetData(RetDataEntity retData) {
        this.retData = retData;
    }

    public int getErrNum() {
        return errNum;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public RetDataEntity getRetData() {
        return retData;
    }

    public static class RetDataEntity {
        private String address;
        private String sex;
        private String birthday;

        public void setAddress(String address) {
            this.address = address;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAddress() {
            return address;
        }

        public String getSex() {
            return sex;
        }

        public String getBirthday() {
            return birthday;
        }
    }
}
