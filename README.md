1) Import the project and run maven install. This is an empty project with all the required dependency and package structure with some empty classes.

2) Consider the cart json in the below format 

{
  "cartId": "Cart Id",
  "createdDate": "Created Date",
  "completedDate": "Cart completion date"
  "items":{
    "1":{"itemId":"Item Identifier","cartId":"Cart Id","name":"Product1","quantity":"1","price":"20"},
    "2":{"itemId":"","cartId":"","name":"Product2","quantity":"4","price":"3"}
  }
}

2) Create a static map as Cart data store for performing the CRUD operation.

3) Implement the cart resource with the functionality to get, save, update and delete cart. (Refer to com.att.demo.resource package).Validate the cart before saving or updating the information.

4) Handle all SUCCESS and FAILURE scenarios and return proper HTTP Status code.


2) Update the swagger documentation.

3) Complete the implementation and run the application

4) Test your APIs via swagger 

5) Implement the unit tests and component tests 
