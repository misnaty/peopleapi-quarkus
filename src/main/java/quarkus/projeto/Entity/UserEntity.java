package quarkus.projeto.Entity;

import jakarta.persistence.*;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
public class UserEntity extends PanacheEntityBase {

  @Id
  @GeneratedValue
  public UUID id;
  public String username;
  public String email;

}
