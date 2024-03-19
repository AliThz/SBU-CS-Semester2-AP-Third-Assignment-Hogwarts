# Hogwarts

AP Third Assignment

## Description

Hogwarts School of Witchcraft and Wizardry Management System

## Classes

### Person Class

* Includes the attributes and behaviours that Assistant, Professor and Student have in common.
* Every person has an account and through this attribute they all can change their credentials. 

### Professor Class

* Including all the things that a professor would do.
* taking courses, scoring students, viewing courses, etc .

### Student Class

* Here at Hogwarts, all the students should be sorted into houses when they are first years. There are four houses here based on the four founders of this school.
* So alongside the specific fields and methods that student has we add a sort method into this class.

### Assistant Class

* Including administrative tools.
* Since only admins can add other admins, after running the program we have an initial admin account with username "ali" and password "ali".

### Course Class

* We have two kind of course lists in this project. The first one is for the objects only including the title and the second one is the one with title, a professor assigned to it and some students taking it. The first kind is used when we just want to consider what courses does hogwarts provide and the second kind represent a class that is going to be held. Actually there a master-detail relationship between our entities but for making the project easier we combine master class and detail class. 

### Message Class

* Every person has a list of messages and through Hogwarts class we can have an internal messaging system at the school alongside using owls.

### Hogwarts Class

* It can be the combination of a few classes that is better to be implemented separately.
* Because we didn't use any external resources for saving data, we have few static variables in this class.

### Account Class

* We manage people's credentials here.

### Main Class

* Designing in terminal :)

## About using the project

* If you are using Intellij, after opening the project click (ctrl) + (shift) + (-) to fold regions and make it easier to trace the code.
* Professors don't have access to do nearly anything in their dashboard panel right after signing up. After signing up, an admin should approve the professor's account in him/her own dashboard.
* It is simillar when professors request a course. It needs an admin approval to be added to the courses of the school.

## Thanks to

* [Stack Over Flow](https://stackoverflow.com)
* [Mahan Madani](https://github.com/Mahan-M47)
