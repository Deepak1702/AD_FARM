package com.example.deepak.ad_farm;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
public class LogIn_Activity extends Activity implements View.OnClickListener{
    Button login, register;
    EditText etphone, etPass;
    public PackageInstaller.Session session;
    private CallbackManager callbackManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        callbackManager=CallbackManager.Factory.create();
        setContentView(R.layout.activity_log_in_);

     //   db = new DbHelper(this);

        login = (Button) findViewById(R.id.btnLogin);
        register = (Button) findViewById(R.id.btnregister);
        etphone = (EditText) findViewById(R.id.etphone);
        etPass = (EditText) findViewById(R.id.etPass);
        LoginButton loginButton = (LoginButton) findViewById(R.id.facebook);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
//                AccessToken accessToken = loginResult.getAccessToken();
//                Profile profile = Profile.getCurrentProfile();
//                GraphRequest graphrequest = GraphRequest.newMeRequest(loginResult.getAccessToken(),
//                        new GraphRequest.GraphJSONObjectCallback() {
//                            @Override
//                            public void onCompleted(JSONObject object, GraphResponse response) {
//                                JSONObject jsonObject = response.getJSONObject();
//                                if (jsonObject != null) {
//                                    try {
//                                        String email1 = jsonObject.getString("email");
//                                    } catch (JSONException e) {
//                                        e.printStackTrace();
//
//                                    }
//                                }
//                            }
//                        });
//                handleSignInResult(new Callable<Void>() {
//                    @Override
//                    public Void call() throws Exception {
//                        LoginManager.getInstance().logOut();
//                        return null;
//                    }
//                });
            }

            @Override
            public void onCancel() {
                handleSignInResult(null);

            }

            @Override
            public void onError(FacebookException error) {
                Log.d(LogIn_Activity.class.getCanonicalName(), error.getMessage());
                handleSignInResult(null);

            }
        });

        login.setOnClickListener(this);
        register.setOnClickListener(this);


    }

    private void handleSignInResult(Object o) {
        Intent i = new Intent(this, UserSelectionActivity.class);
        startActivity(i);
        finish();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                startActivity(new Intent(LogIn_Activity.this, UserSelectionActivity.class));
                break;
            case R.id.btnregister:
                startActivity(new Intent(LogIn_Activity.this, Register.class));
                break;
            default:

        }
    }

    private void login() {
        String phone = etphone.getText().toString();
        String pass = etPass.getText().toString();




       /*if (db.getUser(email, pass)) {
        session.setLoggedin(true);
        startActivity(new Intent(LogIn.this, UserSelectionActivity.class));
        finish();
        } else {
        Toast.makeText(getApplicationContext(), "Wrong Phone Number/password", Toast.LENGTH_SHORT).show();
        }*/
    }
}

