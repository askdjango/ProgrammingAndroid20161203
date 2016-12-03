package kr.festi.programmingandroid20161203;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mFirebaseAuth;
    FirebaseUser mFirebaseUser;

    String mUsername;
    String mPhotoUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        if ( mFirebaseUser == null ) {
            // logout 상황
            Toast.makeText(this, "로그인이 필요합니다", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            // login 상황
            mUsername = mFirebaseUser.getDisplayName();
            Toast.makeText(this, mUsername, Toast.LENGTH_LONG).show();

            if ( mFirebaseUser.getPhotoUrl() != null ) {
                mPhotoUrl = mFirebaseUser.getPhotoUrl().toString();
            }
        }

        TextView usernameTextView = (TextView) findViewById(R.id.name_textview);
        ImageView photoImageView = (ImageView) findViewById(R.id.photo_imageview) ;

        usernameTextView.setText(mUsername);
        if ( mPhotoUrl != null ) {
            Glide.with(this).load(mPhotoUrl).into(photoImageView);
        }

    }
}
