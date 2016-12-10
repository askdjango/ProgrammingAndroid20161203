package kr.festi.programmingandroid20161203;


import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.sdsmdg.tastytoast.TastyToast;


public class MyFirebaseMessagingService extends FirebaseMessagingService {

    final static String TAG = MyFirebaseMessagingService.class.getName();

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "onMessageReceived : " + remoteMessage.getData());

        if ( remoteMessage.getData().size() > 0 ) {
            String messageBody = remoteMessage.getData().get("message_body");
            if ( messageBody != null ) {
                String messageType = remoteMessage.getData().get("message_type_string");
                toast(messageBody, messageType);
            }
        }

        if ( remoteMessage.getNotification() != null ) {
            String messageBody = remoteMessage.getNotification().getBody();  // 메세지의 내용
            toast(messageBody, "default");
        }
    }

    void toast(final String message, final String messageType) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                int messageTypeInt = TastyToast.DEFAULT;

                if ( messageType == null ) {
                    messageTypeInt = TastyToast.DEFAULT;
                }
                else if ( messageType.equals("confusing") ) {
                    messageTypeInt = TastyToast.CONFUSING;
                }
                else if ( messageType.equals("error") ) {
                    messageTypeInt = TastyToast.ERROR;
                }
                else if ( messageType.equals("info") ) {
                    messageTypeInt = TastyToast.INFO;
                }
                else if ( messageType.equals("success") ) {
                    messageTypeInt = TastyToast.SUCCESS;
                }
                else if ( messageType.equals("warning") ) {
                    messageTypeInt = TastyToast.WARNING;
                }

                TastyToast.makeText(getApplicationContext(), message, TastyToast.LENGTH_LONG,
                        messageTypeInt);
            }
        });
    }
}

