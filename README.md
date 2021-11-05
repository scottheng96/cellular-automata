# cellular-automata

### Overview

Cellular automation is a discrete model of computation studied in automata theory. It consists of a regular grid of cells, each with 
a finite number of states, and the grid can be in any finite number of dimensions. Check out this [wiki page](https://en.wikipedia.org/wiki/Cellular_automaton) for more information about it.

I've created 3 simulations respectively:

- Conway's Game Of Life 
- War-Tor
- Forest Fire

<p float="left">
  <img src="https://github.com/scottheng96/cellular-automata/blob/master/admin/gol-sim.png" alt="Game Of Life" width="250"/> 
  <img src="https://github.com/scottheng96/cellular-automata/blob/master/admin/wartor-sim.png" alt="War-Tor" width="250"/>
  <img src="https://github.com/scottheng96/cellular-automata/blob/master/admin/fire-sim.png" alt="Forest Fire" width="250"/>  
</p>         


These simulations can be toggled by changing the integer in App.java respectively here \
`CAController ca = new CAController(0);` 
where:
- 0 : Conway's Game Of Life
- 1 : War-Tor 
- 2 : Forest Fire

### Adding a new game
Code was written with abstraction and extensibility in mind. There are some limitations with the grid formulation and it is only currently possible to create simulations with square grids:

Steps to create a new game:
  1. Add the new game properties folder in '/resources' which includes: \
    - number of cell states \
    - initial number of cell states during simulation initialization \
    - colours of the states (hex code) \
  2. Add rules for the game \
    - add rules under '/model/{game-name}/rules' following rule conventions 
    - add rules to 'RuleSetFactory' incrementally
  3. Add colours to '/view/MapUtil.java' under 'getPropertiesMap' method, please add game index incrementally

# Notes

### 
### Future Changes
- Create extensibility for different cells and different grids
- Create UI to switch between simulations in real time

### Learnings
- Develop different designs before starting to write code
- If it is desired for the program to be config driven, keep that in mind during the definition of variables
- Building an MVC design, work on parts in isolation then intergration. Do not rush to build an MVP as it will hinder good design
