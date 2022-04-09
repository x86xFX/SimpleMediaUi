package module;

import com.jfoenix.controls.JFXSlider;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ImageView close, music, video, setting, image, drag, songFolder, imagesFolder, videoFolder, pausePlayIcon, resetIcon;
    @FXML
    private AnchorPane musicPane, settingPane, videoPane, photoPane;
    @FXML
    private Label songPathLabel, imagesPathLabel, videoPathLabel;
    @FXML
    private MediaView videoPreviewViewer;
    @FXML
    private JFXSlider volumeSlider;
    @FXML
    private HBox hBox;

    private double xOffset = 0, yOffset = 0;
    private Stage stage;
    private MediaPlayer mediaPlayer;

    //Get Main Stage
    public void setStage(Stage stage){
        this.stage = stage;
    }

    //Hide all panel in startup
    public void hideAllPane(){
        musicPane.setVisible(false);
        settingPane.setVisible(false);
        videoPane.setVisible(false);
        photoPane.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            //change volume controller color
            volumeSlider.valueProperty().addListener(e -> {
                System.out.println(String.valueOf(volumeSlider.getValue()));
            });

            //Video pause play event
            pausePlayIcon.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    PlayPauseMedia();
                }
            });

            resetIcon.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    resetMedia();
                }
            });

            //Hide all pane
            hideAllPane();

            //Get Drag X/Y Location
            drag.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });

            //Set Drag X/Y to main Stage
            drag.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                }
            });

            //Close Button system exit
            close.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    Platform.exit();
                    System.exit(0);
                }
            });

            //Close Button Hover Enter
            close.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ColorAdjust hoverColor = new ColorAdjust();
                    hoverColor.setBrightness(2);
                    close.setEffect(hoverColor);
                }
            });

            //Close Button Hover Exit
            close.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ColorAdjust hoverColor = new ColorAdjust();
                    hoverColor.setBrightness(0);
                    close.setEffect(hoverColor);
                }
            });

            //Music Button Hover Enter
            music.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ColorAdjust hoverColor = new ColorAdjust();
                    hoverColor.setHue(2);
                    music.setEffect(hoverColor);
                }
            });

            //Music Button Hover Exit
            music.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ColorAdjust hoverColor = new ColorAdjust();
                    hoverColor.setHue(0);
                    music.setEffect(hoverColor);
                }
            });

            //Video Button Hover Enter
            video.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ColorAdjust hoverColor = new ColorAdjust();
                    hoverColor.setHue(2);
                    video.setEffect(hoverColor);
                }
            });

            //Video Button Hover Exit
            video.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ColorAdjust hoverColor = new ColorAdjust();
                    hoverColor.setHue(0);
                    video.setEffect(hoverColor);
                }
            });

            //Image Button Hover Enter
            image.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ColorAdjust hoverColor = new ColorAdjust();
                    hoverColor.setHue(2);
                    image.setEffect(hoverColor);
                }
            });

            //Image Button Hover Exit
            image.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ColorAdjust hoverColor = new ColorAdjust();
                    hoverColor.setHue(0);
                    image.setEffect(hoverColor);
                }
            });

            //Setting Button Enter
            setting.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ColorAdjust hoverColor = new ColorAdjust();
                    hoverColor.setHue(2);
                    setting.setEffect(hoverColor);
                }
            });

            //Setting Button Exit
            setting.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ColorAdjust hoverColor = new ColorAdjust();
                    hoverColor.setHue(0);
                    setting.setEffect(hoverColor);
                }
            });

            //Music Click
            music.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    musicPane.setVisible(true);
                    settingPane.setVisible(false);
                    videoPane.setVisible(false);
                    photoPane.setVisible(false);
                }
            });

            //Setting Click
            setting.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    musicPane.setVisible(false);
                    settingPane.setVisible(true);
                    videoPane.setVisible(false);
                    photoPane.setVisible(false);
                }
            });

            //Video Click
            video.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    musicPane.setVisible(false);
                    settingPane.setVisible(false);
                    videoPane.setVisible(true);
                    photoPane.setVisible(false);
                }
            });

            //Image Click
            image.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    musicPane.setVisible(false);
                    settingPane.setVisible(false);
                    videoPane.setVisible(false);
                    photoPane.setVisible(true);
                }
            });

            //Open Music Folder
            songFolder.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    songPathLabel.setText(openExplorer());
                }
            });

            //Open Images Folder
            imagesFolder.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    imagesPathLabel.setText(openExplorer());
                }
            });

            //Open Video Folder and create File objects
            videoFolder.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    videoPathLabel.setText(openExplorer());
                }
            });

            //Video File
            File videoFile = new File("video.mp4"); //Add your own path
            Media media = new Media(String.valueOf(videoFile.toURI()));

            mediaPlayer = new MediaPlayer(media);
            videoPreviewViewer.setMediaPlayer(mediaPlayer);

            //Audio Spectrum
            final int bands = mediaPlayer.getAudioSpectrumNumBands();
            final Rectangle[] rectangle = new Rectangle[bands];
            for (int i=0; i< rectangle.length;i++){
                rectangle[i] = new Rectangle();
                rectangle[i].setFill(Color.rgb(17, 91, 238));
                hBox.getChildren().add(rectangle[i]);
            }

            mediaPlayer.setOnReady(new Runnable() {
                @Override
                public void run() {
                    hBox.setMinWidth(20);
                    for (Rectangle r:rectangle){
                        r.setWidth(2);
                        r.setHeight(3);
                    }
                }
            });

            mediaPlayer.setAudioSpectrumListener(new AudioSpectrumListener() {
                @Override
                public void spectrumDataUpdate(double timestamp, double duration, float[] magnitudes, float[] phases) {
                    for(int i=0; i < 66; i++){
                        double h = magnitudes[i] + 60 ;
                        if(h>2){
                            rectangle[i].setHeight(h);
                        }
                    }
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String openExplorer(){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(stage);
        if(selectedDirectory == null){
            return "Directory is Empty";
        }else{
            return selectedDirectory.getAbsolutePath();
        }
    }

    //play & pause video
    public void PlayPauseMedia(){
        MediaPlayer.Status currentStatus = mediaPlayer.getStatus();
        System.out.println(currentStatus);

        if(currentStatus == MediaPlayer.Status.READY){
            mediaPlayer.play();
            pausePlayIcon.setImage(new Image("/resources/img/pause-circle.png"));

        }else if(currentStatus == MediaPlayer.Status.PLAYING){
            mediaPlayer.pause();
            pausePlayIcon.setImage(new Image("/resources/img/play-circle.png"));

        }else if(currentStatus == MediaPlayer.Status.PAUSED){
            mediaPlayer.play();
            pausePlayIcon.setImage(new Image("/resources/img/pause-circle.png"));
        }
    }

    //Reset Video
    public void resetMedia(){
        if(mediaPlayer.getStatus() != MediaPlayer.Status.READY){
            mediaPlayer.seek(Duration.seconds(0.0));
        }
    }
}