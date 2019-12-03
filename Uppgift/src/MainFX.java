
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.function.UnaryOperator;

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
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
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

import javafx.stage.Stage;

public class MainFX extends Application {

	@Override
	public void start(Stage primaryStage ) throws Exception {
		String color = "orange";
		int[][] matrix = new int[9][9];

		
//
//		for (int y = 0; y < 9; y++) {
//			for (int x = 0; x < 9; x++) {
//
//				matrix[x][y] = 0;
//
//			}
//		}
		
		

		/*
		 * Initiate screen
		 */
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(5, 5, 5, 5));
		grid.setVgap(1);
		grid.setHgap(1);

		TextField[][] textMatrix = new TextField[9][9];
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
			
				TextField t = new TextField();
				t.setEditable(true);
				t.setPrefSize(100, 100);
				
				
							
				
			
				if (matrix[y][x]!=0) {
				t.setText(String.valueOf(matrix[y][x]));
				}
				final int a=y;
				final int b=x;
				t.setOnKeyReleased(Event->{
					String s= t.getText();
					int nbr;
					
						try {
							 nbr=Integer.parseInt(s);
							 if(nbr<1 || nbr>9) {
							
								 t.clear();
								 nbr=0;
							 }
						}catch (NumberFormatException nfe) {
							 t.clear();
							nbr = 0;
						}
					
					 System.out.println(nbr);
					
						matrix[a][b]=nbr;
						System.out.println("allo");
					
				});
				if (y / 3 == 0 && x / 3 != 1 || y / 3 == 2 && x / 3 != 1 || y / 3 == 1 && x / 3 == 1)
					t.setStyle("-fx-control-inner-background: " + color + ";");
				
				textMatrix[y][x] = t;
				GridPane.setConstraints(textMatrix[y][x], y, x);
				grid.getChildren().add(textMatrix[y][x]);

			}
		}
		
		
		
		
		
		
		VBox box = new VBox();

		BorderPane root = new BorderPane();

		Button solve = new Button("Solution");
		solve.setOnAction(Event->{
			
			soduku_class sol= new soduku_class(matrix);
			int [][] mat=sol.SolvedMatrix();
			for (int y = 0; y < 9; y++) {
				for (int x = 0; x < 9; x++) {
					TextField t = new TextField();
					t.setPrefSize(100, 100);
					if (y / 3 == 0 && x / 3 != 1 || y / 3 == 2 && x / 3 != 1 || y / 3 == 1 && x / 3 == 1)
						t.setStyle("-fx-control-inner-background: " + color + ";");
					
					t.setText(String.valueOf(mat[y][x]));
					GridPane.setConstraints(t, y, x);
					grid.getChildren().add(t);
				}}
			
		});
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
