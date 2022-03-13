cmake_minimum_required(VERSION 3.16)
project(assignment_3 C)

set(CMAKE_C_STANDARD 11)

add_executable(assignment_3 main.c)
target_link_libraries(assignment_3 m)