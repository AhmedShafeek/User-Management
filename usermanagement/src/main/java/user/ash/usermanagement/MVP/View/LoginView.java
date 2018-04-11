package user.ash.usermanagement.MVP.View;

import org.json.JSONObject;

import user.ash.usermanagement.MVP.Model.User;

/**
 * Created by id on 5/1/17.
 */

public interface LoginView {
    void OnCall(JSONObject t);
    void OnCall(User t);
    void onLoginError(String message);
}
