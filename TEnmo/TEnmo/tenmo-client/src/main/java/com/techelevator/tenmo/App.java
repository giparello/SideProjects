package com.techelevator.tenmo;

import com.techelevator.tenmo.model.*;
import com.techelevator.tenmo.services.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";
    UserService userService = new UserService();
    TransferService transferService = new TransferService();
    AccountService accountService = new AccountService();
    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);
    private AuthenticatedUser currentUser;


    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        consoleService.printGreeting();
        loginMenu();
        if (currentUser != null) {
            mainMenu();
        }
    }
    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != 0 && currentUser == null) {
            consoleService.printLoginMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                handleRegister();
            } else if (menuSelection == 2) {
                handleLogin();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
                consoleService.pause();
            }
        }
    }

    private void handleRegister() {
        System.out.println("Please register a new user account");
        UserCredentials credentials = consoleService.promptForCredentials();
        if (authenticationService.register(credentials)) {
            System.out.println("Registration successful. You can now login.");
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleLogin() {
        UserCredentials credentials = consoleService.promptForCredentials();
        currentUser = authenticationService.login(credentials);
        if (currentUser == null) {
            consoleService.printErrorMessage();
        }
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                viewCurrentBalance();
            } else if (menuSelection == 2) {
                System.out.println(viewTransferHistory(currentUser.getUser().getId()));
            } else if (menuSelection == 3) {
                viewPendingRequests();
            } else if (menuSelection == 4) {
                sendBucks();
            } else if (menuSelection == 5) {
                requestBucks();
            }else if (menuSelection == 6) {
                int transferId = consoleService.promptForInt("What is the Id of the transfer you would like to view?: ");
                transferService.getTransferInformationByTransferId(transferId);
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

    @PreAuthorize("isAuthenticated()")
	private void viewCurrentBalance() {
        int  currentUserId = currentUser.getUser().getId();
        BigDecimal balance = accountService.getBalance(currentUserId);
        System.out.println("Your current account balance is: " + NumberFormat.getCurrencyInstance().format(balance));
	}

    @PreAuthorize("isAuthenticated")
    private void listAllTransfers() {

    }

    @PreAuthorize("isAuthenticated")
    private void printTransfersOrError(Transfer[] transfers){
        if (transfers != null){
            consoleService.printTransfers(transfers);
        }
        else System.out.println("No transfers found");
    }

    @PreAuthorize("isAuthenticated()")
	private List<Transfer> viewTransferHistory(int userId) {
        int accountId = accountService.getAccount(userId).getAccountId();

        Transfer[] transfers = transferService.getAllTransfers();
        List<Transfer> newTransfers = new ArrayList<>();
        //loop through all transfers and check if accountId matches
        for (Transfer transfer: transfers) {
            if (transfer.getAccountFrom() == accountId || transfer.getAccountTo() == accountId) {
                //add matching transfers
                newTransfers.add(transfer);
                System.out.println("TransferId: " + transfer.getTransferId() + "\nTransferType: " + transferService.getTransferTypeString(transfer.getTransferTypeId()) +
                        "\nTransfer Status: " + transferService.getTransferStatusString(transfer.getTransferStatusId()) +
                        "\nSent From User: " + transfer.getAccountFrom() +
                        "\nSent To User: " + transfer.getAccountTo() + "\nAmount Sent: " + transfer.getAmount() + "\n");
            }
        }
        //check if transfers added, if not found display no transfers
        if (newTransfers.size()!=0) {
            return null;
        }else{
            System.out.println("No transfers found");
            return newTransfers;
        }
	}
    @PreAuthorize("isAuthenticated()")
	private void viewPendingRequests() {
		// TODO Auto-generated method stub
		
	}

    @PreAuthorize("isAuthenticated")
    private void listAllUsers() {
        User[] users = userService.getAllUsers();
        printUsersOrError(users);
    }

    @PreAuthorize("isAuthenticated()")
    private void printUsersOrError(User[] users){
        if (users != null){
            consoleService.printUsers(users);
        }
    }

    @PreAuthorize("isAuthenticated()")
	private void sendBucks() {

        listAllUsers();
        int fromUserId = currentUser.getUser().getId();
        int toUserId = consoleService.promptForInt("Which user would you like to send money to? (input userID): ");
        BigDecimal amountToTransfer = consoleService.promptForBigDecimal("Please enter the amount that you would like to transfer:");
        //get balance from user being sent from
        BigDecimal fromBalance = accountService.getBalance(fromUserId);
        //subtract transfer amount
        BigDecimal finalFromBalance = fromBalance.subtract(amountToTransfer);

        //get balance from user being sent to
        BigDecimal toBalance = accountService.getBalance(toUserId);
        //add transfer amount
        BigDecimal finalToBalance = toBalance.add(amountToTransfer);


        //update the "from" user
        accountService.updateAccount(fromUserId, finalFromBalance);
        System.out.println("Your new Balance is: "+accountService.getBalance(fromUserId));
        //set transfer status and type
        int transferTypeId = 1;
        int transferStatusId = 2;
        //get account number for from user
        Account account = accountService.getAccount(fromUserId);
        int accountIdFrom = account.getAccountId();
        //get account number for to user
        Account accountTo = accountService.getAccount(toUserId);
        int accountIdTo = accountTo.getAccountId();
        //add new transfer
        transferService.addTransfer(transferTypeId, transferStatusId, accountIdFrom, accountIdTo, amountToTransfer);

        //update the "to" user
        accountService.updateAccount(toUserId, finalToBalance);
        System.out.println("$"+amountToTransfer +" Has been sent to user "+ toUserId);
        //set transfer status and add a new transfer
        transferTypeId = 2;
        transferStatusId = 2;
        transferService.addTransfer(transferTypeId, transferStatusId, accountIdFrom, accountIdTo, amountToTransfer);

    }




    @PreAuthorize("isAuthenticated()")
	private void requestBucks() {
        UserService userService = new UserService();
        final RestTemplate restTemplate = new RestTemplate();
        listAllUsers();
		
	}

}
