public class AuthenticationResponse {
    private String jwt;
    private boolean isNew;

    public AuthenticationResponse(String jwt, boolean isNew) {
        this.jwt = jwt;
        this.isNew = isNew;
    }

    // getters and setters
    public String getJwt() {
        return jwt;
    }

    public boolean getIsNew() {
        return isNew;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }
}