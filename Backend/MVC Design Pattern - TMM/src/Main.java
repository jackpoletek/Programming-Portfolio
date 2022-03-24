import NumbersController.NumbersController;
import NumbersModel.NumbersModel;
import NumbersView.NumbersView;

public class Main {

    public static void main(String[] args) {

        NumbersModel model = new NumbersModel();
        NumbersView view = new NumbersView();
        NumbersController controller = new NumbersController(view, model);
        view.setVisible(true);

    }
}
