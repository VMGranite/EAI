INSERT INTO Tenants (TenantId, Name) VALUES
(1, 'TenantA'),
(2, 'TenantB'),
(3, 'TenantC');

INSERT INTO Users (UserId, FirstName, LastName)
VALUES
    (1, 'Veronica', 'Rock'),
    (2, 'Justine', 'New'),
    (3, 'Daniel', 'Lotto');

INSERT INTO Customers (CustomerId, TenantId, Name) VALUES
(101, 1, 'CustomerA1'),
(102, 1, 'CustomerA2'),
(103, 2, 'CustomerB1'),
(104, 2, 'CustomerB2'),
(105, 3, 'CustomerC1'),
(106, 3, 'CustomerC2');

INSERT INTO AccountTransaction (TransactionId, TenantId, CustomerId, AccountId, TransactionType, Amount) VALUES
(1001, 1, 101, 2001, 'Deposit', 1000.00),
(1002, 1, 101, 2001, 'Void Deposit', -1000.00),
(1003, 1, 102, 2002, 'Withdrawal', -500.50),
(1004, 2, 103, 2003, 'Deposit', 750.25),
(1005, 2, 104, 2004, 'Withdrawal', -200.75),
(1006, 2, 104, 2004, 'Void Withdrawal', 200.75),
(1007, 3, 105, 2005, 'Deposit', 1200.75),
(1008, 3, 106, 2006, 'Withdrawal', -300.00);

INSERT INTO CustomerAccounts (AccountId, TenantId, CustomerId, Balance) VALUES
(2001, 1, 101, 500.00),
(2002, 1, 102, 100.50),
(2003, 2, 103, 2000.25),
(2004, 2, 104, 800.00),
(2005, 3, 105, 1500.75),
(2006, 3, 106, 600.00);
