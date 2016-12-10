package kr.festi.programmingandroid20161203;


import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if ( remoteMessage.getNotification() != null ) {
            String messageBody = remoteMessage.getNotification().getBody();  // 메세지의 내용

            Toast.makeText(getApplicationContext(), messageBody, Toast.LENGTH_LONG).show();
        }
    }
}

