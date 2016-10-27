package accounting.webservice.login;

import java.net.URI;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import accounting.webservice.login.entity.User;

@Path("/")
public class LoginService {

	@POST
	@Path("/login")
	@Produces("application/json")
	public Response login(User user) {
		try {
			Response response = Response
					.created(URI.create("/"))
					.entity(user)
					.status(200)
		            .build();
			return response;
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.header("Access-Control-Allow-Origin", "http://192.168.1.2:3000").build();
		}
	}

}
