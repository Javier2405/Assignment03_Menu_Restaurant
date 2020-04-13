package com.example.assignment03_menu_restaurant;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service {


    MediaPlayer myplayer;

    @Override
    public void onCreate() {
        myplayer = MediaPlayer.create(this, R.raw.bcm);
        myplayer.setLooping(true);
        myplayer.setVolume(80,80);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        myplayer.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {

        myplayer.stop();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

