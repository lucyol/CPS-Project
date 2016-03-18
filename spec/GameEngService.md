## **Service**:  GameEng
- **Types**: bool, int, float, Level, Lemming
- **Use**: Level, Lemming

- **Observators**:
  - obstacle : [GameEng] * int * int -> bool 
    - pre: obstacle(G,i,j) require i < Level::height(level(G)) and j < Level::width(level(G)) 
  - const sizeColony : [GameEng] -> int
  - nbTurn :[GameEng] -> int
  - const spawnspeed : [GameEng] -> int
  - gameOver: [GameEng]-> bool
  - score: [GameEng] -> (float,int)
    - pre: score(G) require gameOver(G)
  - saved : [GameEng] -> int
  - spawned : [GameEng] -> int 
  - dead : [GameEng] -> int  
  - lemmings: [GameEng] -> Lemming Set
  - getLemming: [GameEng] * int -> [Lemming]
    - pre getLemming(G,i) require i >= 0 and card(lemmings(G)) > i
  - level : [GameEng] -> Level

- **Constructors**:
  - init : sc * sp -> [GameEng]
    - pre init(sc,sp) require sc >0 & sp>0


- **Operators**:
  - step : [GameEng] -> [GameEng]
    - pre step(G) require gameOver(G) = false
  - spawn : [GameEng] -> [GameEng]
    - pre: spawn(G) require spawned(G) < sizeColony(G)
  - kill : [GameEng] * Lemming -> [GameEng]
    - pre : kill(G,l) require l is in lemmings
  - save : [GameEng] * Lemming -> [GameEng]
    - pre: save(G,l) require l is in lemmings

- **Observations**:
  - [inv]
    - spawned(G) min= card(lemmings(G)) + saved(G) + dead(G)
    - gameOver(G) min= (card(lemmings(G)) == 0 && spawned(G) == sizeColony(G))
    - obstacle(G,x,y) min= Level::nature(level(G),x,y) != EMPTY

  - [init]
    - sizeColony(init(sc,sp)) = sc
    - nbTurn(init(sc,sp)) = 0
    - spawnspeed(init(sc,sp)) = sp
    - spawned(init(sc,sp)) = 0
    - saved(init(sc,sp)) = 0
    - dead(init(sc,sp)) = 0
    - gameOver(init(sc,sp)) = false 
    - lemmings(init(sc,sp)) = empty set

   - [step]
     - nbTurn(step(G)) = nbTurn(G) + 1

   - [spawn]
     - nbTurn(spawn(G)) = nbTurn(G)
     - saved(spawn(G)) = saved(G)
     - dead(spawns(G)) = dead(G) 
     - lemmings(spawn(G)) = lemmings(G)U{Lemming}

   - [kill]
     - nbTurn(kill(G,l)) = nbTurn(G)
     - saved(kill(G,l)) = saved(G)
     - dead(kill(G,l)) = dead(G) + 1
     - lemmings(kill(G,l)) = lemmings(G)\{l}

   - [save]
     - nbTurn(save(G,l)) = nbTurn(G)
     - saved(save(G,l)) = saved(G) + 1
     - dead(save(G,l)) = dead(G) 
     - lemmings(save(G,l)) = lemmings(G)\{l}  
     

