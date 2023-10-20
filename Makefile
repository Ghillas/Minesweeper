CPP=javac


all: main

main : model_class view_class

model_class : model/*.java
	$(CPP) model/*.java

view_class : view/*.java
	$(CPP) view/*.java



clean :
	rm model/*.class
	rm view/*.class

