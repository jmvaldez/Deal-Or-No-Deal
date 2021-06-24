package com.dealornodeal.model;

import com.apps.util.Prompter;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class GameTest {


    private Scanner scanner;
    private Prompter prompter;

    @Test
    public void prompt_returnsInputPrompt_whenValidInputIsProvided() throws FileNotFoundException {
        String response = null;
        scanner = new Scanner(new File("responses/casePickResponse"));
        prompter = new Prompter(scanner);

        response = prompter.prompt("Pick your first case: ");
        assertEquals("10", response);

    }
}