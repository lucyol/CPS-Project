## **Service**: Lemming

- **Types** : bool, int, enum Type {WALKER,FALLER,DIGGER,CLIMBER}, enum  Direction{RIGHT,LEFT}

- **Observators** : 
  - type : [Lemming] -> Type
  - direction : [Lemming] -> Direction
  - x : [Lemming] -> int 
  - y : [Lemming] -> int
  - gameEngine : [Lemming] -> GameEng
  - falling: [Lemming] -> int

- **Constructors** :
  - init: int * int -> [Lemming]

- **Operators** : 
  - step : [Lemming] -> [Lemming]
  - changeType : [Lemming] * Type -> [Lemming]
  - changeDir : [Lemming] -> [Lemming]


- **Observations** :
  - [inv]

  - [init]
    - type(init(x,y)) = WALKER
    - direction(init(x,y)) = RIGHT
    - x(init(x,y)) = x
    - y(init(x,y)) = y
    - gameEngine(init(x,y)) = null
    - falling(init(x,y)) = 0

  - [changeType]
    - type(changeType(L,t) = t
    - direction(changeType(L,t) = direction(L)
    - x(changeType(L,t)) = x(L)
    - y(changeType(L,t)) = y(L)
    - falling(changeType(L,t)) = falling(L)

  - [changeDir]
    - type(changeDir(L,t) = type(L)
    - if direction(L) == LEFT then direction(changeDir(L,t) = RIGHT else  direction(changeDir(L,t) = LEFT
    - x(changeDir(L,t)) = x(L)
    - y(changeDir(L,t)) = y(L)
    - falling(changeDir(L,t)) = falling(L)

  - [step]
    - if type(L) == WALKER then
      	 -if GameEng::obstacle(gameEng(L),x(L),y(L)+1) == false then 
	    - type(step(L)) = FALLER
	    - direction(step(L)) = direction(L)
	    - x(step(L)) = x(L)
	    - y(step(L)) = y(L)
	    - falling(step(L)) = 0
	 -else if direction(L) == RIGHT then
	    -if GameEng::obstacle(gameEng(L),x(L)+1,y(L)-1) == true || 
	       GameEng::obstacle(gameEng(L),x(L)+1,y(L)) == true && GameEng::obstacle(gameEng(L),x(L)+1,y(L)-2) == true then 
	          - type(step(L)) = WALKER
		  - direction(step(L)) = LEFT	    
		  - x(step(L)) = x(L)
	    	  - y(step(L)) = y(L)
		  - falling(step(L)) = 0
	    -else if GameEng::obstacle(gameEng(L),x(L)+1,y(L)) == true 
	    	    && GameEng::obstacle(gameEng(L),x(L)+1,y(L)-1) == false
		    && GameEng::obstacle(gameEng(L),x(L)+1,y(L)-2) == false then			    	    	  
		       - type(step(L)) = WALKER
		       - direction(step(L)) = RIGHT	    
		       - x(step(L)) = x(L)+1
	    	       - y(step(L)) = y(L)-1
		       - falling(step(L)) = 0
	    -else if GameEng::obstacle(gameEng(L),x(L)+1,y(L)) == false 
	    	    && GameEng::obstacle(gameEng(L),x(L)+1,y(L)-1) == false then
		       - type(step(L)) = WALKER
		       - direction(step(L)) = RIGHT	    
		       - x(step(L)) = x(L) + 1
	    	       - y(step(L)) = y(L) 
		       - falling(step(L)) = 0
         -else if type(L) == LEFT then idem

     - if type(L) == FALLER then
       	  -if GameEng::obstacle(gameEng(L),x(L),y(L)+1) == true && falling(L) < 8 then
	     - type(step(L)) = WALKER
	     - direction(step(L)) = direction(L)
	     - x(step(L)) = x(L)
	     - y(step(L)) = y(L)
	     - falling(step(L)) = 0
	  -else if GameEng::obstacle(gameEng(L),x(L),y(L)+1) == true && falling(L) >= 8 then
	     - gameEngine(step(L)) = GameEng::kill(L)
	  -else if GameEng::obstacle(gameEng(L),x(L),y(L)+1) == false then
	     - type(step(L)) = FALLER
	     - direction(step(L)) = direction(L)
	     - x(step(L)) = x(L)
	     - y(step(L)) = y(L) + 1
	     - falling(step(L)) = falling(step(L)) + 1