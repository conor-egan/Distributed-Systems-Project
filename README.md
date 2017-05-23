# Distributed-Systems-Project
## Project requirements set by Dr. Reiner Dojen, UL ECE Department, as part of final grade for module CE4208

Your task is to develop an web application (outlined below) and deploy it on a virtual machine. Feel
free to use any Java EE container and database you like. However, your sources must be submitted as
a NetBeans project. All features should be implemented using EJB, entity classes and JSF/HTML only.
Do not use any other frameworks such as Hibernate or Spring. If you really “need” to use any other
framework/library, you must first confirm with me that it is ok to use these.

## Description
Your task is to write an online shop application using HTML, JSF, EJB and entity classes (think amazon
or something similar). Customers browse through your offerings, add or remove them from their
shopping cart and eventually either check out their order or cancel it. Access to your shop is limited –
you must provide an authentication scheme. Access rights are role based, where your system provides
two roles: customer and administrator.
1. Provide two accounts: Customer ‘joe’ with password “ 1D10T? ” (second last is zero) and
administrator ‘toor’ with password “4uIdo0!” (third is capital i - not one, second last is zero) - feel
free to add other accounts, but these must exist.
2. Customers can perform the following:
  - Browse through all your items.
  - Search products by ID number and browse through the search results.
  - Search products by name and browse through the search results.
  - Add displayed items to their shopping cart.
  - Remove items from their shopping cart.
  - Edit their profile - must contain at least name, Customer ID and a message to other users.
  Name and ID are taken from Customer table, message can be any text – allow at least for
  500 characters.
  - View profiles from other users – provide search by name and search by ID.
  - Check out or cancel current order.
3. Administrators can perform:
  - Add new products to the database.
  - Remove products from the database.
  - Increase/decrease the available amount (quantity_on_hand) of any product.
4. When customers check out, the quantity for your items in the database is adjusted
correspondingly. Make sure the quantity of a product in the database cannot drop below 0 – if an
order would cause this, display an error message to the user’s screen. On successful order, you
need to add a purchase order (PO) entry.
5. When customers cancel their order, the database should remain unchanged.
6. A logging facility (Message driven bean(s) must be used for the logging facility):
  - Every time a customer confirms an order or cancels an order a corresponding entry is
  added to the log (either a log-file or database table).
  - Every time an administrator adds/removes a product an entry is added to the log.
7. Your application must avoid the following OWASP Top 10 vulnerabilities:
  - A1: Injection
  - A3: Cross-Site Scripting (XSS)
  - A7: Missing Function Level Access Control
  - A8: Cross Site Request Forgery (CSRF)
