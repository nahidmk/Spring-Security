package bd.edu.seu.jwtsequrity.Repository;

import bd.edu.seu.jwtsequrity.Model.Register;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterRepository extends MongoRepository<Register,String> {
    public List<Register> findByEmail (String value);
    public List<Register> findByPhone (String value);
    public Register findByUserName (String value);
}
