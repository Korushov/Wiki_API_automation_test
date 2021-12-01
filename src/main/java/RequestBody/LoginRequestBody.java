package RequestBody;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginRequestBody {

    private String lgpassword;
    private String lgname;
    private String logintoken;



}
