cmake_minimum_required(VERSION 3.16)
set(APP_NAME syruse_layer_compositor)
project(${APP_NAME} VERSION 0.1 LANGUAGES CXX)

include(CMakePrintHelpers)

find_package(Qt6 REQUIRED COMPONENTS Core Gui Qml Quick)

set(CMAKE_AUTOMOC ON)
set(CMAKE_AUTORCC ON)
set(CMAKE_AUTOUIC ON)

file(GLOB_RECURSE HEADERS "${CMAKE_SOURCE_DIR}/include/*.h")
file(GLOB_RECURSE SOURCES "${CMAKE_SOURCE_DIR}/src/*.cpp")
file(GLOB_RECURSE QRC "${CMAKE_SOURCE_DIR}/qml/*.qrc")
#                      "${CMAKE_SOURCE_DIR}/translation/*.qrc")
file(GLOB_RECURSE QMLFILES "${CMAKE_SOURCE_DIR}/qml/*.qml")

qt_add_resources(APP_RESOURCES ${QRC})
qt_add_executable(${APP_NAME} ${HEADERS} ${SOURCES} ${APP_RESOURCES})

qt_add_qml_module(${APP_NAME}
    URI "${APP_NAME}_module"
    VERSION 1.0
    QML_FILES ${QMLFILES}
    RESOURCES ${APP_RESOURCES}
)

target_link_libraries(${APP_NAME}
    PRIVATE
        Qt6::Core
        Qt6::Gui
        Qt6::Qml
        Qt6::Quick
        ${MODULES_LDFLAGS}
)

install(TARGETS ${APP_NAME}
    DESTINATION /usr/bin/
)
