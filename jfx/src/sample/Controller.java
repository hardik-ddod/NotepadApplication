package sample;

        import javafx.application.Platform;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.control.TextArea;
        import javafx.scene.control.TextField;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.HBox;
        import javafx.scene.layout.VBox;
        import javafx.stage.FileChooser;

        import java.io.File;
        import java.io.FileReader;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.nio.channels.ScatteringByteChannel;
        import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class Controller {
    @FXML private TextArea textArea;
    @FXML private VBox vboxContainer;
    @FXML private HBox hbox;
    @FXML private TextField searchBar;
    private Matcher matcher = null;

    public void initialize() {
        vboxContainer.getChildren().remove(hbox);
        clearTextArea();
        textArea.setWrapText(true);
    }

    public void createNew(ActionEvent e) {
        clearTextArea();
    }

    public void clearTextArea() {
        textArea.setText("");
    }

    public void openFile(ActionEvent e) {
        try {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            File openDestination = fc.showOpenDialog(null);
            Scanner scanner = new Scanner(openDestination);
            textArea.setText(scanner.nextLine());
            while(scanner.hasNextLine()) {
                textArea.setText(textArea.getText() + "\n" +scanner.nextLine());
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public void saveFile(ActionEvent e) {
        try {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            File copyDestination = fc.showSaveDialog(null);
            if (copyDestination != null) {
                FileWriter fw = new FileWriter(copyDestination);
                fw.write(textArea.getText());
                fw.close();
            }
        } catch (IOException x) {
            x.printStackTrace();
        }
    }

    public void search() {
        vboxContainer.getChildren().add(1, hbox);
    }

    public void searchTextArea(ActionEvent e) {
        String stringToFind = searchBar.getText();
        //stringToFind = ".*" + stringToFind + ".*";
        String stringToSearch = textArea.getText();
        textArea.selectRange(0, stringToSearch.length());
        Pattern pattern = Pattern.compile(stringToFind);
        matcher = pattern.matcher(stringToSearch);

        if (matcher.find()) {
            textArea.selectRange(matcher.start(), matcher.end());
        }
    }

    public void deleteBar(MouseEvent e) {
        vboxContainer.getChildren().remove(hbox);
    }

    public void closeNotepad(ActionEvent e) {
        Platform.exit();
    }
}
