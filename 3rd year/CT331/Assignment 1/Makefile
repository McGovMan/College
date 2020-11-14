
CFLAGS=-Wall -g
CC = cc

#This make rule ensures that all targets in the src/ directory
#are compiled with the CFLAGS flags and the output is put into
#the bin/ directory
#(eg. running "make all" creates bin/out)
#(you can then run the file with ./bin/out)
#
#This approach allows:
# 1. .gitignore to prevent any compiled files being accidentally added to the repository.
# 2. Compiling all files in src/q*/ at once without explicitly writing them out.

.PHONY: question1
question1: $(wildcard src/q1/*.c)
	$(CC) $(CFLAGS) -o bin/q1 $(wildcard src/q1/*.c)

.PHONY: question2
question2: $(wildcard src/q2/*.c)
	$(CC) $(CFLAGS) -o bin/q2 $(wildcard src/q2/*.c)

.PHONY: question3
question3: $(wildcard src/q3/*.c)
	$(CC) $(CFLAGS) -o bin/q3 $(wildcard src/q3/*.c)


#This make rule empties out the bin/ directory
#Useful when testing make, building from scratch,
#or pushing to git (though .gitignore should prevent
#any files in bin/ being commited and accidentally pushed)
clean:
	rm -rf bin/*
	touch bin/.gitkeep
