Level 1: 

We have an entity named "Branch" which has the following properties:

Integer pk_BranchID
String branchName
String branchCountry
We also have a DTO named "BranchDTO" which will have the same properties as the "Branch" entity, with an addition:

String branchType.
This property, depending on the country of the branch, should indicate whether it is "EU" or "Non-EU". To achieve this, you can have a private list in the same DTO (for example: List<String> countries), with the countries that are part of the EU.

Taking advantage of the JPA specification, you will need to persist the "Branch" entity to a MySQL database, following the MVC pattern.

The recommendation is to use "BranchDTO" in the Controller and View layers, and "Branch" in the Repository layer. The service layer will be responsible for translating between the two.

For this, depending on the main package, you will create a package structure, where you will place the necessary classes:

cat.itacademy.barcelonactiva.surname.name.s05.t01.n01.controllers
cat.itacademy.barcelonactiva.surname.name.s05.t01.n01.model.domain
cat.itacademy.barcelonactiva.surname.name.s05.t01.n01.model.dto
cat.itacademy.barcelonactiva.surname.name.s05.t01.n01.model.services
cat.itacademy.barcelonactiva.surname.name.s05.t01.n01.model.repository
The class located in the controllers package (e.g., "BranchController") should be able to respond to the following requests to update and query information:

http://localhost:9000/branch/add
http://localhost:9000/branch/update
http://localhost:9000/branch/delete/{id}
http://localhost:9000/branch/getOne/{id}
http://localhost:9000/branch/getAll
As you can see, in the "application.properties" file, you will need to configure the port to be used as 9000.

The view should be developed using Thymeleaf.

Level 2: 


We have an entity named "FlowerEntity" which has the following properties:

Integer pk_FlowerID
String flowerName
String flowerCountry
We also have a DTO named "FlowerDTO" which will have the same properties as the "FlowerEntity", with an addition:

String flowerType.
This property, depending on the country of origin of the flower, should indicate whether it is "EU" or "Non-EU". To achieve this, you can have a private list in the same DTO (for example: List<String> countries), with the countries that are part of the EU.

Taking advantage of the JPA specification, you will need to persist the "FlowerEntity" entity to a MySQL database, following the MVC pattern.

The recommendation is to use "FlowerDTO" in the Controller, and "FlowerEntity" in the Repository. The service layer will be responsible for translating between the two.

For this, depending on the main package, you will create a package structure, where you will place the necessary classes:

cat.itacademy.barcelonactiva.surname.name.s05.t01.n02.controllers
cat.itacademy.barcelonactiva.surname.name.s05.t01.n02.model.domain
cat.itacademy.barcelonactiva.surname.name.s05.t01.n02.model.dto
cat.itacademy.barcelonactiva.surname.name.s05.t01.n02.model.services
cat.itacademy.barcelonactiva.surname.name.s05.t01.n02.model.repository
The class located in the controllers package (e.g., "FlowerController") should be able to respond to the following requests to update and query information:

http://localhost:9001/flower/add
http://localhost:9001/flower/update
http://localhost:9001/flower/delete/{id}
http://localhost:9001/flower/getOne/{id}
http://localhost:9001/flower/getAll

Use Swagger.

Level 3:

Using RestTemplate or WebClient, you will need to connect to the API you created at level 2 to call and test all the requests that this API allows.

Keep in mind that in this task at level 3, you have no reference to any database, and you do not need to use JPA, as your repository will access the level 2 API.

You do not need to create a View because this level 3 is intended as a Rest API, but you will have to create all the layers up to the controller like any other application:

cat.itacademy.barcelonactiva.surname.name.s05.t01.n03.controllers
cat.itacademy.barcelonactiva.surname.name.s05.t01.n03.model.domain
cat.itacademy.barcelonactiva.surname.name.s05.t01.n03.model.dto
cat.itacademy.barcelonactiva.surname.name.s05.t01.n03.model.services
cat.itacademy.barcelonactiva.surname.name.s05.t01.n03.model.repository
The controller class should be able to handle the following requests:

http://localhost:9002/flower/clientFlowersAdd
http://localhost:9002/flower/clientFlowersUpdate
http://localhost:9002/flower/clientFlowersDelete/{id}
http://localhost:9002/flower/clientFlowersGetOne/{id}
http://localhost:9002/flower/clientFlowersAll
As you can see, in the "application.properties" file, you will need to configure the port to be used as 9002.

To test level 3, you will need to have the level 2 API up and running. You won't have any issues since the level 3 API works with port 9002 and the level 2 API with port 9001.
