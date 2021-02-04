package bd.edu.seu.jwtsequrity.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document
@TypeAlias("Register")
public class Register {

    @Id
    private String userName;
    private String password;
    private String phone;
    private String email;
}
