CPP=javac


all: main

main : model_class view_class main_class

model_class : model/*.java
	$(CPP) model/*.java

view_class : view/Partie.java
	$(CPP) view/Partie.java

main_class : main/Main.java
	$(CPP) main/Main.java



clean :
	rm model/*.class
	rm view/*.class
	rm main/*.class

