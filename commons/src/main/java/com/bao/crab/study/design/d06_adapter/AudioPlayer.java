package com.bao.crab.study.design.d06_adapter;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/1/12 16:53
 */

public class AudioPlayer implements MediaPlayer{
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if("mp3".equals(audioType)){
            System.out.println("playing mp3 " + fileName);
        } else if("vlc".equals(audioType) || "mp4".equals(audioType)){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else{
            System.out.println("Invalid media " + audioType + " format not supported");
        }

    }
}
