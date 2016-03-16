## **Service**: Lemming

- **Types** : bool, int, enum Type {WALKER,FALLER,DIGGER,CLIMBER}, enum  Direction{RIGHT,LEFT}

- **Observators** : 
  - type : [Lemming] -> Type
  - direction : [Lemming] -> Direction

- **Constructors** :
  - init: int * int -> [Lemming]

- **Operators** : 
  - action : [Lemming] -> [Lemming]
  - changeType : [Lemming] * Type -> [Lemming]
  - changeDir : [Lemming] -> [Lemming]


- **Observations** :
  - [inv]
  - [init]
    - type(init()) = WALKER
    - direction(init()) = RIGHT
  - [action]

  - [changeType]
    - type(changeType(L,t) = t
    - direction(changeType(L,t) = direction(L)
  - [changeDir]
    - type(changeDir(L,t) = type(L)
    - direction(changeDir(L,t) = RIGHT if direction(L) = LEFT
    - direction(changeDir(L,t) = LEFT if direction(L) = RIGHT