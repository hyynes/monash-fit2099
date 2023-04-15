# FIT2099 Assignment (Semester 1, 2023)
# Elden Ring

## CL_Lab05Team06
Contribution Log:
https://docs.google.com/spreadsheets/d/1pIWJ8laYJ-FQm4gyEYbiYlRpXRPEwZ3uXHorO8FAVpQ/edit?usp=sharing

Team members:
- Kenan Baydar
- Danny Duong

## Design Rationale
REQ1:

All the environments, Graveyard, Gust of Wind and Puddle Of Water are designed with new classes that extend the
ground abstract class since they will be ground entities. They have an association relationship with its corresponding 
enemies it spawns, where 1 environment can make 0 to multiple enemies of the same type. The different enemies and 
environments are designed to be placed in different classes to follow the Single Responsibility Principle (SRP) in
SOLID, where classes of environments and enemies are broken down into smaller and focused classes. This also 
avoids repeating methods, following the OOP principle DRY.



Heavy skeleton swordsman will extend from the Pile of Bones class. It will check whether the pile of bones state is 
true, which is if the heavy skeleton swordsman has no more health, and return true if so. The pile of bones class will 
have a method implementing the pile of bones state. The pile of bones state checks whether the actor has no health, 
which then can cause the actor to enter a do nothing state using the DoNothingAction class where a 3 turn timer is
activated. This will cause the heavy skeleton swordsman to enter a DoNothingAction state, and if dealt 1 damage from an actor within 3 turns,
will be executed from DeathAction, dropping the Grossmesser. 

An additional class 'PileOfBones' is implemented in our design to follow the OOP principle DRY, where this class 
could be used again when implementing a Skeletal Bandit in REQ5, rather than repeating a same method.

All environments and enemies are encapsulated separately into 'environments' and 'enemies' allowing the code to be 
organised.
