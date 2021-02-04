package bd.edu.seu.jwtsequrity.Controller;

import bd.edu.seu.jwtsequrity.Model.Login_Credential;
import bd.edu.seu.jwtsequrity.Util.Jwt_Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jwt")
public class Home_Controller {



    @GetMapping("/get-nahid")
    public String getNahid()
    {
        return "Congratulation....! you got me";
    }


}
