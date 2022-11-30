package com.BetterFriend.client;

import com.BetterFriend.client.services.ConsoleService;
import com.BetterFriend.client.services.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class BetterFriendClientApplication {

	public static void main(String[] args) {
		BetterFriendClientApplication app = new BetterFriendClientApplication();
		app.run();
	}
	PersonService personService = new PersonService();
	ConsoleService consoleService = new ConsoleService();

	private void run(){
		consoleService.printGreeting();
		consoleService.promptForCredentials();

	}
	private void mainMenu(){
		int menuSelection = -1;
		while (menuSelection!= 0){
			consoleService.printMenu();
			menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
			if (menuSelection == 1) {
				//      personService.createFriend();
			} else if (menuSelection == 2) {
				//      personService.listFriends();
			} else if (menuSelection == 3) {
				//    personService.updateFriend();
			} else if (menuSelection == 4) {
				//  personService.getRandomFriend();
			} else if (menuSelection == 5) {
				//personService.getAFriendsInformation();
			}else if (menuSelection == 6) {
			} else if (menuSelection == 0) {
				continue;
			} else {
				System.out.println("Invalid Selection");
			}
			consoleService.pause();
		}
	}

}
