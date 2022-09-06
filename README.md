# The Observer Design Pattern
## Purpose and Intent
The purpose of the Observer design pattern is to define a dependency among cooperating objects such that when the state of one, as represented by the values of one or more fields in the object, is modified, all other objects that depend on it are notified.  This is to ensure consistency of data across multiple objects.
## Applications
The Observer pattern is commonly used in software design across a wide range of applications. Perhaps the most familiar application is in social media. When a user creates a post in a social media application, other users can reply or react to that post. Any reply or reaction to that post results in a notification to the user who created it. In this application, the post is the state that is of interest. Any modification to that state, which includes replies or reactions, trigger a notification. The Observer pattern, as a general-purpose model, works in a very similar manner.
## Elements of the Observer Pattern
The Observer pattern consists of four distinct elements:

- A Subject, which can be represented as either an interface or an abstract class. In either case, the Subject is a general representation of the methods that must be implemented in classes that perform the interaction. Those methods are:
  - Attach: This method allows other objects (called Observers) that should receive notifications whenever the Subject state changes to associate themselves with the Subject object. This establishes the connection that allows Observer objects to receive notifications from the Subject.
  - Detach: Once notifications from the Subject to an Observer object is no longer necessary or desired, Observer objects can disassociate themselves from the Subject using this method.
  - Notify: This method notifies all Observer object attached to the Subject of a change in state by invoking a method called *update* in each Observer.
- An Observer, which, like Subject, can be represented as either an interface or an abstract class. The Observer interface contains only a single method:
  - Update: This is the method used to notify an Observer object of any change in state of the Subject. Typically calling this method causes an Observer object to poll the Subject object for its updated state.
- A Concrete Subject. This is a concrete class that, depending on the representation of Subject as either an interface or abstract class, either implements the Subject interface or extends the Subject abstract class and implements all abstract methods.
- A Concrete Observer. Similar to the Concrete Subject, this is a concrete class that either implements the Observer interface or extends the Observer abstract class, depending on its representation.
## Visual Model of the Observer Pattern
Figure 1 shows a UML class diagram of the general Observer design pattern. In this figure, both Subject and Observer are represented using interfaces, which is what you will use in this exercise. The Concrete Subject and Concrete Observer implement each respective interface.

![](Aspose.Words.77b73a97-a134-4e8a-b6c3-45ebc1c41de2.001.png)

**Figure 1**: UML Class Diagram of the General Observer Design Pattern Model

There are a few details in this model that should be highlighted.

**Concrete Subject State**: The Subject state is very application dependent. Therefore, methods designed to manipulate or access that state are not included in the Subject interface. In this model, the state is shown as a single private variable named *state*, but can be represented as any number of separate class fields. Also, in this model the *setState*** method is used to modify the state. However, it is possible to have multiple methods that can modify any part of the state. Invocation of any of those set methods would trigger a notification to each Observer object. Lastly, methods that read the value of the state, i.e., get methods, do not modify any part of the Subject state and therefore do not trigger notifications to Observers.

**Concrete Observer State**: Typically, each Concrete Observer maintains a copy of the Subject state. Ensuring these copies are consistent between the Concrete Subject and each Concrete Observer is the reason for this design pattern.  When the *update* method is invoked on a Concrete Observer, it calls one or more get methods on the Concrete Subject to retrieve the value or values of its updated state.

**Concrete Subject/Concrete Observer Linkage**: There is tight coupling between a Concrete Subject and its Concrete Observers. Each must maintain a reference to the other(s). In the case of the Concrete Subject, it maintains a list of Concrete Observer objects that are attached to it. Similarly, each Observer must maintain a reference to its Concrete Subject so that it can retrieve updated state information from it.


# Exercise
In this exercise, you will implement and test an application of the Observer design pattern.
## Problem
Consider a streaming media service that offers a selection of movies to its subscribers. Subscribers are interested in knowing what movies are available to watch, and the service makes periodic updates to its available offerings. In this exercise, the Concrete Subject is the streaming media service offering movies to subscribers, and the Concrete Observer is a subscriber. Keeping subscribers up to date on movie offerings is an appropriate application of the Observer design pattern.
## Tasks
For this exercise, you are provided a Java class that represents a movie and is called, appropriately enough, Movie. The Concrete Subject, which will be a Java class named Service, maintains an ArrayList of Movie objects, and that list constitutes its state. Concrete Observers, implemented as a Java class named Subscriber, attach themselves to the Service and receive notifications via their *update* method whenever a Movie is added to or removed from the ArrayList of Movie objects. Upon receiving the notification, each Subscriber will retrieve the updated ArrayList from the Service.

A concrete representation of the application is shown with the UML class diagram in Figure 2.

![](Aspose.Words.77b73a97-a134-4e8a-b6c3-45ebc1c41de2.002.png)

**Figure 2**: UML Class Diagram for Observer Pattern Movie Service Application



Your job is to implement the following:

- The Subject and Observer, implemented as Java interfaces with the required methods
- The Concrete Subject implemented as a Java class named Service, implementing the Subject interface, and including required state and observer fields, and any necessary methods.
- The Concrete Observer, implemented as a Java class named Subscriber, implementing the Observer interface, and including required state and subject fields, and any required methods.
## Some Considerations
- The abstract Observer design pattern model calls for a method named *notify* in the Subject interface. However, doing so in a Java interface causes a conflict with the method of the same name (that is also declared final) defined in the top-level Object class. Choose a different name for that method for your project.
- Write your code with the unit tests in mind.
- You are not required to write any code inside the main method of the main class.
- Although not in the model, for testing purposes you may wish to include a get method for the Subscriber state
