import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class MainCamera {
    private Camera cam = new PerspectiveCamera();

    private Translate pivot = new Translate();
    private Rotate rotation = new Rotate();

    public MainCamera() {
        cam.getTransforms().addAll(
            pivot,
            rotation
        );
        cam.translateXProperty().set(-100);
        cam.translateYProperty().set(100);
        cam.translateZProperty().set(-600);
    }

    public Camera getCamera() {
        return cam;
    }

    public void setPivot(Point3D point) {
        pivot.setX(point.getX());
        pivot.setY(point.getY());
        pivot.setZ(point.getZ());
    }

    public void rotate(double x, double y, double z) {
        rotation = new Rotate(x, Rotate.X_AXIS);
        rotation = new Rotate(y, Rotate.Y_AXIS);
        rotation = new Rotate(z, Rotate.Z_AXIS);
    }
}
