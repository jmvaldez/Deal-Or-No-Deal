package com.dealornodeal;

import org.junit.Test;

import static org.junit.Assert.*;

public class HostTest {

    @Test
    public void createOffer() {
        Host host = new Host("Jarvis");
        host.createOffer();
    }
}