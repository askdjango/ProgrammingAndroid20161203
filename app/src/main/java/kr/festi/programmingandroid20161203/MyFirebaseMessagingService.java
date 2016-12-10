package kr.festi.programmingandroid20161203;


import android.os.Handler;
import android.os.Looper;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.sdsmdg.tastytoast.TastyToast;


public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if ( remoteMessage.getData().size() > 0 ) {
            String messageBody = remoteMessage.getData().get("message_body");
            if ( messageBody != null ) {
                toast(messageBody);
            }
        }

        if ( remoteMessage.getNotification() != null ) {
            String messageBody = remoteMessage.getNotification().getBody();  // 메세지의 내용
            toast(messageBody);
        }
    }

    void toast(final String message) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                TastyToast.makeText(getApplicationContext(), message, TastyToast.LENGTH_LONG, TastyToast.INFO);
            }
        });
    }
}

