cmake_minimum_required(VERSION 3.22.1)
project(jarvis_native LANGUAGES CXX)
add_library(jarvis_native SHARED native_stub.cpp)
target_compile_features(jarvis_native PRIVATE cxx_std_17)
