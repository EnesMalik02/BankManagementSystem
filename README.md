> [!NOTE]
> To run the program you must run the App.java file

## MySQL variables should be like this

![image](https://github.com/EnesMalik02/BankManagementSystem/assets/89933069/32b4655c-efca-41b5-8da3-98cac71ea4e7)


## Example MySQL Table and Queries
![image](https://github.com/EnesMalik02/BankManagementSystem/assets/89933069/97eaba9c-89c3-4e79-aa0d-75b09b51a28f)


### Gets user's balance
````
SELECT balance FROM <your-database-name> WHERE id = ?
````

### Withdraws money from user's account
````
update <your-database-name> set balance = balance - " + amount + " where id = " + id + ";
````

### Deposits money to user's account
````
update <your-database-name> set balance = balance + " + amount + " where id = " + id + ";
````

### Checks is password correct
````
select password FROM <your-database-name> WHERE id =" + ID + ";
````

### Creates a new user
````
INSERT INTO <your-database-name> (id, name, password, balance) VALUES (" + lastID + ", '" + username + "', '" + password + "', 0)
````

### Gets max id from id column
````
SELECT MAX(id) AS last_id FROM <your-database-name>
````

