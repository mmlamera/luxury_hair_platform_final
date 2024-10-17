package za.ac.cput.dto;

// UserLoginResponse.java
public class UserLoginResponse {
    private Long userId;
    private String userType;
    private String message;

    // Constructor
    public UserLoginResponse(Long userId, String userType, String message) {
        this.userId = userId;
        this.userType = userType;
        this.message = message;
    }

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
