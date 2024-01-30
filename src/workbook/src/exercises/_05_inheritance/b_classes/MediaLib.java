package exercises._05_inheritance.b_classes;

import java.util.ArrayList;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class MediaLib {
	private final ArrayList<Audio> audios = new ArrayList<Audio>();
	private final ArrayList<Video> videos = new ArrayList<Video>();
	
	public void add(Audio audio) {
		audios.add(audio);
	}

	public void add(Video video) {
		videos.add(video);
	}
	
	public String getDurationString() {		
		// Sum up seconds for all audio titles and videos 
		int secondsOverall = 0;
		
		for (Audio audio : audios) {
			Duration duration = audio.getDuration();
			secondsOverall += 60 * duration.getMinutes() + duration.getSeconds();
		}
		
		for (Video video : videos) {
			Duration duration = video.getDuration();
			secondsOverall += 60 * duration.getMinutes() + duration.getSeconds();
		}
		
		// Create and return string of overall duration
		int hours = secondsOverall / 3600;
		int minutes = (secondsOverall % 3600) / 60;
		int seconds = secondsOverall % 60;
		
		return String.format("%d:%02d:%02d", hours, minutes, seconds);
	}

	public void print() {
		// Print all audios in library to console
		for (Audio audio : audios)
			System.out.println(audio);
		
		// Print all videos in library to console
		for (Video video : videos)
			System.out.println(video);
	}
}
