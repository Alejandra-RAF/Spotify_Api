package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {


        MusicSource source = new MockSpotify();
        List<String> Ids = Arrays.asList("4NgfOZCL9Ml67xzM0xzIvC", "2ECP3nWC88LaFz4oQzTo3Z", "1lYT0A0LV5DUfxr6doRP3d");
        for (String id: Ids) {
            List<Artist> artistList = source.artistOf(id);
            List<Album> albumList = source.albumOf(id);
            //List<Song> songList = source.songOf(id);

            MusicDatabase musicDatabase = new SqliteMusicDatabase();

            // Para añadir los objetos a "TableArtists"
            for (Artist artist : artistList) {
                musicDatabase.add(artist);
            }

            // Para añadir los objetos a "TableAlbums"
            for (Album album : albumList) {
                musicDatabase.add(album);
            }

            // Para añadir los objetos a "TableSomgs"
            /*for (Song song : songList) {
                musicDatabase.add(song);
            }*/

        }
    }


}