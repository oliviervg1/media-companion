package com.pi.media;

import java.io.IOException;

public class MediaPlayer {
	
	private JMPlayer player;
	
	public MediaPlayer() {
		player = new JMPlayer();
	}
	
	public void playTrack(String fileToPlay) {
		if (player.isPlaying()) {
			player.close();
		}
		
		try {
			player.open(fileToPlay);
			player.setFullScreen(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		try {
//			Runtime.getRuntime().exec("/Users/olivier/Downloads/MPlayer-1.1/mplayer");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		MediaPlayer mediaPlayer = new MediaPlayer();
		mediaPlayer.playTrack("http://www.stuart-holland.com:8080/uploads/American.Dad.S08E16.HDTV.x264-LOL.mp4");
		
	}
}
