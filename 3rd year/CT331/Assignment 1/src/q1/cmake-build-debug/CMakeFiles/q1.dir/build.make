# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.17

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

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
CMAKE_COMMAND = /var/lib/snapd/snap/clion/129/bin/cmake/linux/bin/cmake

# The command to remove a file.
RM = /var/lib/snapd/snap/clion/129/bin/cmake/linux/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = "/home/conor/Documents/College/3rd year/CT331/CT331_Assignment1/src/q1"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "/home/conor/Documents/College/3rd year/CT331/CT331_Assignment1/src/q1/cmake-build-debug"

# Include any dependencies generated for this target.
include CMakeFiles/q1.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/q1.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/q1.dir/flags.make

CMakeFiles/q1.dir/assignment.c.o: CMakeFiles/q1.dir/flags.make
CMakeFiles/q1.dir/assignment.c.o: ../assignment.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="/home/conor/Documents/College/3rd year/CT331/CT331_Assignment1/src/q1/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/q1.dir/assignment.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/q1.dir/assignment.c.o   -c "/home/conor/Documents/College/3rd year/CT331/CT331_Assignment1/src/q1/assignment.c"

CMakeFiles/q1.dir/assignment.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/q1.dir/assignment.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "/home/conor/Documents/College/3rd year/CT331/CT331_Assignment1/src/q1/assignment.c" > CMakeFiles/q1.dir/assignment.c.i

CMakeFiles/q1.dir/assignment.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/q1.dir/assignment.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "/home/conor/Documents/College/3rd year/CT331/CT331_Assignment1/src/q1/assignment.c" -o CMakeFiles/q1.dir/assignment.c.s

# Object files for target q1
q1_OBJECTS = \
"CMakeFiles/q1.dir/assignment.c.o"

# External object files for target q1
q1_EXTERNAL_OBJECTS =

q1: CMakeFiles/q1.dir/assignment.c.o
q1: CMakeFiles/q1.dir/build.make
q1: CMakeFiles/q1.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="/home/conor/Documents/College/3rd year/CT331/CT331_Assignment1/src/q1/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable q1"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/q1.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/q1.dir/build: q1

.PHONY : CMakeFiles/q1.dir/build

CMakeFiles/q1.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/q1.dir/cmake_clean.cmake
.PHONY : CMakeFiles/q1.dir/clean

CMakeFiles/q1.dir/depend:
	cd "/home/conor/Documents/College/3rd year/CT331/CT331_Assignment1/src/q1/cmake-build-debug" && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" "/home/conor/Documents/College/3rd year/CT331/CT331_Assignment1/src/q1" "/home/conor/Documents/College/3rd year/CT331/CT331_Assignment1/src/q1" "/home/conor/Documents/College/3rd year/CT331/CT331_Assignment1/src/q1/cmake-build-debug" "/home/conor/Documents/College/3rd year/CT331/CT331_Assignment1/src/q1/cmake-build-debug" "/home/conor/Documents/College/3rd year/CT331/CT331_Assignment1/src/q1/cmake-build-debug/CMakeFiles/q1.dir/DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/q1.dir/depend
