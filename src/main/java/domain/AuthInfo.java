package domain;

public class AuthInfo {

    private String userId;
    private String name;
    private String phoneNumber;

    public AuthInfo(String userId, String name, String phoneNumber) {
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setChangeInfo(String newName, String newPhoneNumber) {
        this.name = newName;
        this.phoneNumber = newPhoneNumber;
    }
}
