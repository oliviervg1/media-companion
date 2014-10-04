package com.pi.media;

import java.io.IOException;

import javax.jws.WebService;

import automation.api.AbstractDevice;
import automation.api.components.JMPlayer;

@WebService(endpointInterface = "automation.api.interfaces.ConnectedDevice")
public class MediaPlayer extends AbstractDevice {

    private JMPlayer player;
    private float volume;

    @Override
    protected void onStartup() {
        player = new JMPlayer("/Users/olivier/Downloads/MPlayer-1.1/", "-slave -idle", "/var/tmp/youtube-dl-cookies.txt");
        volume = 80;
    }

    public void playTrack(String fileToPlay) {
        if (player.isPlaying()) {
            player.close();
        }
        try {
            player.open(fileToPlay);
            player.setVolume(volume);
            player.setFullScreen(true);
        } catch (IOException e) {}
    }

    public void togglePlay() {
        player.togglePlay();
    }

    public void setVolume(float volume) {
        this.volume = volume;
        player.setVolume(volume);
    }

    public float getVolume() {
        return player.getVolume();
    }

    public void setTimePosition(long seconds) {
        player.setTimePosition(seconds);
    }

    public long getTimePosition() {
        return player.getTimePosition();
    }

    public long getTotalTime() {
        return player.getTotalTime();
    }

    public void close() {
        player.close();
    }

    public String getPlayingFile() {
        return player.getPlayingFile();
    }
}
