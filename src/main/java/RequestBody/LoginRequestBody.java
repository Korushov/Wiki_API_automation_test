package RequestBody;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginRequestBody {

    private String lgpassword;
    private String lgname;
    private String logintoken;

//    public LoginRequestBody(String lgpassword, String lgname, String logintoken) {
//        this.lgpassword = lgpassword;
//        this.lgname = lgname;
//        this.logintoken = logintoken;
//    }


}
