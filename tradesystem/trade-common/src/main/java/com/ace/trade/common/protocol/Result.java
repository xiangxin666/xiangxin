package com.ace.trade.common.protocol;

public class Result<T> {
    private String retCode;
    private String retInfo;
    private T data;
    private Class<T> cls;

    public Result(){

    }
    public Result(Class<T>  cls) throws IllegalAccessException, InstantiationException {
        this.cls=cls;
        this.data=cls.newInstance();
    }



    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetInfo() {
        return retInfo;
    }

    public void setRetInfo(String retInfo) {
        this.retInfo = retInfo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "retCode='" + retCode + '\'' +
                ", retInfo='" + retInfo + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
