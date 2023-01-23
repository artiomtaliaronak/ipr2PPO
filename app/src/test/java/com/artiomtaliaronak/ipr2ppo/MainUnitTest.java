package com.artiomtaliaronak.ipr2ppo;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(JUnit4.class)
public class MainUnitTest {

    @Test
    public void initTest(){
        MainActivity mainActivity = Mockito.mock(MainActivity.class);
        mainActivity.displayData();
        verify(mainActivity).displayData();
    }

    @Test
    public void updateTest(){
        UpdateActivity updateActivity = Mockito.mock(UpdateActivity.class);
        updateActivity.getAndSetIntentData();
        verify(updateActivity).getAndSetIntentData();
    }

    @Test
    public void readAllDAtaTest(){
        AlbumDatabaseHelper albumDatabaseHelper = Mockito.mock(AlbumDatabaseHelper.class);
        albumDatabaseHelper.readAllData();
        verify(albumDatabaseHelper).readAllData();
    }

    @Test
    public void addAlbumTest(){
        AlbumDatabaseHelper albumDatabaseHelper = Mockito.mock(AlbumDatabaseHelper.class);
        albumDatabaseHelper.addAlbum("awd","awd", 1);
        verify(albumDatabaseHelper).addAlbum("awd", "awd", 1);
    }



}