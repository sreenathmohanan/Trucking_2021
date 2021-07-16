package com.ibsplc.utils;

import java.io.File;

import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;

/**
 * Created by a-7681 on 5/29/2018.
 */
public class HHT {

    final private String JACOB_DLL_TO_USE = "jacob-1.18-x64.dll";
    protected AutoItX control;
    final int DELAY = 500;

    public HHT(){

        File file = new File(System.getProperty("user.dir") + "\\lib", JACOB_DLL_TO_USE);
        System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
        control = new AutoItX();
    }
    
    protected void focusWindow(String windowName){
        control.winActivate(windowName);
        control.winWaitActive(windowName);
        control.winMove(windowName,"",0,0);
    }

  








}
