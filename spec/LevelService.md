### **Service**:  Level
- **Types**: bool, int , enum Nature {EMPTY,DIRT,METAl} 

- **Observators**:
  - const height : [Level] -> int
  - const width : [Level] -> int
  - editing : [Level] -> bool
  - nature : [Level] x int x int -> Nature

- **Constructors** :
  - init : int x int -> [Level] 
    - pre init(h,w) require h> 10 & w >15

- **Operators**: 
  - setNature : [Level] x int x int x Nature -> [Level]
        - pre: setNature(x,y,n) require editing()==true & n in Nature	
  - goPlay : [Level] -> [Level]
        - pre: goPlay require   for all i in [0.. width()] & j in [0..height] nature(i.x,i.y)=METAL & nature(j.x,j.y)=METAL
  - remove : [Level] x int x int -> [Level]
        - pre: remove(x,y) require nature(x,y)= DIRT
  - build : [Level] x int x int -> [Level]
        - pre: build(x,y) require nature(x,y)= EMPTY

- **Observations**:
  - [inv]
        - height>0
        - width>0
  - [init]
        - height(init(h,w))=h
        - width(init(h,w))=w
        - editing(init(h,w))=editing()
        - nature(init(h,w),x,y)=nature(x,y)
  - [setNature]
        - editing(setNature(l,x,y,n))=true
        - nature(setNature(l,x,y,n))=nature(l,x,y) in Nature
  - [goPlay]
        - editing(goPlay(l))=false
        - nature(goPlay(l),x,y)=nature(l,x,y) in Nature
  - [remove]
        - editing(remove(l,x,y))=false
        - nature(remove(l,x,y))=nature(l,x,y)=Nature.EMPTY
  - [build]
        - editing(build(l,x,y))=false
        - nature(build(l,x,y))=nature(l,x,y)=Nature.DIRT





