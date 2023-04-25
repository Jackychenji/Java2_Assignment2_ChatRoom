package chatting.share.control;

import chatting.share.model.Message;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.text.SimpleDateFormat;


public class MsgListCell extends ListCell<Message> {
  private static final SimpleDateFormat sdf = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss");

  @Override
  public void updateItem(Message msg, boolean empty) {
    super.updateItem(msg, empty);
    if (empty || msg == null) {
      setGraphic(null);
    } else {
      if (msg.getType() != Message.CHAT) return;
      VBox v = new VBox();
      Label header = new Label(msg.getUser() + " (" + msg.getIp() + ") " + sdf.format(msg.getDate()));
      Text content = new Text(msg.getContent());
      v.getChildren().addAll(header, content);
      setGraphic(v);
    }
  }
}
