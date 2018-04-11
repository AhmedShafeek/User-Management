package user.ash.usermanagement.MVP.Presenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import user.ash.usermanagement.MVP.View.LoginView;
import user.ash.usermanagement.MVP.Model.User;

/**
 * Created by shafeek on 5/11/17.
 */

public class LoginPresenter extends BasePresenter {

    private LoginView mView;

    public LoginPresenter(LoginView view) {
        mView = view;
    }

    //    implements Observer<LoginResponse>
    public void callLogin(User user) {
        Observer<User> mCategoryObserver = new Observer<User>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onError(Throwable e) {
                mView.onLoginError(e.getMessage());
            }

            @Override
            public void onComplete() {

            }


            @Override
            public void onNext(User t) {
                mView.OnCall(t);
            }
        };


        if (getRetrofit() != null)

        {
            subscribe(getRetrofit().callLogin(user), mCategoryObserver);
        }
    }
}
