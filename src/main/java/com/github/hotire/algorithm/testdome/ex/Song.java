package com.github.hotire.algorithm.testdome.ex;

import java.util.HashSet;
import java.util.Set;

public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isRepeatingPlaylist() {
        final Set<Song> songSet = new HashSet<>();
        for (Song s = nextSong; s != null; s = s.nextSong) {
            if (songSet.contains(s)) {
                return true;
            }
            songSet.add(s);
        }
        return false;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}