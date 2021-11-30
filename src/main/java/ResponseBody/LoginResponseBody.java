package ResponseBody;

import Entities.Login;
import Entities.WarningsBlock;
import lombok.Data;

@Data
public class LoginResponseBody {

    private WarningsBlock warnings;

    private Login login;

}
