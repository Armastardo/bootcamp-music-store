package com.globant.musicstore.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class ArtistControllerTest {

    @Test
    public void saludo() {
        ArtistController a=new ArtistController();
        assertEquals("hola",a.saludo());
    }
}