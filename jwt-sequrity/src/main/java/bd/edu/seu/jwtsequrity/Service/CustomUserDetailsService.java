package bd.edu.seu.jwtsequrity.Service;

import bd.edu.seu.jwtsequrity.Model.Register;
import bd.edu.seu.jwtsequrity.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private RegisterRepository registerRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Register byUserName = registerRepository.findByUserName(userName);
        if(byUserName!=null){
            return new User(byUserName.getUserName(),byUserName.getPassword(),new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }

//        if(userName.equals("nahid")){
//            return new User("nahid","mk",new ArrayList<>());
//        }else {
//            throw new UsernameNotFoundException("User not found with username: " + userName);
//        }
    }
}
