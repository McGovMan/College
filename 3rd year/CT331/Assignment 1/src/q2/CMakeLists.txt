cmake_minimum_required(VERSION 3.17)
project(q2 C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(q2
        assignment.c
        linkedList.c
        linkedList.h
        tests.c
        tests.h)
