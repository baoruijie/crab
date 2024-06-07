package com.bao.crab.study.design.d06_adapter;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/1/10 22:12
 */
public class Demo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
