CREATE TABLE Tenants (
    TenantId INT PRIMARY KEY,
    Name VARCHAR(255)
);

-- Users who can make changes in the EAI System
CREATE TABLE Users (
    UserId INT PRIMARY KEY,
    FirstName VARCHAR(255) NOT NULL,
    LastName VARCHAR(255) NOT NULL,
    TimestampCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Customers (
    CustomerId INT PRIMARY KEY,
    TenantId INT,
    Name VARCHAR(255),
    FOREIGN KEY (TenantId) REFERENCES Tenants(TenantId)
);

CREATE TABLE AccountTransactions (
    TransactionId INT PRIMARY KEY,
    TenantId INT,
    CustomerId INT,
    AccountId INT,
    TransactionType, VARCHAR(225),
    Amount DECIMAL,
    TimestampCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (TenantId) REFERENCES Tenants(TenantId),
    FOREIGN KEY (CustomerId) REFERENCES Customers(CustomerId)
    FOREIGN KEY (AccountId) REFERENCES CustomerAccounts(AccountId)
);

CREATE TABLE CustomerAccounts (
    AccountId INT PRIMARY KEY,
    TenantId INT,
    CustomerId INT,
    Balance DECIMAL(10, 2),
    FOREIGN KEY (TenantId) REFERENCES Tenants(TenantId),
    FOREIGN KEY (CustomerId) REFERENCES Customers(CustomerId)
);

--ADD SOME KIND OF AUDIT LOG
--- Will only Users be able to make changes?
