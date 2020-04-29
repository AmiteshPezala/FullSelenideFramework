package MRCS.TestData;

public class UsersTestData {
    private String UserId, Password,UserURL;
    public String getUserId() {
        return UserId;
    }
    public void setUserId(String userId) {
        UserId = userId;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public String getUserURL() {
        return UserURL;
    }
    public void setUserURL(String userURL) {
        UserURL = userURL;
    }
    @Override
    public String toString() {
        return "UsersTestData{" +
                "UserId='" + UserId + '\'' +
                ", Password='" + Password + '\'' +
                ", UserURL='" + UserURL + '\'' +
                '}';
    }
}
