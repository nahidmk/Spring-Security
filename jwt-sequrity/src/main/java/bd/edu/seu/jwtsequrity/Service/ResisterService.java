package bd.edu.seu.jwtsequrity.Service;

import bd.edu.seu.jwtsequrity.Model.Register;
import bd.edu.seu.jwtsequrity.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResisterService {

    @Autowired
    private RegisterRepository registerRepository;


    public String save_Register(Register register)
    {
        List<Register> byEmailAndPhone1 = registerRepository.findByEmail(register.getEmail());
        List<Register> byEmailAndPhone2 = registerRepository.findByPhone(register.getPhone());
        Register byUserName = registerRepository.findByUserName(register.getUserName());


        if(byEmailAndPhone1.size()>0){
            return "Sorry..! this email is already used";
        }
        if(byEmailAndPhone2.size()>0){
            return "Sorry..! this phone number is already used";
        }
        if(byUserName!=null){
            return "Sorry..! this user name is already use";
        }

        registerRepository.save(register);
        return "Register is created successfully ";


//        if(byEmailAndPhone1.isEmpty()&&byEmailAndPhone2.isEmpty()&&byUserName==null){
//            registerRepository.save(register);
//            return HttpStatus.CREATED.name();
//        }else {
//            return HttpStatus.BAD_REQUEST.name();
//        }

    }

    public Register find_By_userName(String userName){
        return registerRepository.findByUserName(userName);
    }
}
