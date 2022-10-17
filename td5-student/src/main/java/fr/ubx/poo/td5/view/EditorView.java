package fr.ubx.poo.td5.view;

import fr.ubx.poo.td5.model.*;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;

public class EditorView extends BorderPane {
    private final Stage stage;
    private Grid grid = new Grid(0,0);
    private final PickerView pickerView;
    private final Clipboard clipboard = Clipboard.getSystemClipboard();
    private final ClipboardContent clipboardContent = new ClipboardContent();




    public EditorView(Stage stage)  {
        this.stage = stage;
        GridRepo gridRepoVar = new GridRepoVar();
        GridRepoString gridRepoString = new GridRepoString();
        GridRepo gridRepoStringRLE = new GridRepoStringRLE();

        // Tile picker
        this.pickerView = new PickerView();
        this.setRight(pickerView);

        // Create menu
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");

        MenuItem loadItemJ = new MenuItem("Load from Java declaration");
        MenuItem exportItemJ = new MenuItem("Export as Java declaration");
        MenuItem loadItemS = new MenuItem("Load from string");
        MenuItem exportItemS = new MenuItem("Export as string");
        MenuItem loadItemSZ = new MenuItem("Load from compressed string");
        MenuItem exportItemSZ = new MenuItem("Export as compressed string");
        MenuItem exitItem = new MenuItem("Exit");
        MenuItem newItem = new MenuItem("New map");
        MenuItem loadItemF = new MenuItem("Load File");
        MenuItem exportItemF = new MenuItem("Save File");

        exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
        fileMenu.getItems().addAll(
                loadItemJ, exportItemJ, new SeparatorMenuItem(),
                loadItemS, exportItemS, new SeparatorMenuItem(),
                loadItemSZ, exportItemSZ, new SeparatorMenuItem(),
                exitItem, new SeparatorMenuItem(),
                newItem, new SeparatorMenuItem(), loadItemF, exportItemF);
        menuBar.getMenus().addAll(fileMenu);
        this.setTop(menuBar);


        // Load from file

        loadItemF.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(stage);
            //fileChooser.showSaveDialog(stage);

            if (file != null) {

                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line = reader.readLine();
                    StringBuilder sb = new StringBuilder();
                    //Files.lines(file.toPath()).forEach(System.out::println);
                    System.out.printf(line);

                    this.grid = gridRepoStringRLE.load(line);
                    updateGrid(grid);



                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

// Export to file
        exportItemF.setOnAction(e -> {
            FileChooser fileChooser =  new FileChooser();
            File file = fileChooser.showSaveDialog(stage);
            if (file != null) {
                // Sauvegarde dans un fichier (avec compression)
            }
        });


        // Load from Java declaration
        loadItemJ.setOnAction(e -> {
            Form form = new Form(stage, "Name field");
            this.grid = gridRepoVar.load(form.getText());
            updateGrid(grid);
        });
        newItem.setOnAction(e -> {
            Form form = new Form(stage, "Size of the map : width x height");
            String[] parts = form.getText().replaceAll("\\s+","").split("x");
            if (parts.length != 2)
                return;
            try {
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                this.grid = ((GridRepoString) gridRepoString).create(x, y);
                updateGrid(grid);
            } catch (NumberFormatException numberFormatException) {
                return;
            }
        });

        // Export as Java declaration
        exportItemJ.setOnAction(e -> {
            exportDialog(gridRepoVar.export(grid));
        });

        // Load from String
        loadItemS.setOnAction(e -> {
            Form form = new Form(stage, "Input string");
            this.grid = gridRepoString.load(form.getText());
            updateGrid(grid);
        });

        // Export as String
        exportItemS.setOnAction(e -> {
            exportDialog(gridRepoString.export(grid));
        });

        // Load from compressed String
        loadItemSZ.setOnAction(e -> {
            Form form = new Form(stage, "Input compressed string");
            this.grid = gridRepoStringRLE.load(form.getText());
            updateGrid(grid);
        });

        // Export as compressed String
        exportItemSZ.setOnAction(e -> {
            exportDialog(gridRepoStringRLE.export(grid));
        });

        // Exit
        exitItem.setOnAction(e -> System.exit(0));
    }

    private void updateGrid(Grid grid) {
        if (grid != null) {
            Pane gridView = new GridView(grid, pickerView);
            this.setCenter(gridView);
            stage.sizeToScene();
        }
    }

    private void exportDialog(String msg) {
        clipboardContent.putString(msg);
        clipboard.setContent(clipboardContent);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Export");
        alert.setHeaderText("Saved to clipboard");
        alert.getDialogPane().setContent(new TextArea(msg));
        alert.setResizable(true);
        alert.showAndWait();
    }

}
