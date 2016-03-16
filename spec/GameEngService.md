## **Service**:  GameEng
- **Types**: bool, int, float, Level, Lemming
- **Use**: Level, Lemming

- **Observators**:
  - obstacle : [GameEng] x int x int -> bool 
    - pre: obstacle(G,i,j) require i < Level::height(L) and j < Level::width(L) 
  - const sizeColony : [GameEng] -> int
  - nbTurns :[GameEng] -> int
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
  - init : sc x sp -> [GameEng]
    - pre init(sc,sp) require sc >0 & sp>0


- **Operators**:
  - step : [GameEng] -> [GameEng]
    - pre step(G) require gameOver(G) = false
  - spawn : [GameEng] -> [GameEng]
    - pre: spawn(G) require spawned(G) < sizeColony(G)

- **Observations**:
  - [inv]
    - spawned(G) = card(lemmings(G)) + saved(G) + dead(G)

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
     - nbTurns(step(G)) = nbTurns(G) + 1

   - [spawn]
     - 
     

