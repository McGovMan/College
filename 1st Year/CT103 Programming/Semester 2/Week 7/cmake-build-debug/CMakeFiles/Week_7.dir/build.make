# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.13

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /home/conor/Downloads/clion-2018.3.4/bin/cmake/linux/bin/cmake

# The command to remove a file.
RM = /home/conor/Downloads/clion-2018.3.4/bin/cmake/linux/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = "/home/conor/Documents/Git/Programming-Labs/Semester 2/Week 7"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "/home/conor/Documents/Git/Programming-Labs/Semester 2/Week 7/cmake-build-debug"

# Include any dependencies generated for this target.
include CMakeFiles/Week_7.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Week_7.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Week_7.dir/flags.make

CMakeFiles/Week_7.dir/main.c.o: CMakeFiles/Week_7.dir/flags.make
CMakeFiles/Week_7.dir/main.c.o: ../main.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="/home/conor/Documents/Git/Programming-Labs/Semester 2/Week 7/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/Week_7.dir/main.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/Week_7.dir/main.c.o   -c "/home/conor/Documents/Git/Programming-Labs/Semester 2/Week 7/main.c"

CMakeFiles/Week_7.dir/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/Week_7.dir/main.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "/home/conor/Documents/Git/Programming-Labs/Semester 2/Week 7/main.c" > CMakeFiles/Week_7.dir/main.c.i

CMakeFiles/Week_7.dir/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/Week_7.dir/main.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "/home/conor/Documents/Git/Programming-Labs/Semester 2/Week 7/main.c" -o CMakeFiles/Week_7.dir/main.c.s

# Object files for target Week_7
Week_7_OBJECTS = \
"CMakeFiles/Week_7.dir/main.c.o"

# External object files for target Week_7
Week_7_EXTERNAL_OBJECTS =

Week_7: CMakeFiles/Week_7.dir/main.c.o
Week_7: CMakeFiles/Week_7.dir/build.make
Week_7: CMakeFiles/Week_7.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="/home/conor/Documents/Git/Programming-Labs/Semester 2/Week 7/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable Week_7"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/Week_7.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Week_7.dir/build: Week_7

.PHONY : CMakeFiles/Week_7.dir/build

CMakeFiles/Week_7.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/Week_7.dir/cmake_clean.cmake
.PHONY : CMakeFiles/Week_7.dir/clean

CMakeFiles/Week_7.dir/depend:
	cd "/home/conor/Documents/Git/Programming-Labs/Semester 2/Week 7/cmake-build-debug" && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" "/home/conor/Documents/Git/Programming-Labs/Semester 2/Week 7" "/home/conor/Documents/Git/Programming-Labs/Semester 2/Week 7" "/home/conor/Documents/Git/Programming-Labs/Semester 2/Week 7/cmake-build-debug" "/home/conor/Documents/Git/Programming-Labs/Semester 2/Week 7/cmake-build-debug" "/home/conor/Documents/Git/Programming-Labs/Semester 2/Week 7/cmake-build-debug/CMakeFiles/Week_7.dir/DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/Week_7.dir/depend

