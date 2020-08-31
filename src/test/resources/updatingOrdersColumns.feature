Feature: adding new column in UserOrders table

@UpdateOrdersColumn
Scenario: Updating table columns
Given user is connected to database TheShop
Then user updates table Orders with column "QuantityOfItems" and type of column "varchar(10)"