
import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

public class MainWindow extends Application{

    public static final int WIDTH  = 1400;
    public static final int HEIGHT = 800;

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Box box = new Box(100, 20, 50);
        
        SmartGroup defaultGroup = new SmartGroup();
        defaultGroup.getChildren().add(box);
        
        Camera camera = new PerspectiveCamera();
        Scene scene = new Scene(defaultGroup, WIDTH, HEIGHT);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);
        
        defaultGroup.translateXProperty().set(WIDTH/2);
        defaultGroup.translateYProperty().set(HEIGHT/2);
        defaultGroup.translateZProperty().set(-1200);

        scene.addEventHandler(ScrollEvent.SCROLL, event -> {
            camera.setTranslateZ(camera.getTranslateZ() + event.getDeltaY());
        });
        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch(event.getCode()) {
                // case W:
                //     box.translateZProperty().set(box.getTranslateZ() + 100);
                //     break;
                // case S:
                //     box.translateZProperty().set(box.getTranslateZ() - 100);
                //     break;
                case Q:
                    defaultGroup.rotateByX(10);
                    break;
                case E:
                    defaultGroup.rotateByX(-10);
            }
        });
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Origami maker");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    class SmartGroup extends Group {
        Rotate r;
        Transform t = new Rotate();

        void rotateByX(int ang) {
            r = new Rotate(ang, Rotate.X_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }

        void rotateByY(int ang) {
            r = new Rotate(ang, Rotate.Y_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }
    }
}
