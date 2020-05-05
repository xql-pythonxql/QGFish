package gdut.QG.QGFish.domain;

public class ResponseInfo {

    // 状态
    private boolean status;
    // 信息
    private String message;
    // 数据
    private Object data;

    @Override
    public String toString() {
        return "ResponseInfo{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
