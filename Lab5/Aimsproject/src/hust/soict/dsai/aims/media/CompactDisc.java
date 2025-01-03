package hust.soict.dsai.aims.media;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.exception.*;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public CompactDisc(int id, String title, String category, float cost, String artist, ArrayList<Track> tracks) {
		super(id, title, category, cost);
		this.artist = artist;
		this.tracks = tracks;
	}

	public CompactDisc(int id, String title, String category, String artist, float cost) {
		super(id, title, category, cost);
		this.artist = artist;
	}
	
	public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist) {
		super(id, title, category, cost, director, length);
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}

	public void addTrack(Track track) {
		if (!tracks.contains(track)) {
			tracks.add(track);
			System.out.println("Track" + track + "is added successfully");
		}
		System.out.println("Track" + track + " is already in the track list");
	}

	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Track" + track + "is removed successfully");
		} else {
			System.out.println("Track" + track + "is not in the track list");
		}
	}

	public int getLength() {
		int totalLength = 0;
		for (Track track : tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}

	@Override

	public void play() throws PlayerException {
		if (getLength() <= 0) {
			throw new PlayerException("ERROR: CD length must be positive!");
		} else {
			showPlayDialog();
			playAllTracks();
		}
	}

	private void showPlayDialog() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		JDialog dialog = createDialog();
		int dialogWidth = dialog.getSize().width;
		int dialogHeight = dialog.getSize().height;
		int x = (screenSize.width - dialogWidth) / 2;
		int y = (screenSize.height - dialogHeight) / 2;

		dialog.setLocation(x, y);
		dialog.setVisible(true);
	}

	private JDialog createDialog() {
		JDialog dialog = new JDialog();
		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createVerticalGlue());
		panel.add(createLabel("Now playing: " + getTitle()));
		panel.add(Box.createVerticalGlue());

		dialog.add(panel);
		dialog.setTitle("Media Player");
		dialog.setSize(300, 120);

		return dialog;
	}

	private JLabel createLabel(String text) {
		JLabel label = new JLabel(text);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		return label;
	}

	private void playAllTracks() throws PlayerException {
		for (Track track : this.tracks) {
			track.play();
		}
	}

	public String toString() {
		return "CD: " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getArtist() + " - "
				+ getLength() + "s - $" + getCost();
	}
}