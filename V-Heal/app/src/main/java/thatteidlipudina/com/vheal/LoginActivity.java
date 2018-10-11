package thatteidlipudina.com.vheal;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.github.nkzawa.socketio.client.Socket;

public class LoginActivity extends AppCompatActivity {
    private Socket socket;
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;

    //
    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;

    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }
    Button mEmailSignInButton;
    private Socket mSocket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        RatKiller app =(RatKiller)getApplication();
        mSocket=app.getmSocket();
        mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);

//        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
//                                                  public void onClick(View view) {
//                                                      Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                                                      startActivity(intent);
//                                                  }
//                                              }
//
//        );
    }
}


