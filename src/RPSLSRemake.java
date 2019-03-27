import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class RPSLSRemake extends Application {

    private boolean isServer = false;

    //private NetworkConnection  conn = isServer ? createServer(5555) : createClient("127.0.0.1", 5555);
    private Server server;
    private Client client;
    private TextArea messages = new TextArea();

    private Parent createContent() {
        messages.setPrefHeight(550);
        TextField input = new TextField();

        input.setOnAction(event -> {
            String message = isServer ? "Server: " : "Client: ";
            message += input.getText();
            input.clear();

            messages.appendText(message + "\n");
            try {
                System.out.println("Sending message: " + message);
                if (isServer)   {
                    server.send(message);
                }
                else    {
                    client.send(message);
                }
            }
            catch(Exception e) {
            }
        });

        VBox root = new VBox(20, messages, input);
        root.setPrefSize(600, 600);

        return root;
    }

    private Parent createContentClient()    {
        return null;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        if (isServer)   {
            server = new Server(5555, data-> {
                Platform.runLater(()->{
                    messages.appendText(data.toString() + "\n");
                    System.out.println(data.toString());
                });
            });
            server.startConn();
        }
        else    {
            client = new Client("127.0.0.1", 5555, data -> {
                Platform.runLater(()->{
                    messages.appendText(data.toString() + "\n");
                    System.out.println(data.toString());
                });
            });
            client.setCallback(data-> {
                Platform.runLater(() -> {
                    messages.appendText(data.toString() + "\n");
                    System.out.println(data.toString());
                });
            });
            client.startConn();
        }
        Screen.getPrimary().getDpi();
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();

    }

    /*
    @Override
    public void init() throws Exception{
        conn.startConn();
    }

    @Override
    public void stop() throws Exception{
        conn.closeConn();
    }
    */

    private Server createServer(int port) {
        return new Server(port, data-> {
            Platform.runLater(()->{
                messages.appendText(data.toString() + "\n");
                System.out.println(data.toString());
            });
        });
    }

    private Client createClient(String ip, int port) {
        return new Client(ip, port, data -> {
            Platform.runLater(()->{
                messages.appendText(data.toString() + "\n");
                System.out.println(data.toString());
            });
        });
    }
}
