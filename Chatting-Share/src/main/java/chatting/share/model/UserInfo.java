package chatting.share.model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class UserInfo {
  public String name;
  public Socket socket;
  public ObjectInputStream in;
  public ObjectOutputStream out;

  public UserInfo(String name, Socket socket, ObjectInputStream in, ObjectOutputStream out) {
    this.name = name;
    this.socket = socket;
    this.in = in;
    this.out = out;
  }
}
