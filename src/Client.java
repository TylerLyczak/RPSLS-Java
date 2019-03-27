import java.io.Serializable;
import java.util.function.Consumer;

public class Client extends NetworkConnection {

    private String ip;
    private int port;
    private ClientData moveData;

    public Client(String ip, int port, Consumer<Serializable> callback) {
        super(callback);
        this.ip = ip;
        this.port = port;
        moveData = new ClientData();
    }

    @Override
    protected boolean isServer() {
        return false;
    }

    @Override
    protected String getIP() {
        // TODO Auto-generated method stub
        return this.ip;
    }

    @Override
    protected int getPort() {
        // TODO Auto-generated method stub
        return this.port;
    }

    public void setCallbackClient(Consumer<Serializable> callback)    {
        setCallback(callback);
    }

    public ClientData getMoveData() { return moveData;}

    public boolean makeMove (String move)   {
        if (move.equals("moveRock"))    {
            moveData.setRock(true);
            return true;
        }
        else if (move.equals("movePaper"))  {
            moveData.setPaper(true);
            return true;
        }
        else if (move.equals("moveScissors"))   {
            moveData.setScissors(true);
            return true;
        }
        else if (move.equals("moveLizard")) {
            moveData.setLizard(true);
            return true;
        }
        else if (move.equals("moveSpock"))  {
            moveData.setSpock(true);
            return true;
        }
        return false;
    }

}