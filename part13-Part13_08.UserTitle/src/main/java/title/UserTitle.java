package title;

import javafx.application.Application;
import javafx.stage.Stage;


public class UserTitle extends Application{

    @Override
    public void start(Stage window) throws Exception {
        Parameters params = getParameters();
        String usersTitle = params.getNamed().get("usersTitle");
        
        window.setTitle(usersTitle);
        window.show();
    }


}
