package thatteidlipudina.com.vheal;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import java.net.URISyntaxException;
public class RatKiller extends Application {
    private Socket mSocket;
    private static final String URL = "http://104.211.201.108:8080";
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            mSocket = IO.socket(URL);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    public Socket getmSocket(){
        return mSocket;
    }
}