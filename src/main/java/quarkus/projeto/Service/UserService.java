package quarkus.projeto.Service;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import quarkus.projeto.Entity.UserEntity;
import quarkus.projeto.Exceptions.UserNotFoundException;

@ApplicationScoped
public class UserService {

  public UserEntity userCreate(UserEntity userEntity) {
    UserEntity.persist(userEntity);
    return userEntity;
  }

  public List<UserEntity> findAllUsers(Integer page, Integer pageSize) {
    return UserEntity.findAll()
        .page(page, pageSize)
        .list();
  }

  public UserEntity findUserById(UUID userId) {
    return (UserEntity) UserEntity.findByIdOptional(userId) // '(UserEntity) casting'
        .orElseThrow(UserNotFoundException::new);
  }

  public UserEntity updateUser(UUID userId, UserEntity userEntity) {
    // 1 - verificar se o usuario existe ou não
    var user = findUserById(userId);

    // 2 - atualizar o usuario
    user.username = userEntity.username;
    user.email = userEntity.email;

    UserEntity.persist(user);

    return user;
  }

  public void deleteUser(UUID userId) {
    var user = findUserById(userId);

    UserEntity.deleteById(user.id);

  }
}
