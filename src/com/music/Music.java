package com.music;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;


public class Music {
	public static Mixer mixer;
	public static Clip clip;
	public static Clip clip2;
	
	public void play(String m, int c) {
		Mixer.Info[] mixinfos = AudioSystem.getMixerInfo();

		mixer = AudioSystem.getMixer(mixinfos[0]);
		DataLine.Info datainfo = new DataLine.Info(Clip.class, null);
		try{clip=(Clip)mixer.getLine(datainfo);}
		catch(LineUnavailableException lue) { lue.printStackTrace(); }
		
		try{
			URL soundURL = Music.class.getResource(m);
//			System.out.println(soundURL);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
			clip.open(audioStream);
		}
		catch(LineUnavailableException lue) {lue.printStackTrace(); }
		catch(UnsupportedAudioFileException uafe) {uafe.printStackTrace();}
		catch(IOException ioe) {ioe.printStackTrace();}
		clip.start();
		clip.loop(c);

	}
	public void sound(String m, int c) {
		Mixer.Info[] mixinfos = AudioSystem.getMixerInfo();

		mixer = AudioSystem.getMixer(mixinfos[0]);
		DataLine.Info datainfo = new DataLine.Info(Clip.class, null);
		try{clip2=(Clip)mixer.getLine(datainfo);}
		catch(LineUnavailableException lue) { lue.printStackTrace(); }
		
		try{
			URL soundURL = Music.class.getResource(m);
//			System.out.println(soundURL);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
			clip2.open(audioStream);
		}
		catch(LineUnavailableException lue) {lue.printStackTrace(); }
		catch(UnsupportedAudioFileException uafe) {uafe.printStackTrace();}
		catch(IOException ioe) {ioe.printStackTrace();}
		clip2.start();
		clip2.loop(c);

	}
	public void stopSound(){
		clip2.stop();
	}
	public void stop(){
		clip.stop();
	}
}