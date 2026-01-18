package quarkus.projeto.Exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class UserResponseExceptionMapper implements
    ExceptionMapper<UserNotFoundException> {

  @Override
  public Response toResponse(UserNotFoundException exception) {
    System.out.println("user not found");
    return Response.status(Response.Status.NOT_FOUND)
        .entity("User not found")
        .build();
  }
}
