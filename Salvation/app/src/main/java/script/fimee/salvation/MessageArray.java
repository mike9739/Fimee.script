package script.fimee.salvation;
import com.orm.SugarRecord;

/**
 * Created by migu_ on 04/06/2018.
 */

public class MessageArray extends SugarRecord {

    String NewMessage;

    public MessageArray() {
    }

    public MessageArray(String NewMessage){this.NewMessage=NewMessage;}

    public String getNewMessage(){return NewMessage;}

    public void setMessage(String NewMessage){this.NewMessage = NewMessage; }



}
