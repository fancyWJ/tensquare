package entity;

public enum  StatusCode {
    OK(2000),//成功
    ERROR(2001),//失败
    LOGINERROR(2002),//用户名或密码错误
    ACCESSERROR(2003),//权限不足
    REMOTEERROE(2004),//远程调用失败
    REPERROR(2005);//重复操作
    int code;

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    StatusCode(int code) {
        this.code = code;
    }
}
