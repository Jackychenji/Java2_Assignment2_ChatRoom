package chatting.share.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Message implements Serializable {
  public final static int INVALID = 0;
  public final static int LOGIN = 1;
  public final static int LOGIN_SUCCESS = 2;
  public final static int LOGIN_FAIL = 3;
  public final static int LOGOUT = 4;
  public final static int CHAT = 5;
  public final static int UserAdd = 6;
  public final static int UserDelete = 7;
  public final static int SERVER_SHUTDOWN = 8;

  private int type;
  private Date date;
  private String user;
  private String ip;
  private String content;
  private List<String> targer_user = new ArrayList<>();

  public Message() {
    date = new Date();
  }

  public List<String> getTarger_user() {
    return targer_user;
  }

  public void AddTarger_user(String targer_user) {
    this.targer_user.add(targer_user);
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  @Override
  public String toString() {
    return "Message{" +
        "type=" + type +
        ", date=" + date +
        ", user='" + user + '\'' +
        ", ip='" + ip + '\'' +
        ", content='" + content + '\'' +
        ", targer = '" + targer_user + '\'' +
        '}';
  }
}
