package RequestBody;

public class RequestBody {
    private String lgpassword;
    private String lgname;
    private String logintoken;
    private String format;

    public RequestBody(String lgpassword, String lgname, String logintoken, String format) {
        this.lgpassword = lgpassword;
        this.lgname = lgname;
        this.logintoken = logintoken;
        this.format = format;
    }

    public RequestBody() {

    }

    public String getLgpassword() {
        return lgpassword;
    }

    public String getLgname() {
        return lgname;
    }

    public String getLogintoken() {
        return logintoken;
    }

    public String getFormat() {
        return format;
    }

    public void setLgpassword(String lgpassword) {
        this.lgpassword = lgpassword;
    }

    public void setLgname(String lgname) {
        this.lgname = lgname;
    }

    public void setLogintoken(String logintoken) {
        this.logintoken = logintoken;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
