cmake_minimum_required(VERSION 3.17)
project(q3 C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(q3
        assignment.c
        genericLinkedList.c
        genericLinkedList.h
        tests.c
        tests.h)
