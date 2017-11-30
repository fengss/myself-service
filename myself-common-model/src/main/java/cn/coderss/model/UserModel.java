package cn.coderss.model;

/**
 * Created with myself-service.
 *
 * @author: shenwei
 * Date: 2017/11/21
 * Time: 下午2:44
 */
public class UserModel {
    private int id;
    private String userName;
    private int age;
    private String nickName;
    private String server;

    public UserModel(int id, String userName, int age, String nickName, String server) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.nickName = nickName;
        this.server = server;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                ", server='" + server + '\'' +
                '}';
    }
}
