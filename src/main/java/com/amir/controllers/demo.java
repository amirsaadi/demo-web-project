package com.amir.controllers;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Amir on 2016-12-02.
 * spring-weblog
 */
public class demo {
    public static void main(String[] args) {
        int amountOfTeams;
        System.out.println("Enter the number of teams: ");
        Scanner keyboard =new Scanner(System.in);
        amountOfTeams=keyboard.nextInt();
        keyboard.nextLine(); // Consume newline left-over
        String teamName = "";
        int x = 1;
        int c = 2;
        while(x<=amountOfTeams)

        {
            System.out.println("What is the name of team " + (x++) + ": ");
            teamName = keyboard.nextLine();
            int b = 1;

            for (int a = 1; a < amountOfTeams; ++a) {

                System.out.println("Match " + a++ + ": (" + b++ + " of " + (amountOfTeams - 1) + ") for " + teamName
                        + " vs. team " + c);
                c++;
            }
        }
    }



}