package com.example.sounds;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
implements SoundPool.OnLoadCompleteListener {
    private SoundPool mSoundPool;
    private int mClapSound, mVoiceSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSoundPool = new SoundPool(2, AudioManager.STREAM_MUSIC,0);
        mSoundPool.setOnLoadCompleteListener(this);

        mVoiceSound = mSoundPool.load(this, R.raw.motor,10);
        mClapSound = mSoundPool.load(this,R.raw.hlop,1);
    }

    public void onClick(View view)
    {
        mSoundPool.play(mClapSound,1,1,1,1,1);
        mSoundPool.play(mVoiceSound,1,1,10,0, 2);
    }
    public void onClick1(View view)
    {
        mSoundPool.stop(mVoiceSound);
        mSoundPool.stop(mClapSound);
    }
    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {

    }
}