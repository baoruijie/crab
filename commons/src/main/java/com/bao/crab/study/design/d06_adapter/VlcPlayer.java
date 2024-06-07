package com.bao.crab.study.design.d06_adapter;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/1/12 16:47
 */

public class VlcPlayer implements AdvanceMediaPlayer{

    @Override
    public void playVlc(String fileName) {
        System.out.println("vlc playing " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // TODO nothing
    }
}
