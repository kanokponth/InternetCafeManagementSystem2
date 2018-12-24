package System;

import javafx.event.ActionEvent;

import java.sql.SQLException;

public interface OKPopup {

    void confirm(ActionEvent event) throws SQLException;
    void cancel(ActionEvent event) throws SQLException;
}

