package lab3;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import textproc.GeneralWordCounter;
import textproc.WordAlphabeticlyComparator;
import textproc.WordCountComparator;

public class BookReaderController extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		/*
		 * V 7 5 4 2 1
		 */
		
		
		/*
		 * Initiate screen
		 */

		BorderPane root = new BorderPane();
		HBox box = new HBox();
		
		/*
		 * buttons
		 */
		Button buttona = new Button("Alphabetical");
		Button buttonf = new Button("Frequency");
		Button bfind = new Button("Find");
		TextField text = new TextField();
		text.autosize();

		box.getChildren().addAll(buttona, buttonf, text, bfind);
		Scene scene = new Scene(root, 800, 500);
		/*
		 * give the undantagsord text In Counter
		 */
		Set<String> exceptionWords = new HashSet<>();
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		while (scan.hasNext()) {
			exceptionWords.add(scan.next().toLowerCase());
		}
		scan.close();
		GeneralWordCounter counter = new GeneralWordCounter(exceptionWords);


		/*
		 * initialaze Filechooser V7
		 */
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Open Resource File");
		// save only .txt file
		chooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt")); 
	    File selectedFile = chooser.showOpenDialog(primaryStage);
	    Scanner s = null; 
	    try {
	    	s = new Scanner(selectedFile.toPath()) ;
	        	
	        } catch(NullPointerException e) {
	   
	        	}

		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\*|\\-|\\.|:|;|!|\\?|'|\\\")+");
		while (s.hasNext()) {
			counter.process(s.next().toLowerCase());
		}
		s.close();
		
		ObservableList<Entry<String, Integer>> words = FXCollections.observableArrayList(counter.getWords());
		ListView<Entry<String, Integer>> listView = new ListView<>(words);

		/*
		 * button Alphabetical on action
		 */
		buttona.setOnAction(actionEvent -> words.sort(new WordAlphabeticlyComparator()));
		/*
		 * button Frequency on action
		 */
		buttonf.setOnAction(actionEvent -> words.sort(new WordCountComparator()));
		/*
		 * button Find on text on action
		 */
		bfind.setOnAction(actionEvent -> {
			String word = text.getCharacters().toString().toLowerCase();
			Iterator<Entry<String, Integer>> it = words.iterator();
			int index = -1;
			int a = 0;
			while (it.hasNext()) {
				if (it.next().getKey().toString().compareTo(word) == 0)
					index = a;
				a++;
			}
			/*
			 * move the marked line beteween line 1-7
			 */
			if (index > -1) {
				int av = 0 ;
				for (int i = 0; i<7; i++) {
					if (index-av > 0) 
						av++;
				}
				/*
				 * scroll and mark
				 */
				listView.scrollTo(index-av);
				listView.getSelectionModel().clearAndSelect(index);
			}
			/*
			 * Error Alert V5
			 */
			else {
				Alert al = new Alert(AlertType.INFORMATION);
				al.setContentText("The word does not exist ");
				al.setHeaderText("ERROR");
				al.show();
				
			}
			
			text.clear();
		});

		/*
		 * Action with enter key "V1"
		 */
		root.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
			if (ev.getCode() == KeyCode.ENTER)
				bfind.fire();
		});

		/*
		 * setHgrow Text high priority "V2"
		 */
		HBox.setHgrow(text, Priority.ALWAYS);

		root.setCenter(listView);
		root.setBottom(box);
		primaryStage.setTitle("BookReader");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
