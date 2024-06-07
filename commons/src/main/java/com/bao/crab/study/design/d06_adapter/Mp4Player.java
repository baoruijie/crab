package com.bao.crab.study.design.d06_adapter;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/1/12 16:48
 */

public class Mp4Player implements AdvanceMediaPlayer{

    @Override
    public void playVlc(String fileName) {
        // TODO nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("mp4 playing " + fileName);
    }
}
