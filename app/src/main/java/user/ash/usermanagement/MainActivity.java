package user.ash.usermanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONObject;

import user.ash.usermanagement.MVP.Presenter.BasePresenter;
import user.ash.usermanagement.MVP.Presenter.LoginPresenter;
import user.ash.usermanagement.MVP.Model.User;
import user.ash.usermanagement.MVP.View.LoginView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        new BasePresenter("http://dev.itida.idco.sa/");
//
//        User post = new User();
//        post.setAdmin(0);
//        post.setEmail("ahmed.sh.elsayed@gmail.com");
//        post.setPassword("12345678");
//
//        new LoginPresenter(new LoginView() {
//            @Override
//            public void OnCall(JSONObject t) {
//
//            }
//
//            @Override
//            public void OnCall(User t) {
//                Toast.makeText(MainActivity.this, t.getToken()+"", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onLoginError(String message) {
//
//            }
//        }).callLogin(post);
    }
}
