import javax.xml.ws.Endpoint;

import com.pi.media.MediaPlayer;

// DEPRECATED - REPLACED WITH DEPLOYABLE WAR FOR USE WITH TOMCAT
public class PublishServer {
    public static void main(String[] args) {
    	Endpoint.publish("http://localhost:8080/media-control/MediaPlayer", new MediaPlayer());
    }   	
}
