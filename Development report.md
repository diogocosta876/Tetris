## LPOO_1305 - Tetris

In this implementation of the world known phenomenon game called Tetris, you can feel the nostalgia of putting together all the pieces to survive as long as possible to have the highest score!

This project was developed by *Diogo Costa* (*up202007770*),  *José Costa* (*upx*xxxxxxxx) and *Manuel Amorim* (*upx*xxxxxxxx) for LDTS 2021/22.



### IMPLEMENTED FEATURES

- **Piece Generation -** A piece chosen by random is placed on the game as the previous controlled piece piece is placed.

- **Piece Rotation -** A piece can be rotated by pressing the up arrow.

- **Piece's Movement -** The Player can move the pieces horizontally, in order to line them up according to the player's strategy, he can also force the pieces down, as in the original tetris, to speed up the gameplay.

- **Piece's Collision Detection -** The game will detect if the Player tries to move the piece into an obstacle and **prevent it**. This happens when moving horizontally either into a wall or into another piece. 

  The piece is also **locked** into the board if it's bottom collides either with the floor or into another piece.

- **Game Timing** - synchronized ticks determine the game pace, when the tick counter reaches a predetermined value, *gameSpeed*, the piece drops by one position.

  

### PLANNED FEATURES

**UI Mockup**

![mockup](C:\Users\Diogo\Desktop\ldts-project-assignment-g1305\docs\mockup.png)

**Piece Preview - **There should be a visible and intuitive preview window showing what the next piece to spawn is.

**Score - ** The score should be shown to the user, points are awarded when:

1- A piece falls and sticks do the bottom/other pieces

2- A full horizontal line is completed, disappearing.



### DESIGN

#### Refactoring the project to follow the mvc architectural pattern

**Problem in Context**

While initially working on the project, we were finding ourselves struggling to effectively work on the project   all at the same time. On top of that, the complexity level was also rising and making our efforts less productive.

**The Pattern**

The **Model View Controller** (MVC) architectural pattern specifies that an application consist of a data model, information information, and information control. The pattern requires that each of these be separated into different objects.

**Implementation**

The following image represents the different folders that were added to hold the function-specific classes.

![img](https://web.fe.up.pt/~arestivo/presentation/assets/patterns/mvc.svg)

**Consequences**

The use of the State Pattern in the current design has the following consequences:

- **Easier planning** by giving us an outline of how to arrange their ideas into actual code and **easier maintenance** by limiting code duplication
- **Easier modification** of the entire application as any changes in a certain section will never affect the entire architecture
- Allows for **easier collaboration** between the team members
- **Supports and encourages TTD** (test-driven development)
- Required us to sometimes split what was previously **one class's functionality into 3 separate classes**, introducing dozens of classes and therefore some complexion

- Required a **heavy refactoring **of all the project's code

------

#### Piece State

**Problem in Context**

In our game, the piece controlled by the player can have different shapes or colors. Instead of hard coding the shape and color into all the classes and duplicating the methods for each class we decided to use the State design pattern.

**The Pattern**

State design pattern is used when an Object changes its behavior based on its internal state.

If we have to change behavior of an object based on its state, we can have a **state variable** in the Object and use if-else condition block to perform different actions based on the state. State pattern is used to provide a systematic and lose-coupled way to achieve this through Context and State implementations.

- **Context:** Defines an interface to client to interact. It maintains references to concrete state object which may be used to define current state of object.
- **State:** Defines interface for declaring what each concrete state should do.
- **ConcreteState:** Provides implementation for methods defined in State.

**Implementation**

The following UML representation shows how the different classes connect themselves. An interface forces the state classes to implement the methods needed to be a state object for the piece Class. If the random algorithm chooses a certain class, for example Lpiece, an instance of this class will be stored as state on the Piece instance that represents the moving piece in the game and the rest of the program will be able to access this state's specific attributes.

![piece state.drawio](C:\Users\Diogo\Desktop\ldts-project-assignment-g1305\docs\piece state.drawio.png)



**Consequences**

The use of the State Pattern in the current design has the following consequences:

- **Decluttering of the Piece class -**  extracts all state-specific code into a set of distinct classes

- **Implementation implicit code - **The structure of the pattern is implicit in the filesystem, allowing for a better understanding of all of it's functionality

  

### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

> This section should describe 3 to 5 different code smells that you have identified in your current implementation, and suggest ways in which the code could be refactored to eliminate them. Each smell and refactoring suggestions should be described in its own subsection.

**Example of such a subsection**:

------

#### DATA CLASS

The `PlatformSegment` class is a **Data Class**, as it contains only fields, and no behavior. This is problematic because […].

A way to improve the code would be to move the `isPlatformSegmentSolid()` method to the `PlatformSegment` class, as this logic is purely concerned with the `PlatformSegment` class.

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.

**Example**:

- John Doe: 40%
- Jane Doe: 60%