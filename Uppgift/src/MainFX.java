
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class MainFX extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		int[][] matrix = new int[9][9];
		int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int i = 0;
		int vol = 1;
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				
				matrix[x][y] = num[i];
				i = (i + 1) % 9;
			}
			i = vol;
			vol++;
		}
		
		
		
		
		/*
		 * Initiate screen
		 */
		GridPane grid =new GridPane();
		grid.setPadding(new Insets(5,5,5,5));
		grid.setVgap(1);
		grid.setHgap(1);
		
		TextField[][] textMatrix = new TextField[9][9] ;
		
	
		
//		for (int y = 0; y < 9; y++) {
//			for (int x = 0; x < 9; x++) {
//				textMatrix[x][y].setText("5");
//				//setText(String.valueOf(matrix[x][y]));
//				textMatrix[x][y].setEditable(true);
//				textMatrix[x][y].setPrefSize(90, 90);
//			}
//		}
//			
		if(true)
			;
		

		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				TextField  t = new TextField ();
				t.setEditable(true);
				t.setPrefSize(90, 90);
				t.appendText(  String.valueOf(matrix[x][y])  );
        	  GridPane.setConstraints(t,x,y);
        	  grid.getChildren().add(t);
			}
		}
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				
        	  GridPane.setConstraints(textMatrix[x][y],x,y);
        	  grid.getChildren().add(textMatrix[x][y]);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		VBox box = new VBox();

		
		
		BorderPane root = new BorderPane();

		Button solve = new Button("Solution");
		box.getChildren().add(solve);
		root.setRight(box);
		root.setCenter(grid);
		Scene scene = new Scene(root, 500, 500);
		primaryStage.setTitle("Sudoku");

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
