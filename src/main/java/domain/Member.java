package domain;

import java.time.LocalDateTime;

public class Member {

    private long id;
    private String userId;
    private String password;
    private String confirmPassword;
    private String name;
    private String nickName;
    private String phoneNumber;
    private String email;
    private LocalDateTime regTime;

    public Member(String userId, String password, String name, String nickName, String phoneNumber, String email, LocalDateTime regTime) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.regTime = regTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getRegTime() {
        return regTime;
    }
}
