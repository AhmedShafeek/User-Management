package user.ash.usermanagement;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import user.ash.usermanagement.MVP.Model.User;


/**
 * Created by id on 4/25/17.
 */

public interface ApiServices {
    @POST("/api/v1/acl/users/login")
    Observable<User> callLogin(@Body User user);
}

