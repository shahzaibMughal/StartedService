package shahzaib.com.startedservice;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("123456","Service Started.....");
        startCountdownTimer(11);
        return START_NOT_STICKY;
    }

    public void startCountdownTimer(final int seconds)
    {
        // funciton parameter receive milliseconds so we should conver seconds into milliseconds
        CountDownTimer countDownTimer = new CountDownTimer(seconds*1000,1000) {
            @Override
            public void onTick(long milliSecondsLeft) {
                Log.i("123456",String.valueOf((milliSecondsLeft/1000)));
            }

            @Override
            public void onFinish() {
                Log.i("123456","Service Stopped....");
                stopSelf(); // stop the service
            }
        };
        countDownTimer.start();
    }


}
