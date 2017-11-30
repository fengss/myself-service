package cn.coderss.model;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/24
 * Time: 下午2:22
 */
public class EnterpriseModel {
    private int enterpriseId;
    private String enterpriseName;
    private String enterpriseCode;
    private String server;

    public EnterpriseModel(int enterpriseId, String enterpriseName, String enterpriseCode, String server) {
        this.enterpriseId = enterpriseId;
        this.enterpriseName = enterpriseName;
        this.enterpriseCode = enterpriseCode;
        this.server = server;
    }

    @Override
    public String toString() {
        return "EnterpriseModel{" +
                "enterpriseId=" + enterpriseId +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", enterpriseCode='" + enterpriseCode + '\'' +
                ", server='" + server + '\'' +
                '}';
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
