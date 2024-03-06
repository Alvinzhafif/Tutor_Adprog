# Reflection 
<hr>

## Name: Alvin Zhafif Afilla
## NPM: 2206046632

## MODULE 1
### Reflection 1 / Exercise 1 
<hr>

For exercise 1 i have implemented clean code architecture which is by implementing variables that implies to their meaning and purpose.
i also implemented Git flow by splitting the development into two seperate branch(main and list-product branch) this two branch help me to be more organized. 
<br>
<br>
Another implementation i did was secure coding by making sure the output of the data in forms to not be filled irrationally. Improvements are still necessary to be made in the coming future, as currently there's no authentication nor authorization for the project 
this will be a great addition to the secure coding implementation. In addition, further personal reminder to use git flow is needed for retrospection. Because currently, i am still in habbit of using a single branch which is main as the main branch for creating both the edit and delete function of the product list page

<br>

### Reflection 2 / Exercise 2
<hr>

1. After implementing unit tests, I feel relieved and proud to see my code working smoothly for all the features of creating the product, editing them, and also deleting them. The number of unit tests for a class may vary in my opinion depending on how much features does the class have.
But, it should come to mind that the number of tests for the class should cover the majority of the crucial features that will often be used. By checking the crucial aspects it will further reassure that your codes will run as intended without any hindrance.
<br>


2. If a new and additional test for checking number of items in the product list were to be added, it will surely increase the assurance and confirmation of your code is working smoothly. However, there is also a chance that it will reduce the code's cleanliness. Such as code duplication, creating another test case can lead to similar setups to other test cases. To reduce the chance of code duplication, a further enforcement and guidance to reuse codes by refactoring them time to time will be needed. Another example of reduction can be Inconsistent Naming. With the increase of cases additional naming of variables might be needed, and as those increases so as well the chance of creating Variable names that is not consistent or perhaps unreadable. A good way to reduce this is to reuse Variable names that already exist and add new ones if their functions does not exist yet while keeping clear functionality towards their name.

<br>

## MODULE 2
### Reflection 1 / Exercise 1

<hr>

1. I fixed and improved the code quality by adding new test cases in my project, I added those new test cases in some aspects. Such as the Product Controller, Product Service, and the Application itself. Those additional test include a test for edit product, delete product, create product, and also find products. Additional test cases for multiple products are also given on some occasions for ensuring each and every function is tested and covered correctly. Overall, the additional test has help my code to get a code coverage of 96% in jacoco testing.
2. CI/CD stands for Continuous Integration and Continuous Deployment, it is a set of practises and tools to integrate code changes in a shared repository and automatically delivers the change to the production or deployment. I believe my code has illustrated CI/CD very well, although it may not be a telling example as I have not fully implemented CI in the early parts of the development.
    I believed my code has illustrated CI because I have integrated my development into several branches each with their own functionality such as one for developing the product list, then another for unit testing, another one for functional testing, etc. I also believe i have implement and illustrated CD through direct deployment on push changes to the main branch, as for the deployment I currently use **Koyeb**.


## MODULE 3
### Reflection 1 / Exercise 1

<hr>

1. For this project I implemented a few SOLID principles, Here are the list of the principles I applied alongside which feature it is implemented to:
    * (S) Single Responsibility Principle:
        <br>
    For implementing this, I choose to once again head back to my `repository` folder. And here I found out that both of car repository and product repository class has CRUD methods in a single class.
    So I made two new classes for reading the create, delete, update of product model. I named it `ProductRepositoryRead`. Then, I made another one for the car model that will be used for reading the create, update, and delete operation done on the car model. I named it `CarRepositoryRead`.
    * (O) Open / Closed Principle:
      <br>
   For implementing this, I went back into my `controller` folder, after creating `CarController` both classes are set so that they are open to extension or modifications. This can be done by extending the currently available classes, without the need of altering the previously existing codes.
    *  (I) Interface Segregation Principle:
    For implementing this, I reviewed my `Model` folder, after implementing `Car` model I realized that there are similarities to the `Product` model. So, i made an interface named `Product` and used it for defining the set of methods that both class will implement. Then, I renamed the `Product` class to `ConcreteProduct` and added the methods defined in the interface to both of the model classes. There maybe additional methods for car as it has `carColor`, but that will be implemented directly on the `Repository` and `Service` classes.
    * (D) Dependecy Inversion Principle:
   For implementing this, I look over the `ProductController` class I made before. After making a few changes along with the changes of the `repository` folder, the `ProductController` now depends on `service` which makes it dependent on the abstraction (interface) rather than the concrete class. This will also ease maintenance and extension, as changes or updates can be made from the `ProductService` interface. `CarController` also implements this as it is relying on the `CarService` interface.
2. An advantage of applying solid can be taken from what the implementation on the `model` folder that I did. The advantage of implementing this changes is that now there is flexibility. For instance, when new types of products are going to be added the existing code would not need to be modified as both `Car` and `ConcreteProduct` are now part of the `Product` Interface. Another advantage is when it comes to testing, we can depend on the interface instead, this will reduce the difficulty to mock dependencies in the unit test.
3. The disadvantages of not applying that feature is that, we will have harder times making the unit tests. Because, we will be calling the concrete classes itself which makes it both redundant and tiring. Another disadvantage is that redundant codes can happen, making the same method for different classes can be redundant especially when in the long-term plans when we will decide to add more model classes.

## MODULE 4
### Reflection 1

<hr>

1. **Reflect based on Percival (2017) proposed self-reflective questions (in “Principles and Best Practice of Testing” submodule, chapter “Evaluating Your Testing Objectives”),**
<br>

**Do I have enough functional tests to reassure myself that my application really works, from the point of view of the user?**
<br>
<br>
The answer is no. For this test series as a matter of fact, there are no functional tests. Hence, all tests are in a form of a simulation for the program itself. Due to the test not being a functional test, there is no clear signs that the application will work perfectly in the user's prespective. In the near future, perhaps it's best to implement the controller and web page of the class so it's functionality can actually be tested.
<br>
<br>
**Am I testing all the edge cases thoroughly?**
<br>
<br>
I believe the test should already cover every part of the code thoroughly, including the classes services. Furthermore, if there were to be any doubt in cases where the method hasn't been covered yet, Jacoco test for code coverage can be used. In my case, the jacoco test should cover the necessity of the recently implemented features of both the exercise `payment` and tutorial's `order` feature. The test percentage overall is not that good but that came from my implementation of solid previously in `Module 3`.
<br>
<br>
**Do I have tests that check whether all my components fit together properly? Could some integrated tests do this, or are functional tests enough?**
<br>
<br>
I believe some of the unit test can check all the classes functionality in a single test. For instance one of the `order` test involves in calling the `model`,`service`, and the `repository`. An example, is the `testFindAllByAuthor` test, in the test for `OrderService` . However, it might be true that if we wish to see if the feature is working properly making the `controller` and functional test is necessary.
<br>
<br>
**Are my tests giving me the confidence to refactor my code, fearlessly and frequently?**
<br>
<br>
Yes after the tests and its respective `model` or `service` is implemented, I believed that my tests can be furthermore improved. By improving the naming convention and changing any redundancy in the test can make my tests more efficient and clearer to the eyes. As compared to before refactoring it's jumbled and the purpose of each test is not defined properly/
<br>
<br>
**Are my tests helping me to drive out a good design? If I have a lot of integration tests but less unit tests, do I need to make more unit tests to get better feedback on my code design?**
<br>
<br>
For this module, most of the allocation of tests goes to the unit tests. So i believed, that every inch of codes whether it's for the `repository`, `model`, or `service` must have already been covered. However if there are lacking cases, `Jacoco` can help me pinpoint the part I have not implemented through its test report.
<br>
<br>
**Are my feedback cycles as fast as I would like them? When do I get warned about bugs, and is there any practical way to make that happen sooner?**
<br>
<br>
When implementing TDD, the test cases are made beforehand. Hence, I can picture better how each test cases are layered out and of course the functionality of the `model`, `service`, or `repository` to come. Compared before TDD, bug warnings comes after the making of test cases hence it can be way sooner than expected.
<br>
<br>
**Is there some way that I could write faster integration tests that would get me feedback quicker?**
<br>
<br>
I don't think I implemented an Integration Test in this module. However, if that problem should arise in the future, I think it would be best to make the test more centralized to the specification of the test itself. Including its respective necessary methods, if perhaps it uses more than one method that belongs to different classes, an interface can be used.
<br>
<br>
**Can I run a subset of the full test suite when I need to?**
<br>
<br>
Yes. Reminiscing TDD, I have separated each test into different folders. These folders are grouped by the specific class of the code I wanted to test, Hence for instance I wanted to test my `models`, I can simply run the tests located inside the `model` folder.
<br>
<br>
**Am I spending too much time waiting for tests to run, and thus less time in a productive flow state?**
<br>
<br>
No not really, the tests are evenly distributed and all the tests should be finished in less than 6 seconds. However, in the coming projects where there will be many more classes, perhaps a different form of approach will be better. Such as auto testing from the GitHub itself.

<br>

2. **Has my unit tests implemented F.I.R.S.T.?**
<br>
**F) Fast**
<br>
Yes, it should not take more than 6 seconds to successfully run all test cases that I made.
<br>
**I) Isolated**
<br>
Yes, the condition of each test isn't dependent on other tests. It may use multiple methods of different classes but a test would not affect other tests
<br>
**R) Repeatable**
<br>
Yes, since each test is isolated as mentioned before. This will make each test be repeatable as every method used is set up a new everytime the test is runned again.
<br>
**S) Self-Validating**
<br>
Yes, each test has an assert case. This validates whether the expected output is the same as what it is intended to be. For a happy test case it will return true or according to the expected function, while for unhappy it should return the opposite.
<br>
**T) Thoroughly/Timely**
Yes, each test has been implemented thoroughly. This is furthermore proved by the reports produced from the jacoco test as it returns a code coverage greater than 95% for the new features. This means that each part of the test case should already cover the functionality and code of the feature itself.
