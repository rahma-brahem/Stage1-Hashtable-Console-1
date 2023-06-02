/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.usousse.eniso.stage_1;

/**
 *
 * @author rahma
 */
import java.util.Scanner;
public class Presentation {
    public Presentation() {
    }

    public void letsStart() {
        Table tab = new Table(3);
        Service service = new Service(tab);
        Scanner s = new Scanner(System.in);
        String name = null;
        boolean result = false;
        System.out.println("welcome to rahma's first console app :)");
        System.out.println("would you like to start ?");
        String state = s.nextLine();

        while (state.equals("y")) {
            System.out.println("enter operation");
            String op=s.nextLine();

            String[] chArr=op.split(" ");
            switch (chArr[0]) {
                case "add":

                    result = service.add(chArr[1]);
                    if (result == true) {
                        System.out.println("done");
                    } else {
                        System.out.println("invalid operation");
                    }


                    break;
                case "remove":

                    result = service.remove(chArr[1]);
                    if (result == true) {
                        System.out.println("done");
                    } else {
                        System.out.println("invalid operation");
                    }


                    break;
                case "find":

                    result = service.find(chArr[1]);
                    if (result == true) {
                        System.out.println("Name exists");
                    } else {
                        System.out.println("name doesn't exixt");
                    }


                    break;
                case "list":
                    service.list();
                    break;
                default:
                    System.out.println("enter a valid operation");
                    break;
            }
            System.out.println("would you like to continue");
            state = s.next();

        }

        if (state.equals("n")) {
            System.out.println("thanks for your visit!");
        }

    }
  
    }

