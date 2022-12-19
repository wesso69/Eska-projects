package javaapplication10;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

public class JavaApplication10 {

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        Playerserv p = new Playerserv();
        Playert player = new Playert();
        JsonObject playerJsonObject;
        player.setId(9);
        player.setFname("wase");
        player.setLname("shraide");
        player.setAbout("dota gamer");
        player.setAge(9);

        int status = p.setPlayer(player);
        if (status >= 0) {
            System.out.println("success");
             JsonObjectBuilder playerbuilder = Json.createObjectBuilder();
        playerbuilder.add("id", player.getId())
                .add("fname", player.getFname())
                .add("lname", player.getLname())
                .add("about", player.getAbout())
                .add("age", player.getAge());
        playerJsonObject = playerbuilder.build();
        System.out.println(playerJsonObject);
        OutputStream os = new FileOutputStream("player.txt");
        JsonWriter jsonWriter = Json.createWriter(os);

        }
       
//        player.setId(1);
//        player.setFname("Waseem");
//        player.setLname("shraideh");
//        player.setAbout("info");
//        player.setAge(22);
    }

//    public static Playert createPlayer() {
//
//        Playert player = new Playert();
//        player.setId(100);
//        player.setFname("waseem");
//        player.setLname("test");
//        player.setAbout("dota");
//        player.setAge(22);
//
//        return player;
//    }
}
