BEGIN TRANSACTION;

--Step 3
SELECT * 
FROM vw_Get_Account_Balance;

SELECT * 
FROM vw_Get_All_Transaction_History

--TRANSFERDAO
--Step 4. 1 - I should be able to choose from a list of users to send TE Bucks to.
SELECT username
FROM tenmo_user;

--Step 4.2 - I must not be allowed to send money to myself.
UPDATE account 
SET balance = (balance + ?)
WHERE user_id <> ?

-- Step 4.3 - A transfer includes the User IDs of the from and to users and the amount of TE Bucks
-- Send, intial status of approved, 
INSERT INTO transfer(transfer_type_id, transfer_status_id, account_from, account_to, amount)
VALUES (2, 2, 2001, 2002, 100);

INSERT INTO transfer(transfer_type_id, transfer_status_id, account_from, account_to, amount)
VALUES (2, 2, ?, ?, ?);
--Step 4.4 - The receiver's account balance is increased by the amount of the transfer. -- status approved
--included the AND to indicate user cannot send money to self
UPDATE account
SET balance = (balance + 100) 	
WHERE user_id = 1002 AND user_id <> 1001;

UPDATE account
SET balance = (balance + ?) 	
WHERE user_id = ? AND user_id <> ?;

--Step 4.5 - The sender's account balance is decreased by the amount of the transfer -- status approved
UPDATE account
SET balance = (balance - 100) 
WHERE user_id = 1001 AND user_id <> 1002;
 
UPDATE account
SET balance = (balance - ?) 
WHERE user_id = ? AND user_id <> ?; 

-- Step 4.7 - I can't send a zero or negative amount.
SELECT tenmo_user.username, account.balance
FROM tenmo_user
INNER JOIN account ON tenmo_user.user_id = account.user_id
WHERE balance > 0;

--Step 5 - As an authenticated user of the system, I need to be able to see transfers I have sent or received.
SELECT username, balance, account_from, account_to, amount, transfer_status, transfer_type_desc, transfer_status_desc,
transfer_id
FROM vw_Get_All_Transaction_History

--Step 6 - As an authenticated user of the system, I need to be able to retrieve the details of any transfer based
--upon the transfer ID.
SELECT username, balance, account_from, account_to, amount, transfer_status, transfer_type_desc, transfer_status_desc,
transfer_id
FROM vw_Get_All_Transaction_History
WHERE transfer_id = ?;

--transaction information by status id
SELECT username, balance, account_from, account_to, amount, transfer_id, transfer_type_desc, transfer_type_id,
transfer_status_desc, transfer_status_id, transfer_id
FROM vw_Get_All_Transaction_History
WHERE transfer_status_id = ?;

--update balance
UPDATE account
SET account_id=?, user_id=?, balance=?
WHERE user_id =?;

--transaction information by account id
SELECT username, balance, account_from, account_to, account_id, amount, transfer_id, transfer_type_desc, transfer_type_id,
transfer_status_desc, transfer_status_id, transfer_id
FROM vw_Get_All_Transaction_History
WHERE account_id = ?;
