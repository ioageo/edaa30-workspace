import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

public class MainFX extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		String color = "orange";
		int[][] matrix = new int[9][9];

		/*
		 * Initiate screen
		 */
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(5, 5, 5, 5));
		grid.setVgap(1);
		grid.setHgap(1);
		
		/*
		 * initial screen 
		 */
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {

				TextField t = new TextField();
				t.setEditable(true);
				t.setPrefSize(100, 100);

				if (matrix[y][x] != 0) {
					t.setText(String.valueOf(matrix[y][x]));
				}
				final int a = y;
				final int b = x;
				t.setOnKeyReleased(Event -> {
					String s = t.getText();
					int nbr;
					try {
						nbr = Integer.parseInt(s);
						ExtraMethod em = new ExtraMethod();
						if (nbr < 1 || nbr > 9 || !em.colrow(matrix, nbr, b, a) ) {
							Alert al = new Alert(AlertType.INFORMATION);
							al.setContentText("You wrote wrong number ");
							al.setHeaderText("ERROR");
							al.show();
							t.clear();
							nbr = 0;
						}
					} catch (NumberFormatException nfe) {
						Alert al = new Alert(AlertType.INFORMATION);
						al.setContentText("I want only digits ");
						al.setHeaderText("ERROR");
						al.show();
						t.clear();
						nbr = 0;
					}
					if(nbr!=0)
					matrix[a][b] = nbr;

				});
				if (y / 3 == 0 && x / 3 != 1 || y / 3 == 2 && x / 3 != 1 || y / 3 == 1 && x / 3 == 1)
					t.setStyle("-fx-control-inner-background: " + color + ";");				
				GridPane.setConstraints(t, y, x);
				grid.getChildren().add(t);

			}
		}

		

		BorderPane root = new BorderPane();

		Button solve = new Button("Solution");
		solve.setMaxWidth(Double.MAX_VALUE);
		solve.setMinWidth(75);
		Button clear = new Button("Clear");
		clear.setMaxWidth(Double.MAX_VALUE);
		clear.setMinWidth(75);
		
		solve.setOnAction(Event -> {
			soduku_class sol = new soduku_class(matrix);
			int[][] mat = sol.SolvedMatrix();		
			if(mat!=null) {
			grid.getChildren().clear();
			grid.setPadding(new Insets(5, 5, 5, 5));
			grid.setVgap(1);
			grid.setHgap(1);
			for (int y = 0; y < 9; y++) {
				for (int x = 0; x < 9; x++) {
					TextField t = new TextField();
					t.setPrefSize(100, 100);
					if (y / 3 == 0 && x / 3 != 1 || y / 3 == 2 && x / 3 != 1 || y / 3 == 1 && x / 3 == 1)
						t.setStyle("-fx-control-inner-background: " + color + ";");
					t.setText(String.valueOf(mat[y][x]));
					GridPane.setConstraints(t, y, x);
					grid.getChildren().add(t);
					}
				}
			}else {
				Alert al = new Alert(AlertType.INFORMATION);
				al.setContentText("This Soduku has no solution ");
				al.setHeaderText("ERROR");
				al.show();
				
			}
		});
		
		
		clear.setOnAction(Event->{			
					grid.getChildren().clear();
					grid.setPadding(new Insets(5, 5, 5, 5));
					grid.setVgap(1);
					grid.setHgap(1);
					
					for (int y = 0; y < 9; y++) {
						for (int x = 0; x < 9; x++) {
							
							TextField t = new TextField();
							t.setEditable(true);
							t.setPrefSize(100, 100);
							matrix[y][x]=0;
							final int a = y;
							final int b = x;
							t.setOnKeyReleased(e -> {
								String s = t.getText();
								int nbr;
								try {
									nbr = Integer.parseInt(s);
									if (nbr < 1 || nbr > 9) {
										t.clear();
										nbr = 0;
									}
								} catch (NumberFormatException nfe) {
									t.clear();
									nbr = 0;
								}
								if(nbr!=0)
								matrix[a][b] = nbr;

							});
							if (y / 3 == 0 && x / 3 != 1 || y / 3 == 2 && x / 3 != 1 || y / 3 == 1 && x / 3 == 1)
								t.setStyle("-fx-control-inner-background: " + color + ";");

							
							GridPane.setConstraints(t, y, x);
							grid.getChildren().add(t);

						}
					}
				
			
		});
		VBox vbox = new VBox();
		vbox.getChildren().addAll(clear,solve);
		root.setRight(vbox);
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
