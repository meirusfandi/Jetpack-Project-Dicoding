package com.meirusfandi.myunittesting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainViewModelTest {

    private MainViewModel mainViewModel;
    private CuboidModel cuboidModel;

    private double dummyVolume = 504.0;
    private double dummycircumference = 2016.0;
    private double dummysurfacearea = 396.0;
    private double dummyLength = 12.0;
    private double dummyWidth = 7.0;
    private double dummyHeight= 6.0;

    @Before
    public void before(){
        cuboidModel = mock(CuboidModel.class);
        mainViewModel = new MainViewModel(cuboidModel);
    }

    @Test
    public void testVolume(){
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dummyLength, dummyWidth, dummyHeight);
        double volume = mainViewModel.getVolume();
        assertEquals(dummyVolume, volume, 0.0001);
    }

    @Test
    public void testCircumference() {
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dummyLength, dummyWidth, dummyHeight);
        double circumference = mainViewModel.getCircumference();
        assertEquals(dummycircumference, circumference, 0.0001);
    }

    @Test
    public void testSurfaceArea() {
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dummyLength, dummyWidth, dummyHeight);
        double surfacearea = mainViewModel.getSurfaceArea();
        assertEquals(dummysurfacearea, surfacearea, 0.0001);
    }

    @Test
    public void mockVolume() {
        when(mainViewModel.getVolume()).thenReturn(dummyVolume);
        double volume = mainViewModel.getVolume();
        verify(cuboidModel).getVolume();
        assertEquals(dummyVolume, volume, 0.0001);
    }

    @Test
    public void mockCircumference() {
        when(mainViewModel.getCircumference()).thenReturn(dummycircumference);
        double circum = mainViewModel.getCircumference();
        verify(cuboidModel).getCircumference();
        assertEquals(dummycircumference, circum, 0.0001);
    }

    @Test
    public void mockSurfaceArea() {
        when(mainViewModel.getSurfaceArea()).thenReturn(dummysurfacearea);
        double surface = mainViewModel.getSurfaceArea();
        verify(cuboidModel).getSurfaceArea();
        assertEquals(dummysurfacearea, surface, 0.0001);
    }
}