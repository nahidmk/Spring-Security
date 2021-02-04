package bd.edu.seu.jwtsequrity.Controller;

import bd.edu.seu.jwtsequrity.Model.Register;
import bd.edu.seu.jwtsequrity.Service.ResisterService;
import bd.edu.seu.jwtsequrity.Util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class Register_Controller {
    @Autowired
    private ResisterService resisterService;

    @PostMapping("/add")
    public ResponseEntity<?> save_register(@RequestBody Register register){
        String s = resisterService.save_Register(register);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),s),HttpStatus.OK);
    }

}
