import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import automation.api.interfaces.ConnectedDevice;

public class TestClient {
 
	private static final String WS_URL = "http://192.168.0.234:8080/media-companion-1.0.0/MediaPlayer?wsdl";
 
	public static void main(String[] args) throws Exception {
 
		URL url = new URL(WS_URL);
        QName qname = new QName("http://media.pi.com/", "MediaPlayerService");
 
        Service service = Service.create(url, qname);
        ConnectedDevice mediaPlayer = service.getPort(ConnectedDevice.class);
 
        while(true) {
        	System.out.println("Play/Pause/Close?");
        	String event = System.console().readLine();
        	
        	if (event.equalsIgnoreCase("play")) {
        		String fileToPlay = "http://www.stuart-holland.com:8080/uploads/Hunger Game.mp4";
        		fileToPlay = fileToPlay.replace(" ", "%20");
        		Object parameters[] = {fileToPlay};
        		mediaPlayer.invokeMethod("playTrack", parameters);
        	}
        	if (event.equalsIgnoreCase("pause")) {
        		mediaPlayer.invokeMethod("togglePlay");
        	}
        	if (event.equalsIgnoreCase("close")) {
        		mediaPlayer.invokeMethod("close");
        	}
        } 
    }
}