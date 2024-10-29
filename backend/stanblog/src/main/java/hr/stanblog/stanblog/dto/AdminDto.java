package hr.stanblog.stanblog.dto;

public class AdminDto {
    private String email;

    private String password;

    public AdminDto (String email, String password) {
        this.email = email;
        this.password = password;
    }
    

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
