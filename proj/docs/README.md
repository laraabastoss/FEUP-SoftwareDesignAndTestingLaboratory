# project-l05gr03- Space Invaders

In this games the user is a spaceship and needs to kills all the monsters by shotting bullets. The monsters can shoot back and if they hit the spaceship, the user loses one of the three lifes it starts with. If all the monsters are killed, the user passes to the next level. Each level is increasingly harder because the monster move faster and shoot more bullets If the user has zero lives left, it loses. There are three walls composed by blocks that protect the monster. If a bullets hits the wall, it starts desctructing, losing one block at a time.



This project was developed by *Lara Bastos* (up202108740@fe.up.pt), *Lia Sobral* (up202108741@fe.up.pt) and *Miguel Barros* (up202108678@fe.up.pt).



## IMPLEMENTED FEATURES

**start the game-** by pressing enter when "Start" is selected in the Menu

**exit the game-** by pressing "Exit" in the Menu, or pressing 'q' or 'esc' at any point of the Game

**mute the Sound Effects and/or Music-** by going to the settings and pressing the right or left arrow until the desired option is selected ("Unmuted" or "Muted")

**moving the spaceship-** by pressing the left or the right arrow in the keyboard

**shotting bullets-** by pressing enter, the spaceship shoot bullets from the position it is, if the bullet hits the monster, it is killed, if the bullet hits a block, it is destroid

**kill monsters-** by shotting a bullet at it

**destroy blocks-** by shotting a bullet at it

**accumulate points-** when you kill one of the monster, you gain the points associated to them (10, 20, 30 or a random number for the bonus mosnter)

**lose lives-** when one of the monsters hits you, you lose one life, if you don´t have any lives left you lose

**pass to the next level-** when all the mosters are killed you are able to pass to next level of the game

**finish the game-** if you pass the three levels you win



## PLANNED FEATURES

we were able to implement all the features we wanted

## DESIGN

### Structure

**Problem in Context**

The first problem we faced while developing our game was its general structure and how we were going to organize all our classes in a way that is easy to undestand and to modify, when needed.

**The Pattern**

We decided to implement *Architectural Pattern* , with the Model-Viewer-Controller style in order to structure our code.

**Implementaion**

This pattern divides our classes in three main groups, each with its own purpouse:
-Model- stores the actual data of the game 
-Viewer- is responsible for what is shown in the screen
-Controller- responsible for recieiving the input of the player and making the game function

![Untitled Diagram drawio-42 copy-3 copy](https://user-images.githubusercontent.com/92671491/209155357-8af00189-892f-4a23-a4fe-e4cb46f7dfe3.png)

**Consequences** 

This pattern was vey helpuful to organize our code, making it very easy to add new features and find every thing we want, since it is organized in three main groups (model, viewer, controller). It assured us we were following a lot of the SOLID principles, mainly The Single Responsibility Principle and the Open Closed Responsiblity.



### THERE SHOULD BE 6 DIFFERENT STATES

**Problem in Context**

In this game, there are 6 different states in which the user can be: MenuState, SettingsState, GameState, MenuWin, MenuLose and MenuEndGame. The viewer (what is shown in the terminal) and the controller (how the keyboard commands interact with the game) depend on which state we are in, therefore this states are suppose to change in run-time, according to the following state machine.

![Untitled Diagram drawio-35](https://user-images.githubusercontent.com/92671491/209155276-f32f2ee5-a7a5-4b1f-9c90-0889d7ba826b.png)

In order to achieve this, we used two Design Patterns. 

**The Pattern- 1**

First of all, we used the *State Pattern* to implement 5 different subclasses, because it allows us to have several different states and change between them. 

**Implementation- 1**

Each subclass (concrete state) correspond to a different state, deriving from the *State* class (abstracts state), that has the methods and atributes common to all of the states. The Game (content), has a state as an attribute,therefore , by using setState(wanted state), you´re able to change it.

![Untitled Diagram drawio-42 copy-3 copy 2](https://user-images.githubusercontent.com/92671491/209155448-8807e3b7-fe63-40b6-b9e1-a15eb9f4cce8.png)


[State] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/state/State.java)

[MenuState] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/state/MenuState.java)

[GameState] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/state/GameState.java)

[SettingsState] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/state/SettingsState.java)

[MenuWinState] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/state/MenuWinState.java)

[MenuLoseState] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/state/MenuLoseState.java)

[MenuEndGameState] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/state/MenuEndGameState.java)



**Consequences- 1** 

The most helpful thing about this method was how easy it was to change state, because there was a class declaring each. However, it implied we had to create multiple classes, and whenever we added a new state, the code increased exponentially.

**The Pattern- 2**

We also used the *Factory Method*. This allows us to have different factories, each creating a different product only when it is needed.

**Implementation- 2**

The *State* class corresponds to the the abstract factory and each subclass to the concretre factory, that specifies the concrete product it wants to create. The concrete products correspond to the models (Menu, MenuWin, MenuLose, MenuEndGame, Game). This way, we don´t have to antecipate the model we want to create until we have to call them.

![Untitled Diagram drawio-43](https://user-images.githubusercontent.com/92671491/203978417-2b4d3363-8f1e-4233-a40a-92585abb4f91.png)


[State] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/state/State.java)

[MenuState] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/state/MenuState.java)

[GameState] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/state/GameState.java)

[Menu] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/model/Menu.java)

[Arena] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/model/Arena.java)

[SetingsState] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/state/SettingsState.java)

[Settings] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/model/Settings.java)

[MenuWinState] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/state/MenuWinState.java)

[MenuWin] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/model/MenuWin.java)

[MenuLoseState] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/state/MenuLoseState.java)

[MenuLose] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/model/MenuLose.java)

[MenuEndGameState] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/state/MenuEndGameState.java)

[MenuEndGame] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/model/MenuEndGame.java)

This method allowed the sub-classes to choose the type of objects it creates, eliminating the need to bind application-specific classes into the code. However, once again, it can expand the total number of classes in a system, because each concrete factory requires on concrete product.

### THE MONSTERS IN THE LIST AND THE BONUS MONSTER MOVE DIFFERENTLY 

**Problem in Context**

We have two different types of monsters:

-the monsters in the list, that move right to left, and when hit the edges change direction

-the bonus monster, that is alone and also moves right to left, disappearing for a while

**The Pattern**

For this problem we have decided to use the *Factory Method Pattern* since it allows us to present more than one type of monster. It also grants us the ability to delegate the responsability of creating the monster with the characteristics we want to the subclasses. This way we only have to choose which one of the subclasses (ListMonster or BonusMonster) we want to create.

**Implementation**

To implement this method we created the Monster abstracts class that declares the swicthMonsterDirection abstract method. This method return a boolean value telling us if the Monster should keep moving in the same direction or change it.It is overriden is both the subclasses (ListMonster or BonusMonster) diferrently depending on how we want each type of monster to move. The first one should hit the edges and immediatly change direction, while the second one should walk a few after the edges and only then change its direction.

![Untitled Diagram drawio-46 copy](https://user-images.githubusercontent.com/92671491/209145670-933c8a4c-24e5-4037-8331-3ed5a9fc417a.png)


[Monster] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/model/Monster.java)

[ListMonster] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/model/ListMonster.java)

[BonusMonster] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/model/BonusMonster.java)

**Consequences**

Like mentioned before, this pattern is extremely helpful when we want to create two types of objects of the same abstract class but with different characteristics since, allowing us to only deal with the abstract Factory. However, in this case, we found particularly hard to decide which of the attributes should stay in the abstract class and which should move to the subclasses.

### Call the sound effects and music when needed

**Problem in Context**

When we decided to implement sound effects, it emerged the question of how and when to call them, since it was mostly when there was a change of state.

**The Pattern**

We came to the conclusion that the best solution to this problem was to implement the *Observer Pattern*, sincea change in the Game object requires change in other obejcts and whenever the state changed there was the need to notify the sound effects objects created.

**Implementation**

In order to implement this method, we created the SoundEffect abstracts class, that has multiple sublclasse each with a specific path to the sound they represent. In the Game class, was created an object of each of these sublcasses. In the setState() method in the Game class, are called two other method: notifySound() and notifyMusic(). This way, whenever the state changes, we notify the sound objects that they should play, depending on the new state.

![Untitled Diagram drawio-42 copy-3 2](https://user-images.githubusercontent.com/92671491/209148639-070fb7a6-b6d5-41d2-8a6e-176f1b74ffe4.png)

**Consequences**

The main advantage of this pattern was that it allows us to send information (notify) to specific objects even being in a different class. On the other hand, it requires the creation of new methods, in our case, with a lot of if statements, resulting in a few code smells.

[Game] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/Game.java)

[SoundEffects] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/soundeffects/SoundEffect.java)

[SelectSound] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/soundeffects/SelectSound.java)

[NextLevelSound] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/soundeffects/NextLevelSound.java)

[MonsterKilledSound] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/soundeffects/MonsterKilledSound.java)

[LoseSound] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/soundeffects/LoseSound.java)

[HitSpaceshipSound] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/soundeffects/HitSpaceshipSound.java)

[GameSound] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/soundeffects/GameSound.java)

[GameFinishedSound] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/soundeffects/GameFinishedSound.java)

[AttackSound] (https://github.com/FEUP-LDTS-2022/project-l05gr03/blob/FirstScreen/src/main/java/spaceinvaders/soundeffects/AttackSound.java)

## KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS
 
### VIOLATION OF THE LISKOV SUBSTITUTION PRINCIPLE

When creating the Monster abstract class we added a bullet as an attribute, however, only one of its sublclasses actually have a bullet. The Bonus Monster subclasse doesn´t shoot bullets therefore it is not substitutable for the base class, going against the Liskov Substitution Principle. Contratry to what the principle says, the derived class provides less that the class it extends.
This could be solved by the Push Down Field refactoring technique, meaning that we cold put the bullet only as an attribute of the subclasses that should have it, however this raised other problems and code smells so we decided to keep it that way.

### LONG METHOD


The most present code smell present in our project were Long Methods, specially in the step() method of the Controller classes. This is caused because of the choosen design pattern (**MVC architectural pattern**) that delegates the responsability to implement the logic functionalities of each model to the controllers, resulting in a lot of code. The best refactoring techinque to solve this is the Extract Method, grouping together code fragments that make sense in the same method. This created more methods but all shorter. We used the Extract Method to get rid of some long methods, mainly in the MonsterController and in the ArenaController classes.

### PARALELL INHERITANCE HIERARCHIES

Once again, due to the **MVC architectural pattern**, whenever a new subclass is created we found ourselves needing to create multiple other subclasses (Controller, Viewer, Model). This happens because each of these have their own responsbility and interact with each other to make the overall code work, being all crucial. Since this only happens because of this Design Pattern, there's not any refactoring technique that could solve it beside using another pattern to structure the game.

### DATA CLASS

We have a few Data Classes in our code, mainly the Position class, that only has attributes and no methodd (besides getters and setters), however we did not find any refactoring methos that could solve this since they are assencial to the project  


## TESTS



class coverage: 90%,
method coverage: 89%,
line coverage 80%

<img width="687" alt="Screenshot 2022-12-23 at 18 51 14" src="https://user-images.githubusercontent.com/92671491/209394080-d1429fc6-3c08-4059-bc71-a1e51582f519.png">

**Mutation Test-PIT**


<img width="1289" alt="Screenshot 2022-12-23 at 18 56 23" src="https://user-images.githubusercontent.com/92671491/209394545-6267b664-8636-461f-8c27-a3e9525c5721.png">


## SELF-EVALUATION

This project was divided fairly and each member contributed with what it was asked. It helped us improve our java skills, understand how Design Patterns can help our code to be more efficient and the importance of testing.

Lara Bastos- 33,3%

Lia Sobral- 33,3%

Miguel Barros- 33,3%














