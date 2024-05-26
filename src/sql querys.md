# Example MySQL Table and Queries


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