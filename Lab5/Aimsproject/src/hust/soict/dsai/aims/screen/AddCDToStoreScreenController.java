package hust.soict.dsai.aims.screen;

import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class AddCDToStoreScreenController extends AddMediaToStoreScreenController {
	private CompactDisc cd;
	private String artist;
	private String director;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	@FXML
	private TextField tfArtist;

	@FXML
	private TextField tfDirector;

	@FXML
	private TextField tfTracks;

	public AddCDToStoreScreenController(Store store, Cart cart, JFrame stage) {
		super(store, cart, stage);
	}

	public void initialize() {

		tfArtist.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observerble, String oldValue, String newValue) {
				setArtist(newValue);
			}
		});

		tfDirector.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observerble, String oldValue, String newValue) {
				director = newValue;
			}
		});

		super.initialize();
	}

	@FXML
	private void addTrackBtnPressed() {
		// Create the custom dialog.
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Input Dialog");
		dialog.setHeaderText("You can add new track here");

		// Set the button types.
		dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

		// Create the title and length labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField trackTitle = new TextField();
		trackTitle.setPromptText("Enter track name here");
		TextField trackLength = new TextField();
		trackLength.setPromptText("Enter track length (integer) here");

		grid.add(new Label("Title:"), 0, 0);
		grid.add(trackTitle, 1, 0);
		grid.add(new Label("Length:"), 0, 1);
		grid.add(trackLength, 1, 1);

		dialog.getDialogPane().setContent(grid);

		// Convert the result to a name-length-pair when the login button is clicked.
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == ButtonType.OK) {
				return new Pair<>(trackTitle.getText(), trackLength.getText());
			}
			return null;
		});

		Optional<Pair<String, String>> result = dialog.showAndWait();

		if (result.isPresent()) {
			String title = result.get().getKey();
			String lengthStr = result.get().getValue();
			int length = 0;
			try {
				length = Integer.parseInt(lengthStr);
			} catch (NumberFormatException e) {
			} finally {
				tracks.add(new Track(length, title));
				if (tfTracks.getText().length() == 0) {
					tfTracks.setText(title + ": " + length);
				} else {
					tfTracks.setText(tfTracks.getText() + ", " + title + ": " + length);
				}
			}
		}
	}

	@FXML
	@Override
	protected void addBtnPressed() throws Exception {
		cd = new CompactDisc(1, this.title, this.category, this.director, this.cost);
		for (Track track : tracks) {
			cd.addTrack(track);
		}
		store.addMedia(cd);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Notification");
		alert.setHeaderText("Success");
		alert.setContentText(cd.getTitle() + " has been added to the store");
		alert.showAndWait();
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
}