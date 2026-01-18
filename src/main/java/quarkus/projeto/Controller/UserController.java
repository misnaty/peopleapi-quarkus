package quarkus.projeto.Controller;

import quarkus.projeto.Entity.UserEntity;
import quarkus.projeto.Service.UserService;

import java.util.UUID;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;

@Path("/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  // MOSTRAR USUARIOS
  @GET
  @Path("/list")
  public Response findAllUsers(@QueryParam("page") @DefaultValue("0") Integer page,
      @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) { // Mostra conteúdo na tela, 10 é padrão.

    var users = userService.findAllUsers(page, pageSize);

    return Response.ok(users).build();
  }

  // MOSTRAR USUARIO POR ID
  @GET
  @Path("/{id}")
  public Response findUserById(@PathParam("id") UUID id) {

    var userId = userService.findUserById(id);

    return Response.ok(userId).build();
  }

  // CRIAR USUARIO
  @POST
  @Path("/create")
  @Transactional
  public Response createUser(UserEntity userEntity) {
    return Response.ok(userService.userCreate(userEntity)).build();
  }

  // ATUALIZAR USUARIO
  @PUT
  @Path("update/{id}")
  @Transactional
  public Response updateUser(@PathParam("id") UUID id, UserEntity userEntity) {

    var updatedUser = userService.updateUser(id, userEntity);

    return Response.ok(updatedUser).build();

  }

  // DELETAR USUARIO
  @DELETE
  @Path("/delete/{id}")
  @Transactional
  public Response deleteUser(@PathParam("id") UUID id) {
    userService.deleteUser(id);
    return Response.noContent().build();

  }

}
