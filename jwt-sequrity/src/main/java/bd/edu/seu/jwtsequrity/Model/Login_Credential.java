package bd.edu.seu.jwtsequrity.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login_Credential {

    private String name;
    private String pass;
}
