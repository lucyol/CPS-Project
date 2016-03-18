### **Service**:  Level
- **Types**: bool, int , enum Nature {EMPTY,DIRT,METAl} 

- **Observators**:
  - const height : [Level] -> int
  - const width : [Level] -> int
  - editing : [Level] -> bool
  - nature : [Level] * int * int -> Nature
  - entranceX : [Level] -> int
  - entranceY: [Level] -> int 
  - exitX : [Level] -> int
  - exitY : [Level] -> int  

- **Constructors** :
  - init : int x int -> [Level] 
    - pre init(h,w) require h > 5 & w > 15

- **Operators**: 
  - setNature : [Level] * int * int * Nature -> [Level]
        - pre: setNature(L,x,y,n) require editing(L)==true & 0 <= x <= width(L) & 0 <= y <= height(L)
  - goPlay : [Level] * int * int * int * int -> [Level]
        - pre: goPlay(L,xe,ye,xs,ys) require  for all i in [0.. width()] & j in [0..height] nature(i.x,i.y)=METAL & nature(j.x,j.y)=METAL        	                                & 0 <= xe <= width(L) & 0 <= ye <= height(L) & 0 <= xs <= width(L) & 0 <= ys <= height(L)
	       			     	      & nature(L, xe, ye) = EMPTY & nature(L, xs, ys) = EMPTY
	       			     	      & nature(L, xe, ye - 1) = EMPTY & nature(L, xe, ye + 1) = EMPTY
					      & nature(L, xs, ys + 1) = EMPTY & nature(L, xs, ys + 1) = METAL 
  - remove : [Level] x int x int -> [Level]
        - pre: remove(L,x,y) require nature(L,x,y)= DIRT & editing(L)==false & 0 <= x <= width(L) & 0 <= y <= height(L)
  - build : [Level] x int x int -> [Level]
        - pre: build(L,x,y) require nature(L,x,y)= EMPTY & editing(L)==false & 0 <= x <= width(L) & 0 <= y <= height(L)
	       		    	     & x != entranceX(L) & x != exitX(L)
				     & y != entranceY(L) & y != exitY(L) & y != exitY(L) + 1 
- **Observations**:
  - [inv]
        - height(L) > 0
        - width(L) > 0 
  - [init]
        - height(init(h,w)) = h
        - width(init(h,w)) = w
        - editing(init(h,w)) = true
	- entranceX(init(h,w)) = null
	- entranceY(init(h,w)) = null
	- exitX(init(h,w)) = null
	- exitY(init(h,w)) = null
	- nature(init(h,w),x,y) = EMPTY
	
  - [setNature]
        - editing(setNature(l,x,y,n))=true
        - nature(setNature(l,x,y,n),x,y) = n 
	- nature(setNature(l,x,y,n),z,w) = nature(l,z,w) for (z,w)!=(x,y)
	- entranceX(setNature(l,x,y)) = entranceX(l,x,y)
	- entranceY(setNature(l,x,y)) = entranceY(l,x,y)
	- exitX(setNature(l,x,y)) = exitX(l,x,y)
	- exitY(setNature(l,x,y)) = exitY(l,x,y)

  - [goPlay]
        - editing(goPlay(L,xe,ye,se,ye)) = false
        - nature(goPlay(L,xe,ye,se,ye),x,y) = nature(L,x,y) 	
	- entranceX(goPlay(L,xe,ye,se,ye)) = xe
	- entranceY(goPlay(L,xe,ye,se,ye)) = ye
	- exitX(goPlay(L,xe,ye,se,ye)) = xs
	- exitY(goPlay(L,xe,ye,se,ye)) = ys

  - [remove]
        - editing(remove(l,x,y))=false
        - nature(remove(l,x,y),x,y)= EMPTY
	- nature(remove(l,x,y),i,j)= nature(l,i,j) for (i,j) != (x,y)	
	- entranceX(remove(l,x,y)) = entranceX(l,x,y)
	- entranceY(remove(l,x,y)) = entranceY(l,x,y)
	- exitX(remove(l,x,y)) = exitX(l,x,y)
	- exitY(remove(l,x,y)) = exitY(l,x,y)

  - [build]
        - editing(build(l,x,y)) = false
        - nature(build(l,x,y),x,y)= DIRT
	- nature(build(l,x,y),i,j)= nature(l,i,j) for (i,j) != (x,y)	
	- entranceX(build(l,x,y)) = entranceX(l,x,y)
	- entranceY(build(l,x,y)) = entranceY(l,x,y)
	- exitX(build(l,x,y)) = exitX(l,x,y)
	- exitY(build(l,x,y)) = exitY(l,x,y)





