package NumbersController;

import NumbersModel.NumbersModel;
import NumbersView.NumbersView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumbersController {

    // CONTROLLER coordinates interactions between the VIEW and the MODEL
    private NumbersView view;
    private NumbersModel model;

    public NumbersController(NumbersView view, NumbersModel model) {
        this.view = view;
        this.model = model;
        this.view.addNumberListener(new NumberListener());

        // We ought to tell the VIEW that whenever the appropriate button is clicked to call the methods

        // this.view -> refers NOT to "this.view = view" BUT to "private NumbersView view"
    }

    class NumberListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int firstUserNum, secondUserNum;

            try {
                firstUserNum = view.getFirstNumber();
                secondUserNum = view.getSecondNumber();
                model.getUserInput(firstUserNum, secondUserNum);
                model.listToIntArr();
                model.intArrayToInt();
                model.splitInt();
                model.generateCompNums();
                model.compArrToIntArray();
                model.intArrToCompNum();
                view.setFirstComputerNumber(model.getCompNum1());
                view.setSecondComputerNumber(model.getCompNum2());

                if ((firstUserNum < 100 && firstUserNum > 899) || (secondUserNum < 100 && secondUserNum > 899)) {
                    System.out.println("The numbers must be between 899 and 100.");
                }

            } catch(NumberFormatException exception) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }
}
