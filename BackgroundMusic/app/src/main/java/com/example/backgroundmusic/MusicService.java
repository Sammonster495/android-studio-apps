package com.example.backgroundmusic;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;
    private final IBinder binder = new LocalBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.chipi);
        mediaPlayer.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground(1, createNotification());
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class LocalBinder extends Binder{
        MusicService getService(){
            return MusicService.this;
        }
    }

    public void startMusic(){
        if(!isMusicPlaying())
            mediaPlayer.start();
    }

    public void pauseMusic(){
        if(isMusicPlaying())
            mediaPlayer.pause();
    }

    public Boolean isMusicPlaying(){
        return mediaPlayer.isPlaying();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    private Notification createNotification() {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        return new NotificationCompat.Builder(this, "channel_id")
                .setContentTitle("Your Music App")
                .setContentText("Music is playing in the background")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .build();
    }
}
